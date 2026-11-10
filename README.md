# Martial Arts Academy

**Status:** Character C1 technical experiment; research and design are ongoing  
**Platform target:** Android  
**First prototype:** Boxing Foundations v0.1  
**Last reviewed:** 2026-11-10

**Stage 0 update:** Detailed boxing curriculum, state-machine/test contract, trainer asset production gates, and unresolved coaching questions are documented. External coach sign-off remains outstanding.

## Native Android foundation (November 10, 2026)

**Kotlin/Jetpack Compose source is now committed** under [android-native](android-native/README.md), preserving our existing boxing-first learning path, four-step Skill Studio, quiz gating, notes, timer demo and Journey. The neutral A01 artwork is bundled locally and no inaccurate stance animation is used. Unit tests and a [debug-build GitHub Actions workflow](.github/workflows/native-android-check.yml) are configured.

**Important:** Android SDK and Gradle are unavailable in this execution environment. An actual native build, emulator screenshot and downloadable APK have **not been verified**; see the [native QA handoff](android-native/README.md). The [existing V0.3 web app](https://martial-arts-academy-v02.vercel.app/) remains the usable review experience.

## Character A01 review workspace

**Open the [A01 Character Lab](https://martial-arts-a01-character-lab.vercel.app/)** on your phone to inspect the neutral front/profile/rear/three-quarter appearance and record visual feedback. This is a **2D concept inspection page**, not a 3D rig, not a coach-approved boxing instructor, and does not send review notes to GitHub. The [web source](character-lab/index.html) and [C0 production feasibility](docs/14-A01-CHARACTER-GATE-AND-3D-FEASIBILITY.md) are versioned here. **Owner has accepted the A01 concept as our visual target; an actual A01 mesh/rig remains unapproved.**

## C1 geometry test bench (November 10, 2026)

**[Open the A01 C1 Geometry Lab](https://martial-arts-a01-c1.vercel.app/)** to compare our accepted concept art with a separate real rigged-base candidate. Four 3D camera views, orbit controls, computed joint/mesh counts when assets load, and local review notes are included. Third-party 3D files are pinned to a specific upstream commit. **The actual A01 model, its rig, deformations and technique motion are NOT built or approved.** The hosted page is READY but live Safari GLB loading is not independently confirmed. [Technical implementation](character-c1/README.md) · [C1 test/gate report](docs/15-C1-GEOMETRY-EXPERIMENT.md).

## Laptop-ready Blender handoff

While the owner's laptop is unavailable, we've prepared a **[Blender C1 setup and handoff guide](docs/16-BLENDER-LAPTOP-HANDOFF.md)** and a [read-only Blender scene audit script](tools/blender/audit_a01.py). The audit is designed to list meshes, armatures, weights and source textures without pretending to check anatomical accuracy. Source, instructions and a Python-syntax GitHub Actions workflow are committed. **The script has not yet been executed in a real Blender environment.**

## Character-first reset (November 10, 2026)

The user approved the visual direction and navigation but reported substantial pose errors and poor character fidelity in the animated v0.2 SVG study. **This animation is not acceptable as an instructional asset.** No more movement expansion until the neutral Instructor A01 design sheet is approved, a single 3D rig is reviewed, and actual technique media are validated by a qualified boxing coach. See [character approval task](https://github.com/rayadinaveen98-ship-it/-martial-arts-academy/issues/2).

## Product promise
A premium, interactive martial arts education companion that makes beginner progress understandable and meaningful. Not a substitute for qualified in-person coaching or supervised contact training.

## Non-negotiable product requirements
1. Visually rich, premium UI; no dull or inconsistent design.
2. Every major interaction must teach, guide practice, or accurately communicate progress.
3. No flawed or awkward instructional poses. Never publish unreviewed AI-generated motion as correct technique.
4. Research and verified technique specifications come before artwork, animation, or implementation.
5. The owner approves the visual prototype before production implementation.

## Focus of v0.1
**Boxing first:** stance & guard, basic footwork, and lead-hand jab. Beginner, solo, no-contact training only.

### Prototype intent
- Onboarding for experience level, goals, stance, available space and readiness.
- A focused next-lesson home, not a huge technique catalogue.
- Teaching screen with verified media / explicitly labeled placeholders.
- Knowledge checks, guided practice with a working timer, progress and reflection.
- Offline-first design; no server or AI system required.
- No camera-based technique correction, sparring, submissions or contact drills.

## Skill Studio V0.3 — approved-concept direction only

The previous procedural **five-stage boxing pose animation was rejected for incorrect poses and has been removed** from the live teaching interface. V0.3 keeps the same academy design, navigation, 3-lesson boxing curriculum and local progress, but delivers 4-step conceptual studies, expandable error explanations, personal lesson notes and a truthful unverified-media status. The A01 neutral portrait is concept art, **not** technical instruction.

[Open V0.3 in Safari](https://martial-arts-academy-v02.vercel.app/) · [Implementation and QA report](docs/17-SKILL-STUDIO-V03.md). Native Android implementation, approved physical demonstrations, and qualified-coach sign-off remain pending.

## Interactive prototype (web vertical slice)

[**Open the self-contained v0.1 web prototype source**](prototype/academy_working_prototype.html) · [Prototype functionality, caveats and manual test guide](prototype/README.md)

Implemented: onboarding, three concept lessons, two questions per lesson, four interactive concept study stages per lesson, progressive unlocking, expandable common errors, local notes, responsive dark cinematic UI, saved progress, and the existing timer demo. **The rejected SVG pose study is no longer on the lesson screen.** This **is not an Android APK**, and generated athlete artwork is explicitly decorative, not coach-approved technique instruction.

A reproducible smoke-test script and GitHub Actions workflow are committed. Local Node simulated-DOM regression and motion tests passed; Chromium directly rendered the HTML at multiple mobile widths with interaction checks; external URL navigation and true iPhone/Android device QA are still unverified.

## Working documentation
- [Project charter](docs/00-PROJECT-CHARTER.md)
- [Research and references](docs/01-RESEARCH-AND-SOURCES.md)
- [Prototype specification](docs/02-PROTOTYPE-V0.1.md)
- [Movement and instructor asset quality standard](docs/03-MOTION-QUALITY-GATES.md)
- [Visual direction and consistency](docs/04-VISUAL-DIRECTION.md)
- [Decision log and roadmap](docs/05-DECISIONS-AND-ROADMAP.md)
- [Detailed boxing curriculum](docs/06-BOXING-FOUNDATIONS-CURRICULUM.md)
- [Interactive journey and acceptance tests](docs/07-INTERACTIVE-EXPERIENCE-AND-TEST-CASES.md)
- [Trainer visual production brief](docs/08-TRAINER-VISUAL-PRODUCTION-BRIEF.md)
- [Research disputes and open questions](docs/09-RESEARCH-DECISIONS-OPEN-QUESTIONS.md)
- [Visual concepts and correction checklist](docs/10-VISUAL-CONCEPT-REVIEW.md)
- [Implemented Stance & Guard motion-study prototype and limitations](docs/11-MOTION-STUDY-V02.md)
- [Character design system and C0–C4 gates](docs/12-CHARACTER-DESIGN-SYSTEM-V1.md)
- [Character/motion validation production process](docs/13-CHARACTER-AND-MOTION-PRODUCTION-GATES.md)
- [C1 base-model experiment](docs/15-C1-GEOMETRY-EXPERIMENT.md)
- [Laptop Blender handoff](docs/16-BLENDER-LAPTOP-HANDOFF.md)

## Important status distinction
Documentation, an HTML academy demo, a rejected schematic-motion test, A01 art-review tools and a C1 technical 3D viewer exist. **No custom A01 mesh, reviewed stance video, verified native Android build, emulator screenshot or APK exists. Native Compose source is present but build/installation are pending.**
