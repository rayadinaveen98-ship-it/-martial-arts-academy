# 11 — Stance & Guard motion-study prototype (v0.2)

**Implemented:** 2026-11-10  
**Artifact:** [prototype/academy_working_prototype.html](../prototype/academy_working_prototype.html)  
**Status:** Functional **schematic preview only**. The character and joint motion have NOT been verified by a qualified boxing coach, and must not be presented as technically accurate training instruction.

## Scope delivered
The Stance & Guard lesson now replaces its static hero image with a 5-stage vector storyboard:
1. Neutral start
2. Offset foot base
3. Soft-knee / balance concept
4. Body orientation concept
5. Hand guard concept

It uses an in-app rendered, consistent vector athlete instead of disconnected generated pose images.

### Controls actually working
- Animated interpolation through the five stored poses
- Play / pause and resume from the paused position
- Previous / next phase
- Directly select any of five phases
- Continuous timeline scrubbing
- 0.5×, 1× and 1.5× speed
- Stop animation when leaving the lesson / app is hidden
- Orientation-aware schematic when Southpaw is selected; this is merely a visual mirror of a concept illustration, NOT a separately approved southpaw technique demonstration
- Text captions and active-stage indicator synchronized with pose
- Reduced-motion CSS and accessible button labels

## Validation actually performed
- Node JavaScript syntax validation: PASS.
- Existing simulated-DOM app regression: onboarding, quiz, sequential unlock, timer actions and persistence: PASS.
- Targeted motion simulated-DOM test: five stages, southpaw visual label, playback/pause, next, speed and scrubber: PASS.
- Rendered generated SVG at start and final stages using CairoSVG and inspected both raster outputs.
- Chromium browser visits to file and local HTTP failed with ERR_BLOCKED_BY_ADMINISTRATOR. **No browser-rendered app screenshot, touch-screen device test or emulator QA passed**, so final visual fidelity is not verified.

## Honest visual assessment
This is a visually consistent *stylized vector schematic*, not the photorealistic cinematic instructor rendered in the first mockups. The new UI is meaningful and interactive, but the final production goal of realistic and **correct** human motion remains unfulfilled.

## Hard gates still open
- [ ] Secure a qualified boxing coach to assess all body positions and transitions (see Issue #1).
- [ ] Replace concept motion with permissioned real instructor reference footage or verified rig.
- [ ] Review orthodox and southpaw assets **individually**; mirroring is not an acceptable substitute for independent review.
- [ ] Determine accurate key points, motion speed and guard cues.
- [ ] Test full interface on Android/iPhone real browser and then emulator with screenshots.
- [ ] Obtain owner's visual and behavioral acceptance.

## Next engineering step
Revisit the animation quality and replace the temporary schematic with a real coach-reviewed instructional movement asset once qualified review and rights-cleared footage are available. Keep existing state/controls as the reusable presentation layer; don't invent technique certifications.

**Do not expand to Footwork or Jab demonstration until this one motion lesson has passed production and educational quality gates.**
