const fs=require('node:fs');
const vm=require('node:vm');
const assert=require('node:assert/strict');
const html=fs.readFileSync(__dirname+'/index.html','utf8');
const js=html.match(/<script>([\s\S]*?)<\/script>/);
assert.ok(js,'inline interaction script exists');
new vm.Script(js[1]);
for(const id of ['main-person','v-angle-name','zoom','compare','collage','material-image','material-title','checks','notes','copy-review','export-review','reset-review','status','bar']) assert.ok(html.includes('id="'+id+'"'),'required control '+id);
for(const angle of ['front','side','back','quarter']) assert.ok(html.includes('data-angle="'+angle+'"'),'angle button '+angle);
for(const tab of ['views','details','review']) assert.ok(html.includes('data-tab="'+tab+'"'),'tab '+tab);
const imgs=(html.match(/data:image\/webp;base64,[A-Za-z0-9+/=]+/g)||[]);
assert.ok(imgs.length>=10,'embedded art assets present');
for(const img of imgs){const s=img.split(',')[1];assert.ok(Buffer.from(s,'base64').subarray(0,4).toString('ascii')==='RIFF','embedded WebP integrity');}
assert.ok(html.includes('NO REAL 3D MESH OR RIG EXISTS'),'truthful status label');
assert.ok(html.includes('concept only / unapproved'),'no certification claim');
assert.ok(!html.match(/https?:\/\/[^"\s]+\.js/),'no third-party JS runtime dependency');
console.log('PASS: markup, controls, embedded views, WebP integrity, JS syntax and C0 status labels.');
