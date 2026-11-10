# 05 — Decision log and roadmap

## Decisions and constraints
| ID | Item | State | Rationale |
|---|---|---|---|
| D-001 | Build an Android martial-arts academy concept | Approved as prototype direction | User selected martial arts |
| D-002 | Research before code/art | Locked | Training accuracy and quality are priorities |
| D-003 | Premium, rich, coherent design | Locked quality requirement | Owner requirement |
| D-004 | Meaningful interactivity, not inert screens | Locked quality requirement | Owner requirement |
| D-005 | Validated instructor motion only | Locked quality requirement | Safety and technical accuracy |
| D-006 | Start with Boxing Foundations v0.1 | Proposed | Smallest coherent learning path |
| D-007 | Candidate cinematic palette | Proposed | Pending owner visual approval |
| D-008 | Camera pose correction | Out of v0.1 | Tracking does not prove proper technique |
| D-009 | Kotlin + Jetpack Compose, offline-first | Proposed | Avoid unnecessary backend/cost |
| D-010 | Boxing curriculum & lesson checks | Draft complete; coach review pending | See docs/06, no misleading skill-mastery claims |
| D-011 | Coach-reviewed vs decorative trainer imagery | Locked quality gate | See docs/08; no unverified physical technique presented as validated |
| D-012 | Jab wrist-angle inconsistency | Open | EB26 and BC24 use differing wording; seek coach sign-off before instruction |
| D-013 | Three-screen cinematic visual exploration | User liked direction, fidelity acceptance pending | See docs/10 |
| D-014 | Web-first interactive proof on iPhone | Implemented as standalone HTML (not APK) | Provides early review without faking an Android build; see prototype/README.md |
| D-015 | Conceptual progress vs certified technique | Locked | Quizzes unlock conceptual lessons only; unreviewed movements still blocked |

## Status by stage
| Stage | Status | Exit evidence |
|---|---|---|
| 0. Source research & curriculum | Research drafts committed; expert validation pending | Boxing curriculum, source cross-check, coach approval before instructional media |
| 1. Visual concepts & interactive UX | Three images liked; first working HTML visual slice available, parity review pending | Owner reviews actual interactive UI and approves/revises |
| 2. Instructor media / motion QC | Blocked pending qualified reviewer and media | Licensed, reviewed assets |
| 3. Functional Android prototype | Native Android not started; responsive HTML vertical slice works | Owner reviews HTML; then implement and test Kotlin/Compose version |
| 4. QA & emulator/device review | Not started | Reproducible test results and parity with designs |
| 5. Installable prototype | Not started | Verified APK and documented test checklist |

## Scope discipline
No unsolicited expansion to full martial arts catalogues, AI trainers, subscriptions, social networking, or advanced contact training. New features require an explicit change record.

## Immediate next tasks
1. Review the detailed curriculum in `docs/06-BOXING-FOUNDATIONS-CURRICULUM.md` against England Boxing 2026 and Boxing Canada 2024.
2. Identify a qualified boxing reviewer to adjudicate jab/wrist wording, stance details, physical drill dosage and both stance orientations.
3. Secure rights-cleared trainer reference media or use explicitly marked concept placeholders; no unapproved technique motion.
4. Prepare non-instructional premium screen concepts (home, lesson, practice) for owner review.
5. Obtain owner approval of the visual design before Android UI implementation.

## Implementation evidence
- Standalone HTML: prototype/academy_working_prototype.html (on main).
- QA: prototype/checks.cjs and .github/workflows/prototype-check.yml.
- Local simulated-DOM Node test passed for major interactions and persistence; GitHub Actions run status not yet confirmed.
- Browser visual screenshot test in the working environment was blocked by managed-browser restrictions. No native Android/emulator screenshots or APK exist.

## Release truthfulness
Do not claim a tested APK, complete animation, or reviewed technique unless evidence exists. Maintain accurate statuses and versioned release notes.
