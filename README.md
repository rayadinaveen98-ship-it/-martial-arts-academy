# Martial Arts Academy

**Status:** Pre-production — research and planning only  
**Platform target:** Android  
**First prototype:** Boxing Foundations v0.1  
**Last reviewed:** 2026-11-10

**Stage 0 update:** Detailed boxing curriculum, state-machine/test contract, trainer asset production gates, and unresolved coaching questions are documented. External coach sign-off remains outstanding.

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

## Interactive prototype (web vertical slice)

[**Open the self-contained v0.1 web prototype source**](prototype/academy_working_prototype.html) · [Prototype functionality, caveats and manual test guide](prototype/README.md)

Implemented: onboarding, three concept lessons, two questions per lesson, progressive unlocking, responsive dark cinematic UI, saved local progress, a practice timer demo, plus a five-stage animated **concept-only Stance & Guard storyboard** (Play/Pause, phases, scrubber, speed). This **is not an Android APK**, and generated athlete artwork is explicitly decorative, not coach-approved technique instruction.

A reproducible smoke-test script and GitHub Actions workflow are committed. Local Node simulated-DOM regression and motion tests passed; full browser screenshot/emulator visual QA has **not** passed owing to restrictions in the testing environment.

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

## Important status distinction
Documentation is the only initialized work here. **No app implementation, approved characters, verified instructional motion, emulator screenshots, or APK exist yet. Three static visual concepts have been prepared for owner review; not approved for implementation.**
