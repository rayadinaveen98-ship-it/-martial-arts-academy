# 06 — Boxing Foundations: lesson-by-lesson curriculum

**Version:** research draft 0.1, 2026-11-10  
**Approval:** NOT signed off by a qualified boxing coach. Intended for product/content pre-production; **not yet release-ready physical instruction**.

## Source register
- **EB26** — England Boxing, *Boxing Coaching Handbook Part 1* (February 2026), section 4.4, printed pp. 66–73: https://www.englandboxing.org/wp-content/uploads/2026/02/EB_Boxing-Coaching-Handbook-Part-1_09_02_26.pdf
- **BC24** — Boxing Canada, *Instruction-Beginners Reference Material* (copyright 2024), chapter 5, printed pp. 41–53: https://boxingcanada.org/wp-content/uploads/2025/01/Instruction-Beginners-Reference-Manual-EN.pdf
- **WHO** — WHO, *Physical activity*: https://www.who.int/health-topics/noncommunicable-diseases/physical-activity
- Technical summaries are paraphrases of the manuals, not reproductions of their illustrations. **Do not copy source images/video into the app without permission.**

## Design principle
The skill pathway is a **dependency graph**, not three unrelated tutorial cards:
`Stance and Guard -> Basic Forward/Backward Footwork -> Stationary Lead-Hand Jab`.
Every stage first shows/teaches concepts, checks conceptual comprehension, then offers optional, comfortable, non-contact practice only with reviewed instructional media.

## BOX-001 — Stance and guard
**Purpose:** Explain how the feet, knees, torso, head and hands work together to produce a balanced and defensively responsible starting position.

**Learning objectives**
1. Identify the lead and rear sides for a chosen orthodox or southpaw setup.
2. Recognize why an offset base, relaxed knees, and centered balance matter.
3. Recognize the purposes of a guard (protection, relaxed readiness, recovery).
4. Spot common errors in *illustrative diagrams*: narrow/overwide stance, squared-up torso, raised chin, low hands, elbows flared, excessive tension.

**Reviewed reference principles — draft for coach verification**
- EB26: avoid feet too close or too far apart; slight knee bend; rear foot offset; rear heel not planted flat; body shouldn't be excessively square.
- BC24: stable, individually comfortable foot spacing; balance between feet; relaxed guarding hands; elbows comfortably protecting the body; head position not exposing the chin.
- Avoid rigidly enforcing an exact degree/centimeter measurement via UI or a text-only description; anatomy and technique may vary by learner and coaching style.

**Concept presentation**
- Short reason-first explanation: 'Balance before speed'.
- Show front/side annotated diagram or licensed reviewed trainer media; minimum poses: ready stance, guarded stance. Distinguish visual mockups from teaching images.
- Display left/right orientation toggle **only after** both orientations independently reviewed.

**Interactive checks**
- Select the image representing an offset balanced stance (diagrams must first be validated).
- 'What happens if feet come together while moving?' Correct concept: base/defensive readiness compromised.
- Identify one role of the rear hand in a guard.

**Practice design — pending coach review**
- Readiness/space prompt; gentle warm-up; comfortable stance awareness and brief pause-based self-reflection.
- Users should be able to stop with no penalty. No camera assertion of correctness, no competitive speed target.

**Completion and unlock**
- Reading/understanding check completed => Footwork lesson becomes available.
- Log: `lessonViewed`, `quizAttempts`, `quizPassed`, `practiceSelfReported`, `reviewNotes`.
- **Never label the user technically proficient based on these signals.**

**Review questions**
- What consistent interpretation of stance width is appropriate for adult beginners?
- Which camera angle makes rear heel and foot offset accurately visible?
- Does text on head position avoid excessive neck flexion/tension?

## BOX-002 — Basic forward/backward footwork
**Prerequisite:** BOX-001 concept check completed.  
**Purpose:** Preserve a defensible stance while changing distance.

**Learning objectives**
1. Explain why feet should preserve a useful width/depth relationship when advancing or retreating.
2. Identify lead/rear foot and which initiates the movement.
3. Recognize prohibited errors: crossing feet, bringing feet together, exaggerated hops, excessive stride, losing guard.

**Source-grounded draft sequence**
- BC24 pp. 45–48: advancing uses push-off from rear, lead foot travels forward first, rear foot follows to restore original base. Retreating uses push-off from front, rear foot goes back first, front follows.
- EB26 pp. 67–68 emphasizes controlled short movements, minimal bouncing, and maintaining base. This describes *basic progression*; variations exist.
- Sideways travel and pendulum footwork are outside the initial active lesson (research only).

**App interaction**
- First a tap-to-order sequence of foot movements, separately for advancing and retreating.
- Then select 'base retained' versus 'feet crossed' in reviewed images.
- Optional short comfortable no-contact rehearsal, with pause and rest; user reflection asks whether stability felt maintained.
- Diagrams must change in sync with the selected stance orientation; a naive CSS horizontal flip does **not** equal a technical review.

**Common errors to represent (in approved diagrams only)**
- Lead foot travels too far, creating a stretched base.
- Feet meet/cross in the middle of a step.
- Excessive bounce, loss of balance, dropped hands.
- Rear heel rigidly rooted to the floor.

**Completion**
- Concept checks completed; personal practice logged separately. Unlock BOX-003 regardless of self-scored 'mastery'.
- No accuracy percentage produced without validated measurement.

**Review questions**
- Should full four-direction footwork be added after the concept prototype? Default NO pending owner approval.
- Does coach want the drill to prioritize even weight transfer, base length, or smooth rhythm first?

## BOX-003 — Lead-hand jab (no-contact concept)
**Prerequisites:** BOX-001 and BOX-002 comprehension completed.
**Purpose:** Show the relationship of the lead hand to the base and rear-hand guard, and the need to recover to guard.

**Learning objectives**
1. Know that the jab is a straight punch using the lead hand, not automatically the left.
2. Recognize rear-hand guard, balance and prompt recovery as important.
3. Identify 'telegraphing' (pulling the lead hand backward before punching) and leaving the lead hand extended as mistakes.
4. Differentiate conceptual drill completion from a coach's assessment of technical execution.

**Coaching references**
- EB26 pp. 72–73: punch mechanics rely on base, torso coordination, a protected non-punching hand and prompt return to guard.
- BC24 pp. 52–53: lead-hand extension, controlled forearm rotation, rear guard, balanced stance, quick recovery and error analysis.

**IMPORTANT RESEARCH DISCREPANCY (must be adjudicated)**
- England Boxing describes **keeping the wrist straight to prevent injury** in its general punch mechanics section (printed p. 72).
- Boxing Canada's jab section describes the striking wrist as **slightly flexed** in its text (printed p. 52–53).
- These formulations must **not** be flattened into one unreviewed instruction or presented as 'identical'. Qualified coach must approve the intended wrist/knuckle description, equipment/contact context, shot/animation and on-screen cues.
- Until resolved, **no impact, target contact or wrist close-up animation as authoritative instruction**. Early prototype is conceptual and non-contact.

**Storyboard states (coach-reviewed before instructional use)**
- Start: balanced stance + lead/rear identification.
- Preparation: no visible exaggerated wind-up.
- Demonstration: lead hand moves along a straight path; other hand remains in guard; no artificial hyperextension.
- Recovery: lead hand returns to its guard position with balance preserved.
- Frame-by-frame checks: shoulder/elbow/wrist alignment, torso movement, chin/rear guard, foot base and foot-to-floor contact.

**Interactive checks**
- 'Which is the lead hand in this setup?' Must dynamically correspond to stance selected.
- 'What does your rear hand do?' Expected: stays protecting guard.
- Order the phases of the jab (ready, extend, recover).
- In the drill, **no speed/power scoring**; record whether user chose to practise and how they felt.

**Completion**
- All concept checks complete and learning record saved.
- Progress screen says '3 concepts explored' and 'practice sessions logged', not 'Jab mastered'.

## Curriculum exclusion list (v0.1)
- High-speed maximal punches or contact, heavy-bag striking, pads/partner practice, head impacts, sparring, combative scenarios.
- More advanced defensive techniques, cross, hooks, kicks, knee/elbow strikes, throws, joint locks.
- Biometric readiness scoring, filming users for automatic correction, gamified penalties for low training time.

## Source-quality / release gate
Written technique descriptions are **research-informed drafts**. Before a practice video/animation is marked approved: source-rights record, exact stance orientation, qualified coach sign-off, accessibility review, UX comprehension review, and physical-safety review for the intended audience.
