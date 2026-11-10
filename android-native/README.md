# Martial Arts Academy — native Android foundation

**Date:** November 10, 2026  
**Status:** Native Kotlin + Jetpack Compose source implemented; **APK build and emulator/device verification not yet confirmed**.  
**Preserves:** The approved V0.3 three-lesson Boxing Foundations concept and premium obsidian/crimson visual direction.

## What's in the native source

- Native first-run setup: training goal, stance orientation, space.
- Dark, high-contrast academy Home / Learn / Timer / Journey navigation and profile controls.
- Same three prerequisite-linked concept lessons: Stance & Guard, Foundational Footwork, Lead-Hand Jab.
- Four conceptual learning stages per lesson, stage selection, previous/next, why-it-matters explanations.
- Common-error accordion, truthful media-review status and same offline A01 neutral concept portrait.
- Understanding quizzes (two per lesson), gated by visiting all four steps. Passing only unlocks conceptual learning.
- Device-local notes and progress via SharedPreferences; no backend or camera.
- Existing two-round 30/45/60-second **timer interface demo**, 15-second break, pause/resume/stop, background/navigation auto-pause, no credit on early stop.
- Journey reporting conceptual completion separately from UI timer demos.

**Not implemented:** Coach-reviewed A01 animation, camera technique feedback, advanced combat techniques, native video player, physical-skill certification, production signing or Play Store packaging.

## Build strategy

The GitHub workflow at [native-android-check.yml](../.github/workflows/native-android-check.yml) is configured to install SDK 36, run JVM rules tests, compile a debug build, and upload the debug APK as a short-lived GitHub Actions artifact **only if the build passes**. Its actual execution/result has not been independently confirmed here.

### Build on a laptop with Android SDK, JDK 17 and Gradle 8.14
From the `android-native` directory:
```sh
gradle :app:testDebugUnitTest :app:assembleDebug
```
The repository contains a Gradle wrapper *properties file* but not a wrapper JAR/script; you must have Gradle installed or use the configured GitHub Actions workflow. Don't assume `./gradlew` exists.

Pinned baseline:
- Android Gradle Plugin 8.11.1
- Kotlin + Compose compiler 2.2.20
- Gradle 8.14
- Compile SDK 36; min SDK 26; target SDK 35
- Jetpack Compose BOM 2025.09.00
- Activity Compose 1.13.0
- Lifecycle Runtime Compose 2.9.4

## Scope and safety

- No raw training animations from the rejected V0.2 SVG system are included.
- The A01 image is *neutral visual concept artwork*, not an approved movement demonstration.
- No external permissions, sign-in, automatic AI scoring, fake technique-mastery badge or calorie estimates.
- Quiz success signifies *concept understanding only*.
- The timer is an interactive demo, not a coach-certified exercise prescription.
- Notes stay on the device, and no previous web-browser localStorage is imported into this separate native app.
- Do not advertise accurate physical instruction until rights-cleared media and qualified coaching review are completed.

## QA gates still open

1. GitHub Actions debug build finishes successfully and its artifact is inspected.
2. Install on emulator / physical Android phone, capture genuine screenshots, review 360–430dp screens against approved design.
3. Validate first-run personalization, navigation, concept gate, mistakes, notes persistence, quizzes, timer pause/resume/end and app restart.
4. Verify accessibility contrast, font scaling, TalkBack and background lifecycle behavior.
5. Confirm every text instruction against the approved curriculum; qualified boxing-coach review is separate.
6. Compare actual A01 portrait at mobile resolution; fix visual polish without adding features.

## Source map
- `app/src/main/java/com/martialartsacademy/app/AcademyCore.kt` — pure Kotlin curriculum and progression rules.
- `app/src/main/java/com/martialartsacademy/app/AcademyStore.kt` — Android local serialization.
- `app/src/main/java/com/martialartsacademy/app/MainActivity.kt` — Compose UI.
- `app/src/main/assets/a01_portrait.b64` — neutral concept artwork stored as base64 text.
- `app/src/test/java/com/martialartsacademy/app/LearningRulesTest.kt` — JVM progression tests.

The existing [V0.3 web prototype](https://martial-arts-academy-v02.vercel.app/) remains the tested browser prototype and is not replaced by this unverified native build.
