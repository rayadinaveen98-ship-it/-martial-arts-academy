# Working interactive prototype — v0.1

Built: 2026-11-10
Artifact: [Self-contained HTML](academy_working_prototype.html)

This is a **self-contained web prototype for quick iPhone/desktop evaluation**, not an Android APK. All styling, JavaScript and decorative artwork are bundled inside the HTML, requiring no server or paid API.

## Implemented behavior
- First-run preference onboarding: goal, stance (orthodox/southpaw/unsure), available space.
- Mobile training home and 3-step learning journey; resume next incomplete lesson.
- Three conceptual beginner boxing lessons: stance/guard, advance/retreat footwork, lead-hand jab.
- Two knowledge questions per lesson; wrong-answer explanations and retries.
- Unlocking based on comprehension, not fake physical-mastery scores.
- Saved local progress and settings using browser localStorage.
- Two-round timer demo: 30/45/60 seconds per round, a short rest interval, pause/resume, early-stop without credit, and completion recording.
- Optional audio transition cue, progress dashboard, profile editing and reset.

## Boundaries and known limitations
- **Not coach-validated technique instruction.** The decorative boxer image is concept art. No unverified animation is presented as expert-approved technique.
- The timer is a working UX demo, not a prescribed workout.
- No real multi-angle media, pose correction, estimated calories, XP, sparring, or accounts.
- Current HTML follows the visual direction but has NOT received owner sign-off on actual implementation.
- Not an Android APK / native Jetpack Compose project yet.
- Chromium visual screenshot QA was blocked by managed-browser restrictions. Do not claim emulator/device visual fidelity has been verified.

## Verification completed
- Node JavaScript syntax validation.
- Automated simulated-DOM interaction test: first-run onboarding and preference persistence; incorrect quiz answers and retries; concept-based lesson unlocking; timer duration/start/pause/resume/early-stop and no false completion; timer completion logging; progress surviving reload.
- GitHub fetch confirmation after push (HTML file complete with embedded art).

## Manual testing checklist
1. Open HTML in Safari or another JavaScript-capable browser, or serve from a trusted static host.
2. Complete onboarding and enter the academy.
3. Open Stance & Guard, inspect Understand and Common errors.
4. Answer incorrectly, review explanation, retry correctly, and finish both questions.
5. Verify Footwork unlocks; inspect Journey.
6. In Timer, choose 30 seconds, start/pause/resume and stop early. Confirm no completion is counted.
7. Complete a full timer demo and confirm only demo usage is recorded.
8. Reload and verify progress remains saved.

## Next gate
Owner compares live UI to initial image mockups; fix fidelity and interaction issues; after approval implement native Android Compose. Rights-cleared demonstrations and qualified coach approval remain separate blocking requirements for instructional movement.
