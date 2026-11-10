# 02 — Prototype v0.1 product specification

**Working learning journey:** From Zero to Your First Jab  
**Target:** Android, offline-first, accessible to adult beginners  
**State:** Proposed, not implemented.

## Learning sequence / prerequisites
1. **Stance & Guard:** orientation, balance, comfortable position, defensive awareness. Prerequisite: onboarding.
2. **Foundational Footwork:** controlled forward and backward movement while retaining stance and guard. Prerequisite: lesson 1 comprehension.
3. **Lead-Hand Jab:** coordination of lead-hand extension and return to guard, at a comfortable non-contact pace. Prerequisite: lessons 1–2 understanding.

Avoid equating answering quizzes with physically correct technique. Every exercise needs content review before being active.

## Screen inventory
### S0 — Welcome and personalization
Choose experience level, training goal, stance orientation (orthodox/southpaw/unsure), available space, and self-reported readiness. All choices are editable. If user is unsure, provide neutral educational explanation, not rigid assignment.

### S1 — Home / next action
Hero training panel, exact next recommended lesson, 'Continue training', latest session outcome and expandable learning pathway. No gratuitous feature catalogue.

### S2 — Skill lesson
Verified trainer media is the centerpiece. Front / side angle only when media exists and has been reviewed; slow playback and keyframes; purpose and text teaching cues. A clear `UNVERIFIED CONCEPT DEMO` state must not silently become an instruction.

### S3 — Knowledge check
Multiple-choice scenarios with immediate explanation. Questions check comprehension, not punching correctness.

### S4 — Guided practice
Space check, intensity choice, optional accessible audio, visible countdown, pause/resume, rest intervals, skip/stop, and post-session reflection. No partner/contact exercises.

### S5 — Progress
Track completed reading/checks, user-reported practice, attempts, reflections, and learning path. Do not show 'mastered' without independent competent validation.

## Interaction state model
`NotStarted -> Learning -> UnderstandingChecked -> Practiced -> Reviewed`.
Re-entry should resume the right state. A quiz may be retried. Stopped sessions are not counted as completed. Data survives process restart.

## Platform sketch
- Kotlin and Jetpack Compose, with local persistence (e.g. Room/DataStore) subject to implementation decision.
- Local lesson schema separating content, assets, logic, and review status.
- Media assets versioned with explicit approval metadata.
- No backend, microphone, camera, paid API, or login needed for this phase.

## Acceptance criteria
- Every visible primary button performs an intentional action.
- Lesson prerequisites, completion logic, timer pause/resume, and persistent state work.
- No fabricated skill scores, technique review badges or AI correction.
- Both stance orientations are educationally accurate in assets before enabled.
- Fully interactive journey demonstrated on a real emulator/device, not just pretty mockups.
- Owner approves key screens against an explicit design acceptance sheet before release.
