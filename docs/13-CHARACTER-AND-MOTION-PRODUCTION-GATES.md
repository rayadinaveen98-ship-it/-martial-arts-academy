# 13 — Character and motion release-control plan

**Current checkpoint (November 11, 2026):** Character identity was accepted; an editable local v003 rig and static app integration exist. The owner now rejects the standing presentation. C1 technical acceptance and all instructional-motion approvals remain open. See the [master roadmap](20-MASTER-ROADMAP.md); the gates below remain binding.
**Owner feedback:** V0.2 motion study contains many incorrect poses; low-quality procedural character cannot be teaching standard.

## Immediate production freeze
- Keep existing V0.2 HTML as a historical UI interaction experiment only.
- Do not reuse generated SVG body coordinates, mirrored pose output, or shape morphing as instructional truth.
- No Footwork/Jab visual production until **one** Stance & Guard demonstration passes visual, motion, and coach validation.
- Ensure current public deployment retains visible unverified-preview labeling; consider replacing incorrectly posed motion in any teaching-facing release with a disabled / 'rebuilding' placeholder.

## Explicit roles
1. **Product owner** approves character style, outfit, presentation and final UX.
2. **3D character artist/rigger** certifies character mesh/rig technical quality.
3. **Qualified boxing coach** reviews technique and approves/rejects exact final media version; no self-certification by assistant.
4. **Engineering** integrates only approved media and honors media lifecycle state.

## One-asset review card
- asset ID + revision
- discipline, technique, stance orientation and camera
- source-reference owner, license and link
- full-body neutral turnaround approval ID
- rig version
- video sequence frame-range mapping for key poses
- pose/transition issues found, severity and correction status
- coach's qualifications, name, date, decision
- owner visual decision/date
- delivery optimization/compression, readability, device testing
- status (concept -> character-approved -> rig-verified -> coach-pending -> approved / rejected)

## Pose frame checklist — mandatory
- Clear left/right and lead/rear annotation at each chosen orientation.
- Stable believable weight distribution and a consistent supporting base.
- No impossible torso twist or dislocated-looking shoulders/elbows/wrists/hips/knees.
- Heel / toe and ground contact readable in every required view.
- Hands, head and elbows are consistent with approved instructional reference.
- No interpolation arcs that invent unsafe intermediate positions.
- Neutral, stage-by-stage, full sequence and slow playback all convey one consistent movement.
- No movement proceeds when applicable approval evidence is missing.

## Evidence-based coaching sources
- England Boxing 2026 Part 1, technical skills: https://www.englandboxing.org/wp-content/uploads/2026/02/EB_Boxing-Coaching-Handbook-Part-1_09_02_26.pdf
- Boxing Canada 2024 Instruction-Beginners, stance and footwork pp. 41–48: https://boxingcanada.org/wp-content/uploads/2025/01/Instruction-Beginners-Reference-Manual-EN.pdf
- Blender rig IK constraints: https://docs.blender.org/manual/en/5.1/animation/constraints/tracking/ik_solver.html

The manuals may be referenced for research but not reprinted as copyrighted app assets.

## Concrete next deliverable, and what it is not
**Current next deliverable, after roadmap acceptance:** a bounded natural static-standing presentation review using the existing character, inside Android. Preserve identity/outfit. Historical neutral turnaround and technical rig work already exist; do not repeat them as if production has not started.
**Not next:** new skills, skeletal script polishing, vague AI-generated motion, Android APK, unsourced certificate of correct stance.

## Acceptance test plan for neutral character
- Four-angle identity agreement and exact costume matching.
- Same anatomy at each angle (no face/hand/foot mutations).
- Face/skin/hair stable; no inconsistent shadows that conceal the silhouette.
- Realistic hand sizes and foot contact; neutral stance only.
- Contrast and readibility on 360/390/430dp portrait screens.
- Artist flags each difference; owner approves master identity BEFORE rigging.

## Financial/technical risk
Real 3D mesh/rig and qualified validation require time, expertise and potentially licensed footage/capture. Free tools may help, but do not promise a zero-cost photoreal coach-reviewed rig. When costs are unknown, design with alternative real-coach footage path and keep research early.

## Freeze resolution
Only after art approval C0 -> verified rig C1 -> real reference C2 -> qualified animation review C3 -> owner release C4 should we expose animation as training instruction. Use status to prevent premature promotion.
