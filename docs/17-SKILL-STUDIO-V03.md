# 17 — Skill Studio V0.3: scope-locked implementation and QA

**Version:** 0.3 — 2026-11-10  
**Repository artifact:** [prototype/academy_working_prototype.html](../prototype/academy_working_prototype.html)  
**Hosted review:** https://martial-arts-academy-v02.vercel.app/ (existing stable domain; re-used so browser state is preserved)  
**Status:** Functional HTML vertical slice. **Not native Android, and not an approved technique instruction product.**

## Owner concept lock — preserved
- One cohesive, visually premium martial arts academy, initially **Boxing Foundations** only.
- Three prerequisite-linked modules: **Stance & Guard → Foundational Footwork → Lead-Hand Jab**.
- Character identity: **Instructor A01** visual direction approved for 3D production, not yet a coach-approved moving instructor.
- A coherent dark/crimson/electric-blue aesthetic, full navigation, beginner personalization and honest progress.
- **No new martial arts catalogue, AI pose checker, subscriptions, gamification XP, badges claiming proficiency, or unsafe contact drills.**
- The previously inaccurate procedural SVG movement was rejected by the owner. It is no longer displayed in the lesson.

## Scope shipped V0.3
1. Removed all previously generated SVG body poses, tweening, mirrored stance motion and unusable playback controls from the Skill Studio.
2. Added a **four-stage interactive conceptual study** for each of the existing three lessons (12 text-grounded concept stages total); stages have a clear learning reason and optional key takeaway.
3. Stage map, Previous/Next controls and progress status update when the learner visits a stage; visit status is locally persistent.
4. Knowledge Check unlocks after visiting all four stages. Existing V0.2 users who completed a quiz are grandfathered in for review; completion still signifies **comprehension only**.
5. **Common errors** panel includes expandable why-it-matters explanations, without fabricated wrong-pose depictions.
6. **Instructor media status** explicitly explains absence of approved footage and required A01 / reference / coach validation gates. There are no fake camera-angle, 360° or play controls.
7. **A01 portrait** is taken from the previously accepted neutral character study and labelled as concept artwork. It is decorative, not a boxing-stance example.
8. Local **learning note** per lesson (up to 600 characters), escaped before HTML insertion and saved on this device. No server upload.
9. Existing learning path, quizzes, timer demo, profile and local progress remain in place.
10. Three existing lesson IDs and the existing localStorage key remain unchanged; data migration compatibility is preserved.

## Explicitly NOT delivered
- A real A01 mesh, an approved 3D animation, multi-angle instructional footage, a native Android screen or APK.
- Movement scoring, calorie tracking, automatic technique validation, medical screening.
- Coach validation of physical execution or user form.

## Tested behavior
**Node VM simulated-DOM regression — PASS:** initial onboarding; stance preference; quiz gate before stages; all-stage visit; reveal/accordion; media status; persisted notes including HTML escaping; quiz feedback and unlock to Footwork; timer pause/resume/early stop; prior completion and locally saved history retained.

**Real headless Chromium rendering — PASS:** rendered exact HTML directly, tested four step controls, quiz gating, expanded errors, media status, note UI, and quiz feedback. No page JavaScript errors. Measured no horizontal page overflow at widths **360, 390 and 430 CSS px**.

**Environment caveat:** direct navigation to file:// and HTTP/HTTPS URLs within the managed browser was blocked by administrator policy. Chromium DOM rendering with supplied HTML succeeded. A true iPhone Safari test of the hosted page has **not** been independently performed. Vercel reports READY, default domain assigned, and SSO/password protection off.

## User-facing test sequence
1. Open https://martial-arts-academy-v02.vercel.app/ in Safari.
2. Select initial goal, stance preference and space if prompted.
3. Open Stance & Guard. Confirm there is **no** awkward stick-figure pose animation.
4. Select all four numbered concept steps. Reveal takeaways and watch the concept counter advance to 4/4.
5. Open Common errors and expand an explanation; open Media status and see validation gates.
6. Write a note, leave the lesson, return and verify the note persists.
7. Complete both knowledge questions. Footwork becomes available. No physical technique mastery badge appears.
8. Confirm Home, Journey and Timer retain their existing navigation and behavior.

## Next stage, still in scope
- Human design/UX review from owner; fix only identified fidelity/interaction problems.
- If approved, port the validated content-driven Skill Studio to native Android UI, preserving progress semantics.
- Separately, produce genuine A01 source/rig and qualified-coach-reviewed footage before enabling the visual movement player.

## Source of physical concepts
See [boxing research and reference register](01-RESEARCH-AND-SOURCES.md) and [detailed curriculum](06-BOXING-FOUNDATIONS-CURRICULUM.md). Text remains research draft, not a replacement for in-person qualified coaching.
