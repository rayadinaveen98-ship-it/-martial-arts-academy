# 07 — Meaningful interaction architecture and QA

**Status:** Pre-production contract, not implemented (2026-11-10).

## Product loop
`Understand -> Notice -> Choose -> Rehearse optionally -> Reflect -> Return`.
Reward clear understanding, consistency and willingness to learn, never fabricated fighting skill.

## State definitions
| State | Meaning |
|---|---|
| `unseen` | Content not opened |
| `exploring` | Lesson content opened / partially reviewed |
| `understood` | Concept questions passed (not physical proficiency) |
| `practiced_self_report` | User logged a voluntary no-contact session |
| `review_requested` | User wants a repeat/refresher |
| `verified_by_coach` | **Reserved; not available in v0.1** |

**Unlock rule:** subsequent conceptual lesson unlocks on completion of preceding concept check; self-report does not gate educational access. Any practice-only activity remains blocked unless media and content are reviewed.

## Onboarding branches
- Experience: first-timer / returning / experienced. First prototype prioritizes first-timer UX; others provide informational onboarding rather than invented advanced plans.
- Stance: orthodox / southpaw / unsure. Unsure users receive neutral explanation; no claim handedness definitively determines stance.
- Goal: basics / coordination / gentle activity. Use to tailor *copy* and recommended next lesson only.
- Space: clear adequate space / limited / uncertain. Limited/uncertain prevents guided motion drills, but allows lessons and comprehension checks.
- Readiness: comfortable / not today / need to stop. 'Not today' still allows concept study; no guilt/streak punishment.

## One meaningful interaction per screen
- **Home:** 'Continue lesson' opens the exact pending step; visible 'why this next?' explains prerequisites.
- **Lesson:** Angle change only if angle asset exists; tapping key points reveals annotations tied to actual media frames; playback speed reflects loaded validated media.
- **Check:** answer -> accurate explanation -> retry or proceed. Wrong answers never shame user.
- **Practice:** safety prompt -> warm-up -> optional easy-paced drill -> rest/pause/stop -> reflection.
- **Progress:** report concept completion and self-logged activity separately.

## Practice timer state machine (proposed)
`ready -> warming_up -> practice_active <-> paused -> rest -> practice_active -> reflection -> completed`
- `stopped` is terminal and distinct from `completed`.
- On app going to background, timer pauses unless deliberately designed and tested otherwise; don't silently count practice.
- User can skip or stop at any time.
- No aggressive countdown tones, automatic intensity ramps or unsafe maximal-effort prompts.
- Duration defaults and cue wording require coach/safety review, especially for inactive adults.
- Consider reduced motion, vibration/audio on/off, VoiceOver/TalkBack and foreground readability.

## Key interaction acceptance tests
| ID | Test | Expected |
|---|---|---|
| T01 | Open app first time | Appropriate onboarding; no dead CTA |
| T02 | Select southpaw | Labels, content, checked media match *right-hand lead*; no mirrored ambiguity |
| T03 | Select 'unsure' | Clear explanation, non-blocking selection |
| T04 | Choose limited space | Movement practice disabled with explanation; concept study available |
| T05 | Wrong quiz answer | Meaningful explanatory feedback; repeat permitted |
| T06 | Correct concept questions | Next educational lesson available; no technical-mastery badge |
| T07 | Pause/resume timer | No time accrued while paused |
| T08 | Stop mid-session | Not recorded as completed; reflection optional |
| T09 | App/process restart | Return to correct persisted state; no phantom completion |
| T10 | Switch lesson and back | Restore media/navigation position predictably |
| T11 | No approved media exists | Clearly marked concept-only content; no misleading instructional animation |
| T12 | Change stance | Existing reviewed instructional assets checked for compatible orientation; no silent visual mirroring |
| T13 | Small-screen accessibility | No clipped actions, legible cues, sensible touch targets |
| T14 | User marks 'not today' | Learning without physical drills remains possible |
| T15 | Review progress | Counts comprehension and self-reported practice truthfully |

## Proposed prototype metrics (for usability only)
- New-user activation: completes onboarding and reaches one purposeful learning interaction.
- Learning completion: finishes BOX-001 concept check.
- Resumption: returns to next incomplete lesson after app restart.
- Perceived clarity: user can explain the difference between conceptual knowledge and coach-certified skill.
- Technique safety: **zero** unreviewed visuals presented as verified technique.

## Out of scope
- Camera pose scoring, location or social accounts, wearables, badges claiming physical proficiency, push notification campaigns, subscriptions.
