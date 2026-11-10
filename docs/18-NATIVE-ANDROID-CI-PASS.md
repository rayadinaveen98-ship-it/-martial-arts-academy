# 18 — Native Android build validation (2026-11-10)

## Real compiled output
- **GitHub Actions run:** [Native Android debug validation #42833209925](https://github.com/rayadinaveen98-ship-it/-martial-arts-academy/actions/runs/42833209925)
- **CI commit:** `5ce8a151b1f272a1b931da9da3cd15e8dd34c3e6`.
- **Conclusion:** SUCCESS.
- **Passed steps:** Android SDK setup, Gradle setup, `gradle :app:testDebugUnitTest :app:assembleDebug --stacktrace`, artifact upload.
- **Artifact:** `martial-arts-academy-native-debug`, artifact ID `13772487348`, approx. 10 MB ZIP, auto-expires 2026-11-17.
- **Inside artifact:** `app-debug.apk`, uncompressed size `10,827,947` bytes.
- **Extracted APK SHA-256:** `5440061a3e80c5c49993771d31cc646c9f566e2bdb54de66defa8cab4e53b9fd`.
- **Integrity:** ZIP contents of APK verified using `unzip -t`; valid Android package identified.

## Root cause of earlier CI failures
Initial workflow used `android-actions/setup-android@v3`, whose `sdkmanager tools` command fails because the obsolete Android SDK package `tools` is unavailable. The immediate retry failed because `sdkmanager` was not on PATH. The successful workflow locates SDK manager in the runner's `$ANDROID_HOME/cmdline-tools` tree, installs SDK 36, and invokes Gradle 8.14 directly.

## Honest status distinctions
- **Build and JVM unit test:** passed.
- **APK generated and extracted:** passed.
- **APK installed on a physical Android device:** NOT VERIFIED.
- **Native Compose UI visually verified in Android emulator:** pending separate smoke workflow.
- **A01 actual 3D mesh / approved technique videos:** not part of this build.
- **Production signing, release bundle, Play Store readiness:** not attempted.

## What the APK contains
The previously implemented source set: Compose Home, Skill Studio, 3 concept lessons × 4 steps, text/error/media tabs, quiz gating, progress, local notes, Journey, profile and an illustrative timer. The rejected procedural pose animation is not included. A01 neutral portrait is concept-only.

## Next required checks
1. Run actual emulator install, first-run navigation and screenshot workflow (real device rendering).
2. Assess layout/contrast at phone size, check UI exceptions/crashes and accessibility.
3. Only after owner feedback, correct UI fidelity without adding features or generating unverified movements.

**Do not claim a production-ready release based only on successful compilation.**
