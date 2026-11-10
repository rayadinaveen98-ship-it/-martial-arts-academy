# 15 — C1 geometry experiment and exit gate (2026-11-10)

## Approval captured
Product owner responded "All good bro continue" following the A01 neutral Character Lab. This advances **A01's visual concept direction (C0) to accepted for C1 experimentation**. It is not approval of a 3D model, its rig, or any actual boxing pose.

## Work actually delivered
- [C1 interactive geometry bench](../character-c1/index.html), browser preview at https://martial-arts-a01-c1.vercel.app/
- Paired A01 approved character-sheet reference (embedded as a lightweight image) with a **distinct, real externally hosted 3D baseline** from CC0 MakeHuman-based assets.
- Implemented 3D camera view selection (front, three-quarter, side, back), orbit toggle, and responsive premium UI around a genuine GLB loader.
- If an online 3D asset loads: runtime traverses the glTF and reports counted bone nodes, mesh sections, skinned mesh sections and scene bounding-box height. No invented counts in the interface.
- The 3D base cannot be shown without all three essential garment models loading; user sees a non-technical fallback instead.
- Review notes are browser-local, and report can be downloaded as JSON. No server account needed.
- HTML/source and structural test scripts committed in GitHub.

## Source / intellectual-property provenance
Upstream technical baseline (not the owner-approved A01 identity): https://github.com/kblood/CharacterCreator
Pinned upstream revision: `852e48f316b90a0937234886630e4fb4cdfd1f78`.
Base source GLB: https://raw.githubusercontent.com/kblood/CharacterCreator/852e48f316b90a0937234886630e4fb4cdfd1f78/output/base_body.glb
Companion files: `clothing_tshirt.glb`, `clothing_shorts.glb`, `clothing_shoes.glb`, `hair_short02.glb`.
Source repository declares output assets CC0-1.0; **its software source is GPL-3.0-or-later**. We do **not** copy upstream GPL source into our proprietary product. Verify asset provenance and downstream licenses before incorporating any derivative into a release. We are referencing GLB files from a public pinned commit for experimentation only.
Three.js loaded from a pinned CDN release (MIT); production use requires dependency/license audit and preferably locally hosted assets.

## Verification and limitations
1. This environment lacks Blender/MPFB, so **no original A01 mesh, .blend file or new rig was produced**.
2. The connected 3D-generation product has 0 available generation credits; no paid generation was attempted.
3. The candidate GLB and outfit files were verified as present in upstream GitHub by file metadata/SHAs. Our tool could not fetch their binary bytes into this execution container; therefore local Blender/trimesh deformation tests were impossible.
4. Local tests passed: JavaScript syntax, inspection page static controls and truthful status labels, and a GLB parser's synthetic positive/negative format checks. The binary parser is designed to refuse false "coach approved" state.
5. Vercel deployment state reports READY, default hostname assigned and password/SSO protection disabled. **No independently verified iPhone 3D render exists**; external CDN or GLB loads may fail and should show fallback.
6. Actual proportions, limb weights, bone deformations, material fidelity, clothing fit and compatibility are unverified; no A01 identity match can be claimed.
7. No boxing technique animation, mocap, footage, or coach assessment was generated.

## C1 rejection rules
- Base structure succeeds while A01 face/hair/physique/outfit differ => **A01 C1 rejected**.
- Static rig may contain bones while deforming implausibly => **deformation test rejected**.
- External 3D view renders but visually misrepresents technique => **cannot use for teaching**.
- Mirrored stance or interpolation does not count as separately reviewed technique.
- One obvious anatomical flaw in teaching poses blocks promotion.

## Next evidence needed
1. Test live rig baseline on an iPhone and Android browser; record load time and any errors.
2. Obtain a real editable Blender/MPFB environment with MakeHuman CC0 base assets, or a vetted freely licensed neutral rig asset.
3. Model A01's proportions, head, hair, charcoal uniform, wrist wraps and shoes using **one actual geometry system**, then render a consistent four-camera turnaround.
4. Check mesh skin weights with neutral joint range tests: shoulder, elbow, fingers, hips, knee, ankle and foot-ground anchoring.
5. Only after C1 visual/deformation acceptance, source rights-cleared coach footage for one stance sequence (C2) and run qualified coach review (C3).

## Explicit status
**C0 appearance reference:** approved to proceed. **C1 actual A01 mesh/rig:** NOT complete. **C1 external baseline viewer:** implemented, hosting READY, actual browser GLB load unverified. **C2–C4:** blocked.
