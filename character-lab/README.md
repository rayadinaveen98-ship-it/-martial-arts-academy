# Instructor A01 — C0 Character Lab

**Status:** Neutral concept review only. **No actual editable 3D model, rig or validated boxing motion exists.**

**Hosted mobile review:** https://martial-arts-a01-character-lab.vercel.app/

## What it does
- Displays the four 2D neutral views from **one previously generated character sheet** (front, left profile, rear, three-quarter).
- Provides a zoomable full-body viewer, angle selection, full comparison grid and clickable outfit/material close-ups.
- Includes ten visual QA checkpoints, local notes and copy/download review report.
- Persists choices locally in the browser. No account, backend or data upload.

## What it does NOT do
- It does not contain a coherent real 3D mesh or rig. Views are cropped images from concept art and can have perspective/anatomy discrepancies.
- It does not teach stance, guard, footwork or punching technique.
- It does not automatically submit owner approval to the GitHub issue.
- Clicking all checkboxes does **not** certify the character; owner must approve after seeing the visuals.

## C0 acceptance
Owner checks identity, proportions, hand/foot anatomy, costume consistency, silhouette, lighting and joint visibility. Collect corrections and revise one reference before starting 3D development.

## Technical proof
- One HTML file with embedded optimized WebP assets and no external JS, fonts or APIs.
- Static integrity check: `node character-lab/check-lab.cjs` validates core interactive controls, embedded images, WebP headers, JavaScript syntax and disclosure language.
- Node static check **passed locally** 2026-11-10. Chromium was unable to produce a browser screenshot in this environment; no actual iPhone performance/interaction verification exists yet.
- Hosting reports READY and Vercel SSO/password protection disabled for this new project, but web-fetch verification was unavailable.

## Next production step
Read [A01 feasibility and quality gates](../docs/14-A01-CHARACTER-GATE-AND-3D-FEASIBILITY.md). After owner C0 approval, attempt a real MPFB/Blender mesh/rig feasibility pass and render a proper neutral turnaround. Do not author any martial-arts motions from the old procedural SVG.
