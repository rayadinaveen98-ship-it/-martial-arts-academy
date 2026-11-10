# 19 — Native Android visual QA gate

**Date:** November 10, 2026  
**Scope lock:** Only native UI verification and fixes required to match the accepted Boxing Foundations experience. No new disciplines, physical pose generators, AI technique scoring, added commercial features or 3D movement production.

## Prerequisite already passed
- Actual native Kotlin + Compose debug APK compiled: GitHub Actions run [42833209925](https://github.com/rayadinaveen98-ship-it/-martial-arts-academy/actions/runs/42833209925), successful Gradle unit tests and `assembleDebug`.
- APK archive integrity and SHA-256 recorded in [18-NATIVE-ANDROID-CI-PASS.md](18-NATIVE-ANDROID-CI-PASS.md).
- Instructional trainer motion remains BLOCKED pending C1 actual rig and coach-reviewed media.

## Emulator attempts reviewed
1. [42834235117](https://github.com/rayadinaveen98-ship-it/-martial-arts-academy/actions/runs/42834235117) — Android Google APIs x86_64 system image unpack failure. No app test executed.
2. [42834552259](https://github.com/rayadinaveen98-ship-it/-martial-arts-academy/actions/runs/42834552259) — AOSP API 34 image and APK built; 1080×2400 screenshot captured but showed **Android startup splash only**. UIAutomator could not read screen controls.
3. [42834635042](https://github.com/rayadinaveen98-ship-it/-martial-arts-academy/actions/runs/42834635042) — second AOSP run also captured only launch splash; accessibility extraction failed. These failures are insufficient to determine native UI fidelity or whether the app itself is slow/crashing.
4. New diagnostic run triggered by commit `a0cd652ecca281ff155bb13dd2dd2d7dc924b59c` — captures delayed screenshots at 25/50 seconds after start, a device/activity/logcat diagnostic report and a bounded UI dump. **Outcome pending at authoring.**

## Acceptance when evidence available
- Onboarding: legible dark/crimson design at actual phone size, all choices visible and touchable, no clipping.
- Home: one prominent Continue action, 3 sequential lessons, no fake skill mastery or invented XP.
- Stance Skill Studio: no rejected SVG motion, A01 portrait only labelled decorative, four readable conceptual stages, expandable reasoning and error descriptions, accurate media-review status.
- Knowledge Check: cannot bypass learning gate; feedback useful; success unlocks only next concept lesson.
- Journey: records comprehension and demo timer completions honestly, notes survive app restart.
- Timer: counts correctly; background and screen changes pause; stop grants no completion.
- Screens: capture real emulator screenshots (not renders/mockups), ideally onboarding, Home, Stance Study, Errors, Media Status, Knowledge Check and Journey; compare spacing, type size and contrast against accepted web V0.3.
- No crash or uncaught runtime exception, reasonable cold start, accessibility and reduced-motion review.

## No unsupported quality claim
A successful compilation is not sufficient to mark Android visual QA as passed. A screenshot of the **splash** is not an app screenshot. A passing UI automation script alone is not substitute for human inspection of the actual rendered frames. The next owner approval gate is **real screenshots plus an installable build**.
