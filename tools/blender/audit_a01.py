#!/usr/bin/env python3
"""Read-only Blender scene audit for Instructor A01 C1.

Usage:
  blender --background path/to/a01.blend --python tools/blender/audit_a01.py -- --report reports/a01-scene-audit.json

The report is informational. Mesh/rig existence is not proof of deformation,
visual fidelity, movement safety, or boxing instruction quality.
This script does not create poses, export or save any .blend file.
"""
import argparse
import json
import os
import sys
from datetime import datetime, timezone

try:
    import bpy
except ImportError as exc:
    raise SystemExit("Run with Blender's Python interpreter: blender --background ... --python audit_a01.py") from exc


def options():
    args = sys.argv[sys.argv.index("--") + 1:] if "--" in sys.argv else []
    parser = argparse.ArgumentParser(description="Read-only A01 Blender scene report")
    parser.add_argument("--report", default="reports/a01-scene-audit.json",
                        help="JSON output path; directories will be created if needed")
    return parser.parse_args(args)


def mesh_summary(obj):
    mesh = obj.data
    vg_indices = {group.index for group in obj.vertex_groups}
    weighted = sum(
        1 for vertex in mesh.vertices
        if any(g.group in vg_indices and g.weight > 0 for g in vertex.groups)
    )
    armature_modifiers = [
        modifier for modifier in obj.modifiers if modifier.type == "ARMATURE"
    ]
    targets = [modifier.object.name if modifier.object else None
               for modifier in armature_modifiers]
    return {
        "name": obj.name,
        "vertices": len(mesh.vertices),
        "polygons": len(mesh.polygons),
        "shape_key_count": (
            len(mesh.shape_keys.key_blocks) if mesh.shape_keys else 0
        ),
        "vertex_group_count": len(obj.vertex_groups),
        "weighted_vertices": weighted,
        "unweighted_vertices": len(mesh.vertices) - weighted,
        "armature_modifier_targets": targets,
        "dimensions_scene_units": [round(float(v), 5) for v in obj.dimensions],
        "material_slots": [slot.material.name if slot.material else None
                           for slot in obj.material_slots],
    }


def armature_summary(obj):
    return {
        "name": obj.name,
        "bones": len(obj.data.bones),
        "deforming_bones": sum(bool(bone.use_deform) for bone in obj.data.bones),
        "bone_names": [bone.name for bone in obj.data.bones],
        "dimensions_scene_units": [round(float(v), 5) for v in obj.dimensions],
    }


def image_summary(img):
    raw_path = img.filepath or ""
    packed = bool(img.packed_file)
    exists = True if not raw_path or packed or img.source in {"GENERATED", "VIEWER"} else os.path.exists(bpy.path.abspath(raw_path))
    return {
        "name": img.name,
        "source": img.source,
        "packed": packed,
        "path_exists": exists,
    }


def build_report():
    objects = list(bpy.data.objects)
    meshes = [mesh_summary(obj) for obj in objects if obj.type == "MESH"]
    arms = [armature_summary(obj) for obj in objects if obj.type == "ARMATURE"]
    images = [image_summary(image) for image in bpy.data.images]
    rigged = [mesh for mesh in meshes if any(mesh["armature_modifier_targets"])]
    warnings = []
    if not meshes:
        warnings.append("No mesh objects in source scene.")
    if not arms:
        warnings.append("No armature objects found; no evidence of rigging.")
    if meshes and not rigged:
        warnings.append("No mesh object has an armature modifier.")
    if any(mesh["unweighted_vertices"] > 0 for mesh in rigged):
        warnings.append("One or more skinned meshes have unweighted vertices; inspect manually.")
    if any(not image["path_exists"] for image in images):
        warnings.append("Some external image textures appear unavailable.")
    if not warnings:
        warnings.append("Basic structural observations available. Manual validation is STILL REQUIRED.")

    return {
        "schema_version": "a01-c1-audit-v1",
        "generated_at_utc": datetime.now(timezone.utc).isoformat(),
        "source_file_basename": os.path.basename(bpy.data.filepath),
        "blender_version": bpy.app.version_string,
        "scene_name": bpy.context.scene.name,
        "unit_settings": {
            "system": bpy.context.scene.unit_settings.system,
            "scale_length": bpy.context.scene.unit_settings.scale_length,
        },
        "mesh_count": len(meshes),
        "armature_count": len(arms),
        "rigged_mesh_count": len(rigged),
        "meshes": meshes,
        "armatures": arms,
        "images": images,
        "warnings": warnings,
        "review_gates": {
            "C0_visual_reference": "owner-approved direction; 3D matching NOT verified",
            "C1_real_A01_geometry": "NEEDS_MANUAL_REVIEW",
            "C1_skin_deformation": "NOT_TESTED",
            "C2_licensed_coach_reference": "NOT_PROVIDED",
            "C3_coach_technique_validation": "NOT_APPROVED",
            "C4_training_media_release": "BLOCKED",
        },
        "meaning": "Structural inventory ONLY; no visual, anatomical or coaching certification.",
    }


def main():
    opts = options()
    report = build_report()
    path = os.path.abspath(opts.report)
    os.makedirs(os.path.dirname(path), exist_ok=True)
    with open(path, "w", encoding="utf-8") as handle:
        json.dump(report, handle, indent=2, ensure_ascii=False)
        handle.write("\n")
    print("A01 read-only audit written:", path)
    print("Meshes:", report["mesh_count"], "Armatures:", report["armature_count"],
          "Rigged meshes:", report["rigged_mesh_count"])
    for warning in report["warnings"]:
        print("C1 NOTICE:", warning)
    print("NO C1 / COACHING APPROVAL ISSUED.")


if __name__ == "__main__":
    main()
