# A01 C1 — Real 3D geometry test bench

**Live preview:** https://martial-arts-a01-c1.vercel.app/

This is an *engineering experiment*, not a trained/final A01 avatar. It pairs the approved visual identity with a separately sourced MakeHuman-derived CC0 neutral character base. A correct neutral 3D loader/rig is the first technical prerequisite, not proof that its movement is safe.

## Available UI
- Front / ¾ / side / back orbit camera buttons and optional orbit mode.
- An embedded A01 2D character-reference sheet.
- Candidate model + required clothing loads from a pinned public upstream commit.
- Real bone, mesh and geometry figures displayed **only after successful loading**.
- Local review notes and a downloadable C1 inspection JSON.

## Important restrictions
- We have not created a custom A01 .blend, rigged A01 model, accurate face/hair, or reviewed boxing movement.
- The UI never awards a coach badge or marks the character's appearance gate complete because a skeleton loaded.
- The external model viewer requires Internet access, WebGL and reachable third-party JS/GLB hosts. If loading fails, it retains the reference art and displays a failure notice.
- This tool was not independently tested on iPhone or Android, though its HTML and scripts passed local syntax/static checks.
- Hosting project is public so the owner can open on Safari without a download. Avoid entering personal/secret information in notes even though notes stay in browser-local storage.

## Source and licensing
GLB files are read from https://github.com/kblood/CharacterCreator at pinned revision `852e48f316b90a0937234886630e4fb4cdfd1f78`. That repo says its generated `output/*.glb` are CC0-1.0. Upstream **code** is GPL-3.0-or-later; it was not copied into this app. Three.js is MIT. Review license provenance for any future commercial use.

See [C1 production gate and report](../docs/15-C1-GEOMETRY-EXPERIMENT.md).

## Reproducible local checks
```sh
node character-c1/check-page.cjs
node character-c1/validate-glb.cjs --selftest
# If you obtain an actual GLB file:
node character-c1/validate-glb.cjs /path/to/model.glb
```
Passing GLB structure checks DOES NOT verify anatomy, identity, deformation, or boxing technique.
