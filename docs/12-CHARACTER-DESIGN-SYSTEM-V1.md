# 12 — Character design system V1: Instructor A01

**Date:** 2026-11-10  
**Status:** New design-direction proposal for owner review. NO final trainer art/model approved, NO motion certified.  
**Trigger:** Owner tested V0.2 and reported numerous incorrect poses and low-quality animated character. Production must change direction; do not expand the SVG animation.

## Outcome required
A single consistently identifiable premium trainer whose neutral anatomy and costume are approved **before** creating teaching motions. Character identity and biomechanical accuracy are two different gates; both are mandatory.

## Decision review
| Approach | Visual ceiling | Movement validation | Cost/complexity | Decision |
|---|---|---|---|---|
| Programmatic flat SVG joints | Low | Cannot represent reliable 3D body/foot rotation | Low | REJECT for instructional use; historical experiment only |
| Uncontrolled AI pose image/video per step | High for a still, poor continuity | Not trustworthy; anatomy changes frame-to-frame | Medium but inconsistent | REJECT for instructional use |
| Film qualified instructor, rights cleared | Photorealistic | Directly reviewable by another qualified coach | Requires coach/capture | ACCEPT as reference truth and fallback instructional media |
| Consistent 3D character + licensed real-instructor motion reference, manually refined by animator, coach reviewed | Premium, consistent, adjustable camera/lighting | Plausible only after expert review of every final clip | Higher | PREFERRED target for interactive academy |
| Motion capture alone | Variable | Occlusion and retargeting errors remain | Variable | Supporting input only, never automatic approval |

## Proposed character identity
**ID:** INSTRUCTOR-A01  
**Name on screen:** Coach (no invented real-world credentials or named person)  
**Presentation:** Adult athletic human trainer, believable proportions, efficient/functional muscular build (not superhero/bodybuilder), neutral approachable facial expression, confident but not aggressive.

**Visual style:** Contemporary premium *stylized realism* — real anatomy, naturally detailed skin/materials, subtle artistic simplification for reproducibility and rendering, not plastic cartoon, anime, comic muscles or uncanny photoreal AI compositing.

**Wardrobe:** Matte charcoal fitted training tee; tailored black boxing shorts; discreet vivid crimson trim; low-profile black boxing shoes; dark wraps where appropriate; no oversized gloves that obscure hand position; no copyrighted logos. Clothing should allow observation of shoulder, elbow, hip, knee, ankle and wrist alignment. Avoid sleeveless costume solely for aesthetics if it obscures landmark readability with lighting.

**Appearance consistency:** one facial/head model, one hair style, one body mesh, one costume specification, one lighting profile, one full-body proportion sheet across viewpoints. No switching faces, proportions or hair between screens; variant skins/uniforms are future work.

**Environment:** Cinematic obsidian training studio, controlled crimson accents, subtle cobalt rim light; **neutral instructional key lighting** ensures shoulders, hands, feet and ground contact remain readable. Atmosphere belongs behind the athlete, not across anatomy.

**Instructional camera principles:** Full body including feet, enough floor margin, minimal perspective distortion. Primary 3/4 view; separate *actual* front, side and rear footage / render when technically required. Never invent angle buttons from unrelated generated stills; no virtual 360 camera unless real 3D rig exists and is approved.

**Phone readability:** Strong silhouette at ~360–430dp screen widths. At lesson scale, feet, hands and guard must remain readable. Character should not be blocked by UI callouts or decorative neon glows.

## Character design deliverables and gates

### Gate C0 — Neutral turnaround (design only)
- Front, left profile, rear, 3/4 full-body views, all same proportions/outfit.
- Neutral **A-pose** (arms relaxed and slightly apart) or ordinary standing position; NO boxing coaching stance.
- One close-up showing realistic face, hands, shoes and materials.
- Color/material swatches and minimum readable lighting.
- Owner selects/revises one master identity. Even if approved, it is NOT a certified boxing trainer.

### Gate C1 — Rig technical validity
- Stable mesh topology, bound armature, correct root/pelvis/limb hierarchy.
- Explicit anatomical joint controls with sensible ranges; IK for grounded legs, constrained foot planting; arm FK/IK and clavicle/scapular coordination, no grotesque joint reversal.
- Stable finger, elbow, shoulder, hip, knee, ankle articulation across test poses (neutral/raised hands/weight shift), reviewed by qualified character animator.
- No visible ground sliding, clipping or deformation on turntable and test animations.
- Render at actual mobile instructional resolution; check clothing/hands/feet readability.

### Gate C2 — Qualified reference capture
- Source real trainer footage with permission and demonstrable qualification.
- Capture stance orientation separately (orthodox and southpaw), full-body front/profile/3/4.
- Studio lighting and leg/hand visibility prioritized over drama.
- Record coach technical checklists for each movement; no invented biomechanics or training doses.

### Gate C3 — Motion production
- Retarget footage / use mocap only as starting material.
- Hand-correct pelvis, spine, shoulders, hand guard, knees, feet and floor contact frame by frame.
- Produce phase markers and full-speed / slow-speed versions from ONE motion master, not synthetic separate poses.
- Coach reviews final delivered *render*, including each enabled camera and both stance orientations.

### Gate C4 — Owner accepts rendered instruction
- Side-by-side with real reference and qualified reviewer notes.
- Owner approves visual fidelity and teaching clarity.
- Only then replace the current experimental schematic in the app.

## Prototype media rendering decision
**Preferred first reliable release path:** Coach-reviewed **pre-rendered MP4 loops** of the single model with pause/seek/step/camera angle clips, synchronized annotation metadata. This gives stronger predictable look and battery/performance on modest Android devices than shipping an unrestricted runtime 3D rig at this stage. Source animation should be authored in a real 3D tool (e.g., Blender) and remain editable. Interactive realtime model rotation could be a later milestone.

No new animation engine, paid stock, proprietary character asset, motion capture subscription or video license is authorized just by this document.

## Strict art acceptance rubric
- Identity continuity: 0 face/body/costume contradictions across views.
- Anatomy: believable neutral pose and plausible skin/cloth deformation, no visible broken joint.
- Perceptual fidelity: unmistakably premium at actual phone scale without oversaturated glow.
- Pedagogical clarity: ground contact, hand guard and foot offset unoccluded.
- Technical review: all instructional frames require independently qualified sign-off. One major technical error = automatic rejection, regardless of art quality.

## Status
C0 NOT APPROVED; C1–C4 NOT STARTED. Character concept art may be created for C0 but must not include an allegedly correct martial-arts pose.
