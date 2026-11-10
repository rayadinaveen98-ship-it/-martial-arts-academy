#!/usr/bin/env python3
"""Real Android emulator navigation + screenshot smoke test. Requires adb + emulator.
This uses actual UI coordinates from accessibility XML, not hard-coded screen taps.
"""
import os
import re
import subprocess
import time
import xml.etree.ElementTree as ET
from pathlib import Path

APK = "android-native/app/build/outputs/apk/debug/app-debug.apk"
OUT = Path("android-native/qa/screenshots")
ACTIVITY = "com.martialartsacademy.app/.MainActivity"


def adb(*args, check=True):
    return subprocess.run(["adb", *args], check=check, text=True,
                          stdout=subprocess.PIPE, stderr=subprocess.PIPE)


def dump_ui():
    for _ in range(4):
        try:
            adb("shell", "uiautomator", "dump", "/sdcard/window.xml")
            xml = adb("shell", "cat", "/sdcard/window.xml").stdout
            return ET.fromstring(xml)
        except (subprocess.CalledProcessError, ET.ParseError):
            time.sleep(1.0)
    raise RuntimeError("Android accessibility tree could not be read")


def find(root, wanted):
    wanted = wanted.casefold()
    for node in root.iter("node"):
        value = " ".join([node.attrib.get("text", ""), node.attrib.get("content-desc", "")]).casefold()
        bounds = node.attrib.get("bounds", "")
        if wanted in value and re.fullmatch(r"\[\d+,\d+\]\[\d+,\d+\]", bounds):
            x1, y1, x2, y2 = map(int, re.findall(r"\d+", bounds))
            if x2 > x1 and y2 > y1:
                return ((x1+x2)//2, (y1+y2)//2)
    return None


def tap_label(label, scroll=True):
    for _ in range(5 if scroll else 1):
        point = find(dump_ui(), label)
        if point:
            adb("shell", "input", "tap", str(point[0]), str(point[1]))
            time.sleep(2.0)
            return
        if not scroll:
            break
        adb("shell", "input", "swipe", "490", "1520", "490", "530", "350")
        time.sleep(1.0)
    raise AssertionError("Expected real Android UI label not visible: " + label)


def screenshot(name):
    OUT.mkdir(parents=True, exist_ok=True)
    data = subprocess.run(["adb", "exec-out", "screencap", "-p"],
                          check=True, stdout=subprocess.PIPE).stdout
    if not data.startswith(b"\x89PNG\r\n\x1a\n") or len(data) < 20000:
        raise RuntimeError("Invalid Android screenshot: " + name)
    target = OUT / name
    target.write_bytes(data)
    print("CAPTURED", target, len(data), "bytes", flush=True)


def main():
    assert os.path.isfile(APK), "No compiled native APK"
    adb("wait-for-device")
    adb("shell", "settings", "put", "system", "font_scale", "1.0")
    adb("install", "-r", APK)
    adb("shell", "am", "start", "-n", ACTIVITY)
    time.sleep(6)
    screenshot("01-onboarding.png")
    tap_label("ENTER THE ACADEMY")
    assert find(dump_ui(), "CONTINUE LEARNING"), "Home screen not visible after onboarding"
    screenshot("02-home.png")
    tap_label("CONTINUE LEARNING", scroll=False)
    assert find(dump_ui(), "SKILL STUDIO"), "Stance & Guard native studio did not open"
    screenshot("03-skill-studio.png")
    tap_label("ERRORS", scroll=False)
    assert find(dump_ui(), "Feet narrowing"), "Common-error tab failed to render"
    screenshot("04-common-errors.png")
    print("PASS: Installed debug APK, onboarding, Home, Stance Studio, Errors and screenshots.")


if __name__ == "__main__":
    main()
