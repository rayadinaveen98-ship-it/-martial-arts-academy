#!/usr/bin/env python3
"""Android emulator capture-only QA: ADB taps + PNGs, no UIAutomator.
Screenshots are evidence candidates, NOT proof that named screens were reached.
A human reviewer must inspect each image before marking visual QA as passed.
"""
import os
import re
import hashlib
import subprocess
import time
from pathlib import Path

APK = "android-native/app/build/outputs/apk/debug/app-debug.apk"
APP = "com.martialartsacademy.app/.MainActivity"
OUT = Path("android-native/qa/screenshots")


def adb(*args, timeout=90, check=True):
    return subprocess.run(["adb", *args], text=True, check=check, timeout=timeout,
                          stdout=subprocess.PIPE, stderr=subprocess.PIPE)


def capture(name):
    OUT.mkdir(parents=True, exist_ok=True)
    result = subprocess.run(["adb", "exec-out", "screencap", "-p"],
                            check=True, timeout=75, stdout=subprocess.PIPE)
    png = result.stdout
    if not png.startswith(b"\x89PNG\r\n\x1a\n") or len(png) < 18000:
        raise RuntimeError("Screenshot missing/invalid: " + name)
    path = OUT / name
    path.write_bytes(png)
    print("CAPTURED", name, len(png), "bytes", flush=True)
    return hashlib.sha256(png).hexdigest()


def tap(x, y):
    result = adb("shell", "input", "tap", str(round(x)), str(round(y)), check=False)
    print("TAP", round(x), round(y), "exit", result.returncode, flush=True)
    time.sleep(3)


def swipe(x1, y1, x2, y2):
    result = adb("shell", "input", "swipe", str(round(x1)), str(round(y1)),
                 str(round(x2)), str(round(y2)), "550", check=False)
    print("SWIPE", result.returncode, flush=True)
    time.sleep(3)


def dimensions():
    s = adb("shell", "wm", "size").stdout
    found = re.search(r"(\d+)x(\d+)", s)
    if not found:
        raise RuntimeError("Cannot determine emulator screen size: " + s)
    return tuple(map(int, found.groups()))


def record_diagnostics():
    OUT.mkdir(parents=True, exist_ok=True)
    lines = []
    for args in [
        ("shell", "pidof", "com.martialartsacademy.app"),
        ("shell", "dumpsys", "activity", "activities"),
        ("logcat", "-d", "-t", "600", "AndroidRuntime:E", "ActivityManager:W", "*:S"),
    ]:
        try:
            res = adb(*args, timeout=30, check=False)
            lines.append("COMMAND " + " ".join(args) + "\n" + res.stdout[-22000:] +
                         "\nERR " + res.stderr[-1500:])
        except Exception as exc:
            lines.append("COMMAND " + " ".join(args) + "\n" + repr(exc))
    path = OUT / "runtime-diagnostics.txt"
    path.write_text("\n\n".join(lines), encoding="utf8")
    print("SAVED DIAGNOSTICS", path, flush=True)


def main():
    assert os.path.isfile(APK), "Compiled debug APK absent"
    adb("wait-for-device", timeout=140)
    adb("shell", "settings", "put", "system", "font_scale", "1.0", check=False)
    adb("install", "-r", APK, timeout=140)
    launch = adb("shell", "am", "start", "-W", "-n", APP, timeout=90)
    print("LAUNCH", launch.stdout[-850:], flush=True)
    w, h = dimensions()
    print("SCREEN", w, h, flush=True)
    time.sleep(20)
    img1 = capture("01-onboarding-candidate.png")

    # Navigate via ADB-only touch input before software-emulator System UI ANRs.
    # Every capture is explicitly a CANDIDATE; no assertion of visual correctness.
    swipe(w*.5, h*.80, w*.5, h*.29)
    swipe(w*.5, h*.80, w*.5, h*.29)
    img2 = capture("02-after-scroll-candidate.png")
    tap(w*.5, h*.87)
    time.sleep(9)
    img3 = capture("03-home-candidate.png")
    tap(w*.5, h*.44)
    time.sleep(9)
    img4 = capture("04-skill-candidate.png")
    record_diagnostics()
    diagnostics = (OUT / "runtime-diagnostics.txt").read_text(encoding="utf8", errors="replace")
    if "Application Not Responding: com.android.systemui" in diagnostics:
        raise RuntimeError("Android System UI ANR detected. Screenshots saved, UI QA FAILED.")
    if img2 == img3 == img4:
        raise RuntimeError("Navigation candidates are identical: Home/Skill not verified. UI QA FAILED.")
    if len({img1, img2, img3, img4}) < 3:
        raise RuntimeError("Too few distinct screens for navigation evidence. UI QA FAILED.")
    print("CANDIDATE SCREENS DIFFER. Human screen identification and fidelity review are still required.")


if __name__ == "__main__":
    main()
