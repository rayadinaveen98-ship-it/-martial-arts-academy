# 14 — Instructor A01: character gate & 3D production feasibility

**Date:** 2026-11-10
**Stage:** Character concept review (C0), not model creation
**Reason:** Owner found major pose inaccuracies and low fidelity in the v0.2 procedural fighter.

## C0 approval update — November 10, 2026
The owner accepted the A01 visual concept direction and authorized continuation. This **does not** constitute approval of any completed geometry/rig. The distinct C1 technical model experiment is documented in [15-C1-GEOMETRY-EXPERIMENT](15-C1-GEOMETRY-EXPERIMENT.md).

## Direct decision
**Freeze all instructional movement animations.** Retire the old SVG pose study as a teaching representation. Preserve its playback controls and learning state as UI research only. Prioritize a single character specification and true, consistent neutral turnaround; then test a real mesh and rig, and later motion based on a qualified coach.

## Working visual reference
A01 neutral 4-angle image created in the visual exploration. The concept is a charcoal technical-shirt / shorts / low-profile boxing shoes / muted crimson trims athlete under controlled studio lighting. The art direction is a **working reference, not a locked 3D character**.

**Important:** an image of 4 poses is not equivalent to a coherent 3D body or a rig. Faces, hands and proportions may vary slightly despite apparent similarity. No fake 360-degree claim.

The interactive [Character Lab C0](../character-lab/index.html) uses cropped views from that exact same sheet and lets the owner inspect the front, profile, rear, 3/4, materials, zoom, and record 10 checklist items and local notes. It does not upload notes automatically or certify technical correctness.

## Researched free/low-cost character workflow

| Layer | Candidate | Evidence and conditions | Status |
|---|---|---|---|
| Base humanoid | MPFB2 / MakeHuman community | Free/open-source Blender human generator, editable body, materials and basic rigging; core graphical assets CC0 per official license (third-party extensions may have different terms) | **Recommended feasibility candidate, NOT installed** |
| Rig/pose tooling | Blender + Rigify | IK/FK armatures and controls; official docs explicitly say rig controls do **not** automatically attach to mesh, still needs proper skinning | **Recommended, NOT installed/tested here** |
| Look development | Human-assisted sculpt, clothing, texture/shader, lighting | Must match agreed A01 across all camera angles | **Unstaffed / no master mesh exists** |
| Instructional truth | Rights-cleared qualified boxing-coach footage | Movement must be checked in every view, orientation, speed and recovery | **Blocked until rights + reviewer** |
| Mobile delivery | Approved pre-rendered MP4/AV1/H.264 variants with keyed cues | More predictable consistency than running a heavy editable character rig in basic Android devices | **Proposal only** |

### Primary tool sources
- MPFB overview: https://www.makehumancommunity.org/mpfb/index.html
- MPFB features and Blender rig options: https://www.makehumancommunity.org/mpfb/about.html
- MakeHuman/MPFB license: https://www.makehumancommunity.org/about/license.html
- Blender Rigify manual: https://docs.blender.org/manual/en/4.5/addons/rigging/rigify/introduction.html
- Blender animation and rigging features: https://www.blender.org/features/animation/

### Important feasibility boundary
The available execution environment has Node and Python but **no Blender executable installed** at the time of this assessment. The presence of libraries or documentation does not equal a built/rendered/validated 3D athlete. **Do not claim C1 or that any .blend/.glb file exists.** MPFB is a sensible *tool candidate*, not proof the app can reach the concept art unchanged or at zero cost.

## A01 design lock — C0 checklist
1. Same face, hairstyle, body build in all four views (no identity morph).
2. Realistic neutral anatomy; no oversized forearms, hands or exaggerated torso.
3. Hands and fingers have a stable, functional appearance.
4. Shoe shape and body-to-ground contact plausible.
5. Outfit and seam pattern consistent front, side, rear and 3/4.
6. Neutral standing pose only; not disguised instructional martial arts pose.
7. Shoulder, elbow, hip, knee and ankle silhouettes readable.
8. High-end materials without obscuring important joints.
9. Good readability on actual 390dp mobile canvas, not just glossy large poster.
10. Owner explicitly approves or requests revisions to the neutral design.

C0 approval does **not** approve C1 rigging or C2+ movement.

## C1–C4 plan
- **C1 Mesh:** one real editable humanoid mesh, neutral full-body rotation, single face/garment. Rigger evaluates topology, weights, IK/FK, limb control and deformation. Produce **actual render** front/profile/rear/3/4 as comparison with the visual spec.
- **C2 Reference:** instructor credential and filming rights, two separate stance orientations with camera coverage. Detailed source/rights record.
- **C3 Motion:** animator creates one Stance & Guard sequence with keyframes sourced from C2; coach checks transitions, foot contact, hands/guard and camera for technical correctness.
- **C4 Instructional deployment:** owner signs off on appearance and understanding; media metadata carries coach review and revision. Only C4 clips can be instructional.

## Blocking decisions
- The owner accepted A01 as the visual target; the final 3D shape and materials remain subject to separate review.
- No custom **A01** mesh, skin weights, rig or GLB exists. An external open-source rigged baseline is available for comparison, not part of A01 yet.
- No qualified boxing coach signed off on content.
- No rights-cleared footage has been obtained.
- No device/emulator full visual acceptance has occurred.

## QA gates / acceptance evidence
C0: owner-reviewed stills + resolved inconsistencies.
C1: editable source model + actual rendered turntable + pose/deformation checks.
C2: source footage rights, person permissions, credentials.
C3: review report tied to exact media version.
C4: mobile UI playback/seek/reduced motion verified and release status locked.

## Action policy
Do not restart from the rejected SVG when building instructional animations. Do not add Footwork or Jab movements before one credible Stance & Guard motion passes C0–C4. Keep the academy UI/playback logic as independent reusable work.
