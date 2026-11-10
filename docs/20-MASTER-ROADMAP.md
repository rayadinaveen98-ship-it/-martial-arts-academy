# Martial Arts Academy — master roadmap

Revision 1 · November 11, 2026 · Proposed plan for owner review

This is the current planning baseline. It supersedes older status statements saying Blender has not run, no editable model exists, or the APK has not been tested. It does not erase the historical failures or relax the character and coaching gates. No new product scope is approved by this roadmap.

## 1. Goal and first release

Build a premium Android learning companion that helps adult beginners understand boxing fundamentals through clear explanations, meaningful interaction, one consistent instructor, and trustworthy demonstrations. The learner should know what to study next, why it matters, what common mistakes mean, and what progress the app has actually recorded.

The first release remains **Boxing Foundations: Stance & Guard, Foundational Footwork, and Lead-Hand Jab**. It complements qualified coaching; quizzes and timers do not certify physical technique. The larger Martial Arts Academy vision may support other disciplines later, but the current project must prove this small learning path first.

The target is a coherent learning experience, not an impressive character file in isolation: open the app → find the next lesson → understand the concept → inspect approved demonstration media → complete an understanding check → save notes/progress → resume later. Physical practice instructions require their own qualified review.

## 2. What exists now

| Area | Current evidence | Boundary |
|---|---|---|
| Product direction | Boxing-first scope, premium dark/crimson direction, offline-first native app | Full visual polish remains open |
| Curriculum | Three lessons, four concept steps per lesson, explanations, mistakes and knowledge checks are documented/implemented | Research drafts are not a qualified coach's approval |
| Web prototype | Historical V0.3 interaction/source implementation | Earlier SVG motion was rejected and removed from teaching UI |
| Native Android | Kotlin/Compose Home, Skill Studio, quiz flow, notes, timer demo, Journey/Profile and local persistence | Feature source exists; the whole journey has not yet passed complete real-device QA |
| Build | Debug APK builds and JVM tests pass | Debug build is not a production/store release |
| Real 3D asset | Editable Blender v003 source, stable body/outfit, packed textures, one rig, four original turnaround renders | Local editable sources are preserved; technical sign-off is incomplete |
| Rig | Foot position/orientation locks, hand orientation controls, knee/elbow bend controls and small-range probes | Surface/weight findings and qualified rigger review remain open; no arbitrary-pose guarantee |
| App portrait | Exact neutral v003 PNG replaces the earlier concept portrait; code merged in PR #3 | Static artwork only, no teaching animation |
| Android evidence | API 30 emulator Home/Skill captures, 360/390/430 dp portrait inspection, tested APK image hash matches source | Wider Android versions, accessibility and full app regression remain open |
| Owner device feedback | Owner reports the APK was tested and the character is present | This confirms installation/display as reported by the owner, not every screen or lesson |
| Latest visual decision | Owner says the current standing pose/presentation is disliked | The technical A-pose is not accepted as the final app presentation |

The character's face/body/outfit identity was previously accepted. **That does not lock the current standing pose.** The latest feedback reopens presentation approval while preserving the accepted identity. The A-pose was useful for rigging and inspection; it should not automatically become the final instructor portrait.

## 3. Where we are

**Working Android prototype + real character integrated; presentation review next.** We have crossed the integration milestone. We have not crossed final product visual acceptance, complete C1 deformation acceptance, coach-reviewed instruction, or release QA.

The immediate priority is to agree how the instructor should appear in the app. More general rig polishing is not the default next action. Technical repairs should be driven by visible problems in an agreed shot or the first actual demonstration.

## 4. Ordered milestones and stop conditions

### M1 — Accept the instructor's app presentation

Preserve the same face, build, hair, clothing and materials. Write a small presentation brief: ordinary relaxed standing, natural arm placement, credible foot contact, readable silhouette and suitable camera/framing. This is display artwork, not a claimed boxing stance.

After the roadmap is accepted, compare at most **three static presentation options from the same model**. Review them inside the actual Android card. Proposed scope: one initial comparison and one focused correction round before an owner decision. Extra revisions need a stated reason and revised scope instead of indefinite polishing.

**Deliverable:** one selected static app presentation and its tested Android screenshot. **Exit:** owner explicitly accepts the pose, camera and crop. No animation is needed to complete this milestone.

### M2 — Make one lesson's instruction trustworthy

Start only with **Stance & Guard**. Review its written explanations and unresolved technique questions with a qualified boxing coach. Obtain usable reference with documented permission/licensing and appropriate camera coverage. Decide the exact small demonstration sequence and any permitted practice guidance. Source recruitment/research can happen alongside visual work, but it does not bypass C1 or approve motion.

**Deliverable:** a concise lesson/media brief, reference-rights record and named qualified reviewer. **Exit:** reference and technical requirements are accepted; unresolved claims are marked unavailable rather than invented. This is an external dependency, not something an assistant can self-certify.

### M3 — Produce and validate one demonstration

Have a competent character rigger inspect the existing findings. Fix the shoulder/hand/shoe or control problems that affect the chosen sequence. Check foot contact, clothing, hands, weight transfer and the required camera views for that sequence. Avoid trying to perfect every possible body movement first.

Create one editable, reference-based Stance & Guard sequence. A coach reviews the exact final rendered media, including transitions and each offered view/orientation; the owner reviews appearance and clarity. Mirroring is not a substitute for separately reviewed stance orientation.

**Deliverable:** one approved demonstration, editable source, rights record and review tied to an exact revision. **Exit:** relevant C1 technical issues are resolved, C2 reference is cleared, C3 coach review and C4 owner approval are recorded. Stop before other movement expansion if this fails.

### M4 — Complete one end-to-end Android lesson

Recommended delivery: optimized pre-rendered media from the single Blender master, with straightforward play/pause/restart and only the slow playback or phase navigation the lesson needs. This follows the existing proposed media strategy and avoids adding a real-time 3D engine merely to show demonstrations. Confirm the playback choices in the lesson brief before implementation.

Integrate the approved clip with the existing concept steps, errors, notes and knowledge check. Check offline loading, readability, media state, navigation, restart and honest progress. Keep unreleased media unavailable for the other lessons.

**Deliverable:** one complete Stance & Guard lesson in an installable Android build. **Exit:** owner can use it on a phone from start through saved progress, and the technical/content reviews are linked to the shipped asset.

### M5 — Finish the three-lesson Boxing Foundations release

Only after M4 succeeds, repeat the proven reference → targeted rig/animation work → coach/owner review → Android integration process for Footwork, then Lead-Hand Jab. Review the complete learning order and any practice guidance rather than assuming the earlier research draft is sufficient.

**Deliverable:** the agreed three-lesson path with consistent instructor identity and approved media. **Exit:** every included instructional asset has rights/review records; no placeholder or unverified clip is presented as validated instruction.

### M6 — Validate the whole app and prepare a release candidate

Test the implemented onboarding, Home, all lesson tabs, quiz locks, notes, Journey, timer behavior, background/resume and restart persistence on actual Android hardware. Check small screens, larger text, touch targets, accessibility, offline behavior, crashes and loading. Review visual consistency against the accepted design and package/license requirements. Fix observed defects without adding unrelated features.

**Deliverable:** a versioned release-candidate APK and a clear test report. **Exit:** owner accepts the complete app experience and all required media gates pass. Public store publication is a separate release decision; it is not implied by a debug APK working.

## 5. What stays outside this release

No new martial arts catalogue, camera-based form scoring, AI coach, social feed, subscriptions, payments, advanced/contact drills or automatic physical-skill certification. Real-time character rotation/customization is not needed for the initial media path. New features require an explicit scope decision after the core experience works.

No paid asset or subscription is authorized. Coaching/reference availability and any associated cost are unresolved; do not promise that qualified external production is free or substitute unreviewed material to avoid that dependency.

## 6. How we control time and prevent endless work

Before each work session, state the milestone, one concrete output, allowed changes, evidence to collect and stopping condition. End with what passed, what failed and the next decision. Keep a short defect list with priority; do not turn every possible improvement into a new automatic task.

M1 has a proposed finite review cycle. M2 depends on access to a qualified reviewer and cleared reference. M3 cannot be responsibly scheduled until the sequence and reference are known. M4–M6 should be estimated after the first lesson proves the workflow. **A reliable calendar or percentage-complete figure does not exist yet.** Approve dates only after those dependencies and acceptance criteria are concrete; technical task completion alone must not be called product completion.

## 7. Next decision

Review this roadmap first. On acceptance, the next authorized production package should be **M1: a natural static instructor presentation using the current character**, with the three-option/one-correction-round limit agreed. Animation and broad app changes wait for their own milestones.

## Evidence and source of truth

- Native portrait integration: https://github.com/rayadinaveen98-ship-it/-martial-arts-academy/pull/3
- Main integration commit: `3582dbcb2abb0c6dc651a302fc2eec3cd683569d`.
- Successful emulator/build evidence: https://github.com/rayadinaveen98-ship-it/-martial-arts-academy/actions/runs/42882661519
- Local editable rig/source and probes: `outputs/A01-C1-v003/` in the working session.
- Delivered APK and actual Android screenshots: `outputs/A01-Android-portrait-v001/` in the working session.
- Owner's latest chat feedback supplies the device-install/display confirmation and rejection of the standing pose. No independent full-device regression is inferred.
- Existing project charter and C0–C4 gates remain the governing product and media requirements. Older status reports are historical where they conflict with this dated evidence.