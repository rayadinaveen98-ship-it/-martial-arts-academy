# Martial Arts Academy

**Current checkpoint — November 11, 2026:** Working native Android prototype; static A01 integration verified; owner reports the APK works and the character is present. The current standing pose/presentation is not accepted.

## Current roadmap

Read the [master roadmap](docs/20-MASTER-ROADMAP.md) before further production. It records the goal, completed work, current owner feedback, ordered milestones and stopping conditions. It supersedes stale status statements in earlier reports; existing product and coaching quality gates remain in force.

Our goal is a premium Android learning companion for adult beginners, starting with **Stance & Guard, Foundational Footwork and Lead-Hand Jab**. Concept knowledge and timer use do not certify physical technique.

## What works

- Native Kotlin/Compose source implements onboarding, Home, Skill Studio, concept steps, mistakes, knowledge checks, notes, timer demo, Journey/Profile and local persistence. Full app/device QA remains open.
- JVM unit tests and debug APK compilation pass.
- The exact owner-approved neutral Blender v003 PNG replaces the earlier concept portrait in Skill Studio. Full-body Fit scaling and a caption below the image keep hands/feet visible.
- Actual Android API 30 emulator Home/Skill screenshots at 360/390/430 dp passed portrait review. The owner subsequently reports testing the APK and seeing the character.
- Editable Blender source, a shared rig, foot locks, bend controls and neutral-range probes exist in the owner's local session outputs. They are not uploaded as a finished character package here; full C1 rigger acceptance remains pending.
- No instructional boxing animation is released. The earlier inaccurate SVG motion was rejected and removed.

[Portrait integration, merged PR #3](https://github.com/rayadinaveen98-ship-it/-martial-arts-academy/pull/3) · [Successful Android evidence run](https://github.com/rayadinaveen98-ship-it/-martial-arts-academy/actions/runs/42882661519)

## Current decision and next milestone

The owner likes the improvement and confirms integration works, but dislikes the character's pose and way of standing. Preserve the accepted identity and outfit while revisiting **static app presentation**. The rig's technical A-pose is not the final product pose.

The proposed next package is a natural neutral-standing presentation comparison from the same model, reviewed inside Android. The [roadmap](docs/20-MASTER-ROADMAP.md) proposes at most three options and one focused correction round before an owner decision. This plan is for owner review; it is not approval to start new poses or animation.

After visual acceptance: secure qualified coach review and permitted reference for one Stance & Guard demonstration, resolve relevant rig defects, approve the rendered instruction, then complete that one Android lesson before expanding motion to Footwork/Jab.

## Scope and quality

Boxing first, offline-first, meaningful interaction and consistent premium visuals. No new disciplines, camera form scoring, AI coach, social features, subscriptions or advanced contact training in the current release. No paid assets/subscriptions are authorized. Coach/reference availability and complete release QA remain unresolved dependencies.

## Project sources and records

- [Native Android source and QA handoff](android-native/README.md)
- [Product charter](docs/00-PROJECT-CHARTER.md)
- [Current master roadmap](docs/20-MASTER-ROADMAP.md)
- [Historical decision log](docs/05-DECISIONS-AND-ROADMAP.md)
- [Boxing curriculum draft](docs/06-BOXING-FOUNDATIONS-CURRICULUM.md)
- [Character design system](docs/12-CHARACTER-DESIGN-SYSTEM-V1.md)
- [Character and motion release gates](docs/13-CHARACTER-AND-MOTION-PRODUCTION-GATES.md)
- [Historical emulator findings and current checkpoint](docs/19-NATIVE-EMULATOR-VISUAL-QA.md)
- [Historical web prototype](prototype/README.md), [2D concept lab](character-lab/index.html), [external geometry bench](character-c1/README.md)

Older reports remain evidence of their authoring date. They must not be used to claim that a current model does not exist, that the installed APK has never been tested, or that all app functionality and instruction are now approved.
