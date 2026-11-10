"""Capture the actual Android UI; fail on missing portrait, ANR or repeated screens."""
import subprocess,time,hashlib,json,re,xml.etree.ElementTree as ET
from pathlib import Path
OUT=Path('android-native/qa/portrait');OUT.mkdir(parents=True,exist_ok=True)
APP='com.martialartsacademy.app'
def adb(*args,timeout=40):
 return subprocess.run(['adb',*args],check=True,stdout=subprocess.PIPE,stderr=subprocess.PIPE,timeout=timeout).stdout
def ui():
 adb('shell','uiautomator','dump','/sdcard/portrait-ui.xml')
 data=adb('shell','cat','/sdcard/portrait-ui.xml').decode();root=ET.fromstring(data)
 if any(x in data.lower() for x in ["isn't responding",'keeps stopping','system ui isn']):raise RuntimeError('Android ANR/crash dialog')
 return root,data
def find(root,text):
 for n in root.iter('node'):
  if text.casefold() in (n.get('text','')+' '+n.get('content-desc','')).casefold():
   b=list(map(int,re.findall(r'\d+',n.get('bounds',''))))
   if len(b)==4 and b[2]>b[0] and b[3]>b[1]:return b
def tap(text):
 for _ in range(7):
  root,_=ui();b=find(root,text)
  if b:
   adb('shell','input','tap',str((b[0]+b[2])//2),str((b[1]+b[3])//2));time.sleep(2);return
  adb('shell','input','swipe','360','1120','360','400','300');time.sleep(1)
 raise AssertionError('Missing Android control: '+text)
def capture(name):
 root,xml=ui();(OUT/(name+'.xml')).write_text(xml)
 png=adb('exec-out','screencap','-p');assert png.startswith(b'\x89PNG\r\n\x1a\n') and len(png)>20000
 (OUT/(name+'.png')).write_bytes(png);return hashlib.sha256(png).hexdigest()
try:
 adb('wait-for-device');adb('shell','wm','size','720x1440');adb('shell','wm','density','320')
 adb('install','-r','android-native/app/build/outputs/apk/debug/app-debug.apk',timeout=120)
 adb('shell','pm','clear',APP);adb('shell','am','start','-W','-n',APP+'/.MainActivity');time.sleep(4)
 tap('ENTER THE ACADEMY');home=capture('01-home')
 tap('CONTINUE LEARNING');time.sleep(2)
 hashes=[home];results=[]
 for width in [360,390,430]:
  adb('shell','wm','size',f'{width*2}x{width*4}');time.sleep(3)
  # The full portrait card fits after scrolling the lesson heading off-screen.
  for _ in range(8):
   root,_=ui();b=find(root,'Instructor A01 standing neutrally')
   print('PORTRAIT',width,'bounds',b,'density',adb('shell','wm','density').decode(),flush=True)
   if b and b[3]-b[1]>=620 and b[1]>=100 and b[3]<width*4-100:break
   if b and b[1]<100:
    adb('shell','input','swipe',str(width),'450',str(width),'700','300')
   else:
    adb('shell','input','swipe',str(width),'900',str(width),'650','300')
   time.sleep(1)
  root,_=ui();b=find(root,'Instructor A01 standing neutrally')
  name=f'02-skill-{width}dp';hashes.append(capture(name));results.append({'width_dp':width,'portrait_bounds_px':b})
  assert b and b[3]-b[1]>=620,'Full neutral portrait not visible'
  assert find(root,'APPROVED NEUTRAL APPEARANCE'),'Portrait caption missing'
 assert len(set(hashes))==len(hashes),'Repeated screenshots do not establish navigation'
 (OUT/'result.json').write_text(json.dumps({'app':APP,'screenshots':results,'status':'Android layout checks passed; human image review still required','sha256':hashes},indent=2))
finally:
 for name,args in [('activity',['shell','dumpsys','activity','activities']),('errors',['logcat','-d','-t','500','AndroidRuntime:E','ActivityManager:W','*:S'])]:
  try:(OUT/(name+'.txt')).write_bytes(adb(*args))
  except Exception as e:(OUT/(name+'.txt')).write_text(str(e))