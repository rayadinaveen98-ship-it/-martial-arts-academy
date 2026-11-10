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

## Actual native onboarding capture — November 10, 2026

A delayed-image run [#42843030408](https://github.com/rayadinaveen98-ship-it/-martial-arts-academy/actions/runs/42843030408) captured **real Jetpack Compose onboarding** at approximately 25 seconds after launch, 1080×2400 px. The image shows the intended black/navy background, crimson active selection, visible orientation choices, legible typography and scrollable layout. This validates ONE app screen's rendering, not other screens, training correctness or device responsiveness.

At approximately 50 seconds, another image displayed **"System UI isn't responding"** over the same onboarding. The accessibility-dump command stalled and the run failed; the dialog names Android System UI, not the Martial Arts Academy process. Do not claim app crash from this alone. No Home/Skill Studio screenshots have yet passed review.

Next experiment: smaller AOSP API 30 emulation, **ADB touch input only** to capture onboarding-scroll, home candidate and skill candidate screens before the heavy UIAutomator service can interfere. Workflow success only means captures were saved—each destination must be manually inspected and accepted.

## Design parity findings — onboarding (real emulator image)

The first real native onboarding screenshot shows no obvious clipping in the visible top and middle sections; type, options, active crimson selection and contrast are legible. This is *functional foundation quality*, not yet the rich cinematic presentation in the owner's accepted concept renders. Notably the screen has a simple dark background and standard option cards, without the higher-fidelity atmosphere/character emphasis of the original direction. The bottom action is below the first viewport and requires scrolling; this is acceptable only if discoverable and accessible after device testing. **Owner visual sign-off remains pending.**

Do not "solve" this mismatch by placing the old generated mockup as one background image or by inventing an unreviewed trainer pose. Retain real Compose controls and the strict A01 reviewed-media gate.

## Lightweight emulator final result — 2026-11-10

The capture-only AOSP API 30 run [#42845729720](https://github.com/rayadinaveen98-ship-it/-martial-arts-academy/actions/runs/42845729720) finished with **workflow SUCCESS**: the script ran and uploaded screenshots and diagnostics. This is **NOT** a successful UI navigation or visual-parity test.

Evidence:
- 01-onboarding-candidate.png: native onboarding renders.
- 02-after-scroll-candidate.png, 03-home-candidate.png, 04-skill-candidate.png: later captures are all overlaid by the Android **System UI isn't responding** modal, with the same underlying onboarding screen rather than the intended destinations.
- runtime-diagnostics.txt: the current focus was Application Not Responding: com.android.systemui; Martial Arts Academy MainActivity remained the top underlying fullscreen app, and its process ID was present.

Therefore GitHub's non-accelerated Linux emulator is unreliable for input and navigation testing. No confirmed Martial Arts Academy process crash, but no proof the app responds normally to touches here either.

**Decision:** Stop retrying identical software emulators. Preserve working APK and code. Next useful visual test requires a responsive, hardware-accelerated emulator or physical Android device. Do not alter boxing lessons, trainer poses or curriculum to resolve a host System UI ANR.

**Open gate:** actual Home, Skill Studio, Errors, Media, Knowledge Check and Journey screenshots plus direct touch testing. Do not call capture-only workflow success an end-to-end app QA pass.
