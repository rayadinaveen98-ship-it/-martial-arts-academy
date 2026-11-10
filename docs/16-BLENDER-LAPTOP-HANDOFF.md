# Laptop handoff — Instructor A01 (C1)

**Prepared:** 2026-11-10  
**State:** Ready-to-run instructions and an untested-in-Blender audit script; **NOT** a completed character or rig.

## Why this exists
When the owner gets to their laptop with Blender, we should preserve the existing A01 design, never regenerate random humans, and establish evidence about a genuine mesh/rig before attempting Stance & Guard movement. The owner approved A01's **visual direction**; exact model conformity is not yet approved.

## First laptop session: minimum steps

1. Open or install a supported Blender release from https://www.blender.org/download/ .
2. Open the existing martial-arts-academy GitHub repository on the laptop; obtain the latest main branch. Do not rename it in scripts until the owner renames it in GitHub.
3. Use a trustworthy, rights-cleared neutral human mesh, initially **without movement animations**. Existing [C1 base-model experiment](../docs/15-C1-GEOMETRY-EXPERIMENT.md) identifies one external candidate, but it is not a finished A01 model and its visual/skin quality has not been accepted.
4. In Blender, inspect the model **front, profile, back, three-quarter**. Save a working source file as `a01_neutral_working.blend`; do **not** overwrite a third-party original.
5. Run the read-only structural audit below. It produces a JSON file showing mesh objects, vertex coverage, armatures and missing textures. It never creates or approves a pose.
6. Capture four real renders from ONE actual model and compare to our [A01 concept reference](../docs/12-CHARACTER-DESIGN-SYSTEM-V1.md). Record issues rather than claiming the character is complete.
7. Only after geometry, materials and appearance match and the owner approves: conduct a *neutral joint-deformation* test. Technique animation remains blocked pending real-coach reference and qualified review.

## One command after saving the Blender file

Run from the cloned project directory:

```sh
blender --background a01_neutral_working.blend --python tools/blender/audit_a01.py -- --report reports/a01-scene-audit.json
```

On Windows, if `blender` is not on PATH, run the full path to the Blender executable instead. Blender officially supports `--background --python script.py`: https://docs.blender.org/api/5.1/info_tips_and_tricks.html

**Interpretation:** Meshes, armatures and armature modifiers are only basic structure. A high bone count, unweighted-vertex count of zero, or correct-looking thumbnail does not guarantee sane skinning, biomechanics or accuracy. No score in this report approves a boxing stance.

## Visual acceptance criteria

- Same approved face, hairstyle, build, clothes, materials, footwear and red trim in four actual model-camera renders
- Full-body neutral view with both feet visible; believable hand/finger anatomy
- Front and side materials do not conceal elbow, shoulder, knee or ankle articulation
- No shoulder collapse, elbow inversion, knee clipping or shoe floor sliding in **neutral** deformation probes
- Inspect at real mobile display size as well as desktop resolution
- Owner accepts 3D look and a competent rigger confirms geometry/weights
- Any instructional movement requires separate coach-verified media and rights clearance

## Version-controlled deliverables

The audit script lives in `tools/blender/audit_a01.py`. The generated files should be kept private while under review, and can be added later only after rights/license and file-size checks:
- `a01_neutral_working.blend` — editable local source
- `reports/a01-scene-audit.json` — structural data, not pass/fail certificate
- `renders/a01_front.png`, `a01_profile.png`, `a01_back.png`, `a01_threequarter.png` — real scene renders
- `reviews/C1-notes.md` — specific errors, fixes, and owner approval record

Do not commit copyrighted reference photos, unlicensed base meshes, personal paths or credentials. Large GLB/BLEND files may need Git LFS or an approved storage strategy. Do not download random Blender extensions to a trusted local environment without checking safety and license.

## After owner returns to laptop
We can build/rerun scripts in supported local Work/Codex tooling only when the user grants access. Installing Blender alone does not grant remote computer control.

**C0:** visual target approved. **C1:** script and plan prepared, Blender execution and actual model still pending. **C2–C4:** blocked.
