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
| D-016 | Stance animation studio v0.2 | Historical UI/animation experiment; user rejected pose and character fidelity | Do not reuse as instructional motion; see docs/11 |
| D-017 | Character-first production reset | In progress | Freeze new poses, establish single character identity, geometry, rig and technical coaching review; see docs/12–13 |
| D-018 | Semi-realistic 3D instructor, motion from verified coach reference | Proposed art/technical strategy | Stable single model and reviewed renders; user must accept character concept before implementation |
| D-019 | Pre-rendered approved motion with app-controlled playback | Proposed implementation strategy | High consistent visual quality and offline predictable behavior; real-time 3D later if needed |
| D-020 | A01 C0 interactive neutral review lab | Implemented and deployed; owner feedback pending | Four fixed 2D views from one sheet, zoom, materials, checklist; NOT a real 3D character |
| D-021 | Evaluate Blender MPFB2 + Rigify | Research complete, feasibility build not begun | License-friendly base mesh/rig controls; needs real artist evaluation and coaching validation |
| D-022 | A01 C0 visual concept | Accepted by owner for C1 experimentation | Approval applies to reference appearance, not mesh or techniques |
| D-023 | External rigged-base inspector | Implemented and deployed; browser model loading unverified | GitHub-pinned CC0 baseline with orbit, garment requirement and actual bone counts; see docs/15 |
| D-024 | Genuine A01 production model | Blocked / not started | No Blender and no sculpted/rigged A01 geometry in runtime; requires source mesh, rigging QA and art acceptance |
| D-025 | C1 Blender laptop readiness kit | Documentation, read-only audit script and CI syntax workflow committed | Blender execution not attempted; no mesh/pose certification |

## Status by stage
| Stage | Status | Exit evidence |
|---|---|---|
| 0. Source research & curriculum | Research drafts committed; expert validation pending | Boxing curriculum, source cross-check, coach approval before instructional media |
| 1. Visual concepts & interactive UX | Three images liked; first working HTML visual slice available, parity review pending | Owner reviews actual interactive UI and approves/revises |
| 2. Instructor media / motion QC | C0 visual direction accepted; C1 engineering viewer built but actual A01 model NOT ready | Approved editable mesh and validated deformation before trainer reference C2 and review C3–C4 |
| 3. Functional Android prototype | Native Android not started; HTML v0.2 now has five-phase interactive stance preview | Owner reviews actual storyboard; then native implementation after approval |
| 4. QA & emulator/device review | Not started | Reproducible test results and parity with designs |
| 5. Installable prototype | Not started | Verified APK and documented test checklist |

## Scope discipline
No unsolicited expansion to full martial arts catalogues, AI trainers, subscriptions, social networking, or advanced contact training. New features require an explicit change record.

## C1 experimental deliverable
- [C1 Geometry Lab](https://martial-arts-a01-c1.vercel.app/) deployed with public sign-in disabled.
- Separate external rigged model candidate, **not** the original A01 character. Camera view/orbit functionality coded and static/GLB-parser self-tests passed locally.
- Actual iPhone GLB render, per-joint skin deformation, fidelity to A01 and coach-safe movements unverified.
- Evidence and source provenance: docs/15-C1-GEOMETRY-EXPERIMENT.md.

## Character C0 live review
- Live review: https://martial-arts-a01-character-lab.vercel.app/ (Vercel deployment READY; public access controls disabled; iPhone end-to-end not independently verified).
- GitHub source: character-lab/index.html; static QA: character-lab/check-lab.cjs.
- Owner visual approval pending; no real mesh or rig yet. See docs/14 for feasibility.

## Immediate character-first reset (2026-11-10)
- User likes UI/navigation but judges poses inaccurate and character low-quality.
- Halt further movement production; neutral C0 character sheet is next.
- For gates/decision rationale see docs/12 and docs/13 and GitHub character-approval issue.

## Immediate next tasks
1. Review the detailed curriculum in `docs/06-BOXING-FOUNDATIONS-CURRICULUM.md` against England Boxing 2026 and Boxing Canada 2024.
2. Identify a qualified boxing reviewer to adjudicate jab/wrist wording, stance details, physical drill dosage and both stance orientations.
3. Secure rights-cleared trainer reference media or use explicitly marked concept placeholders; no unapproved technique motion.
4. Prepare non-instructional premium screen concepts (home, lesson, practice) for owner review.
5. Obtain owner approval of the visual design before Android UI implementation.

## Laptop handoff readiness (2026-11-10)
- [Blender C1 handoff](16-BLENDER-LAPTOP-HANDOFF.md): command-line use and acceptance conditions.
- [Read-only audit](../tools/blender/audit_a01.py): inventories meshes, armatures, basic skinning links and textures; its report is NOT a pass certificate.
- CI workflow [.github/workflows/blender-script-check.yml](../.github/workflows/blender-script-check.yml) provides a syntax check when the repository runs it; GitHub Actions result not confirmed here.
- Blender/MPFB and actual user-laptop file access are still unavailable in this chat. Do not label C1 complete.

## Implementation evidence
- Standalone HTML v0.2: prototype/academy_working_prototype.html (on main). Five-stage storyboard is interactive but unverified.
- QA: prototype/checks.cjs and .github/workflows/prototype-check.yml.
- Local simulated-DOM Node test passed for major interactions and persistence; GitHub Actions run status not yet confirmed.
- Browser visual screenshot test in the working environment was blocked by managed-browser restrictions. No native Android/emulator screenshots or APK exist.

## Release truthfulness
Do not claim a tested APK, complete animation, or reviewed technique unless evidence exists. Maintain accurate statuses and versioned release notes.
