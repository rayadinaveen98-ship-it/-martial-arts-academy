package com.martialartsacademy.app

/**
 * Pure Kotlin domain logic. No Android, Compose, camera, or network dependencies.
 * Quiz completion means concept understanding only, NEVER physical proficiency.
 */
data class SkillStep(
    val tag: String,
    val title: String,
    val concept: String,
    val reason: String
)
data class CommonError(val title: String, val why: String, val principle: String)
data class Question(
    val prompt: String,
    val answers: List<String>,
    val correct: Int,
    val explanation: String
)
data class SkillLesson(
    val id: String,
    val title: String,
    val subtitle: String,
    val steps: List<SkillStep>,
    val errors: List<CommonError>,
    val questions: List<Question>
)
data class LearnerProgress(
    val goal: String = "",
    val stance: String = "Unsure",
    val space: String = "Not sure",
    val visited: Map<String, Set<Int>> = emptyMap(),
    val completed: Set<String> = emptySet(),
    val notes: Map<String, String> = emptyMap(),
    val timerDemos: Int = 0
) {
    val onboarded: Boolean get() = goal.isNotBlank()
}

object BoxingCurriculum {
    val lessons: List<SkillLesson> = listOf(
        SkillLesson(
            id = "stance", title = "Stance & Guard",
            subtitle = "Balance, positioning and defensive awareness",
            steps = listOf(
                SkillStep("ORIENTATION", "Recognize the two sides",
                    "A boxing stance has a lead and a rear side. Stance labels describe orientation, not a verdict about what is best for your body.",
                    "Learn lead/rear language before assigning hand-specific movement."),
                SkillStep("BASE", "Understand the supporting base",
                    "A useful foundation keeps the lead and rear feet offset rather than on a single line.",
                    "This is a balance concept, not an instruction to force a measured foot position."),
                SkillStep("BALANCE", "Make room for movement",
                    "Relaxed readiness and controlled balance underpin movement. Precise joint placement needs a reviewed demonstration.",
                    "Balance comes before speed or strength."),
                SkillStep("GUARD", "Understand defensive coverage",
                    "The hands and elbows play protective roles while the learner maintains relaxed awareness.",
                    "Defensive coverage matters even when no punch is being thrown.")
            ),
            errors = listOf(
                CommonError("Feet narrowing or crossing",
                    "A narrowed or crossed base can undermine balance.",
                    "Understand the value of preserving a useful base."),
                CommonError("Forgetting the other hand",
                    "A learner may focus on one hand and overlook defensive coverage.",
                    "Think about both hands together."),
                CommonError("Confusing stiffness with strength",
                    "Excessive tension can make comfortable coordination harder.",
                    "Awareness and balance first; power is not the goal.")
            ),
            questions = listOf(
                Question("What is the main purpose of an offset, balanced boxing stance?",
                    listOf("To look wider", "To support balance and movement", "To guarantee punching power"), 1,
                    "The stance establishes a useful base for movement. Appearance and guaranteed power are not the goal."),
                Question("What is one role of the non-punching hand?",
                    listOf("Stay available for defensive coverage", "Swing back for momentum", "Hang by the waist"), 0,
                    "The other hand remains important for protection.")
            )
        ),
        SkillLesson(
            id = "footwork", title = "Foundational Footwork",
            subtitle = "Advance and retreat while preserving your base",
            steps = listOf(
                SkillStep("PURPOSE", "Footwork changes distance",
                    "Advancing and retreating change distance while preserving a balanced base.",
                    "Movement is not a race; control matters."),
                SkillStep("ADVANCE", "Study the advancing sequence",
                    "In the introductory advance pattern, the lead foot initiates and the rear foot follows.",
                    "The following foot helps restore a balanced base. A coach must verify the physical demonstration."),
                SkillStep("RETREAT", "Study the retreat sequence",
                    "In the introductory retreat pattern, the rear foot initiates and the lead foot follows.",
                    "Advance and retreat do not begin with the same foot."),
                SkillStep("CONTROL", "Recognize common problems",
                    "Crossing feet, overreaching and forgetting guard awareness can disrupt control.",
                    "Identify the risks before studying physical movement on verified media.")
            ),
            errors = listOf(
                CommonError("Feet coming together", "A narrow base reduces stability.", "Preserve the base."),
                CommonError("Overreaching a step", "Very large steps can reduce control.", "Controlled steps before distance."),
                CommonError("Losing guard awareness", "A learner can focus only on stepping.", "Movement and protection belong together.")
            ),
            questions = listOf(
                Question("In a basic advance pattern, which foot moves first?",
                    listOf("The rear foot", "The lead foot", "Both feet jump"), 1,
                    "The lead foot initiates the basic advance; the rear foot follows."),
                Question("Which foot initiates the basic retreat pattern?",
                    listOf("The lead foot", "The rear foot", "Either foot crossing"), 1,
                    "The rear foot initiates retreat and the lead foot follows.")
            )
        ),
        SkillLesson(
            id = "jab", title = "Lead-Hand Jab",
            subtitle = "Understand the lead hand and return to guard",
            steps = listOf(
                SkillStep("LEAD SIDE", "Identify the jab hand",
                    "A jab is a straight lead-hand punch; 'lead' is not always 'left'.",
                    "Orthodox and southpaw setups have different lead hands."),
                SkillStep("PURPOSE", "Understand the straight-punch idea",
                    "The introductory jab is a straight-line lead-hand concept, not an unreviewed impact tutorial.",
                    "The exact wrist and contact mechanics are withheld pending qualified coach review."),
                SkillStep("DEFENCE", "Remember the other hand",
                    "The non-punching hand still has a protective role.",
                    "Think about defence and the action together."),
                SkillStep("RECOVERY", "Return toward guard",
                    "A jab sequence includes an action and recovery toward the starting guard.",
                    "Recovery belongs to the concept; precise execution requires a validated demonstration.")
            ),
            errors = listOf(
                CommonError("Always calling the jab left-handed", "Lead side changes by stance orientation.", "Use lead/rear language."),
                CommonError("Ignoring the non-punching hand", "Defensive coverage remains important.", "Consider both hands."),
                CommonError("Leaving the hand extended", "Recovery is part of the introductory concept.", "Understand start, action and return.")
            ),
            questions = listOf(
                Question("Which hand performs a jab?",
                    listOf("Always the left", "The lead hand", "Always the rear hand"), 1,
                    "The jab uses the lead hand, which varies by stance."),
                Question("What belongs in the basic jab concept after extension?",
                    listOf("Staying extended", "Dropping both hands", "Recovery toward guard"), 2,
                    "A basic jab concept includes recovery to the guard.")
            )
        )
    )
    fun indexOf(id: String): Int = lessons.indexOfFirst { it.id == id }
}

object LearningRules {
    private fun lesson(id: String): SkillLesson = requireNotNull(BoxingCurriculum.lessons.find { it.id == id }) {
        "Unknown lesson ID: $id"
    }
    fun unlocked(progress: LearnerProgress, id: String): Boolean {
        val n = BoxingCurriculum.indexOf(id)
        if (n < 0) return false
        return n == 0 || BoxingCurriculum.lessons[n - 1].id in progress.completed
    }
    fun visitedCount(progress: LearnerProgress, id: String): Int =
        progress.visited[id].orEmpty().count { it in lesson(id).steps.indices }

    fun knowledgeCheckAvailable(progress: LearnerProgress, id: String): Boolean =
        unlocked(progress, id) &&
            (id in progress.completed || visitedCount(progress, id) == lesson(id).steps.size)

    fun visit(progress: LearnerProgress, id: String, step: Int): LearnerProgress {
        if (!unlocked(progress, id) || step !in lesson(id).steps.indices) return progress
        return progress.copy(visited = progress.visited +
            (id to (progress.visited[id].orEmpty() + step)))
    }
    fun updateNote(progress: LearnerProgress, id: String, text: String): LearnerProgress {
        lesson(id)
        if (!unlocked(progress, id)) return progress
        return progress.copy(notes = progress.notes + (id to text.take(600)))
    }
    fun completeKnowledgeCheck(progress: LearnerProgress, id: String, correctAnswers: Int): LearnerProgress {
        val required = lesson(id).questions.size
        if (!knowledgeCheckAvailable(progress, id) || correctAnswers != required) return progress
        return progress.copy(completed = progress.completed + id)
    }
    fun nextLesson(progress: LearnerProgress): SkillLesson =
        BoxingCurriculum.lessons.firstOrNull { it.id !in progress.completed } ?: BoxingCurriculum.lessons.last()

    fun afterTimerDemo(progress: LearnerProgress, fullyCompleted: Boolean): LearnerProgress =
        if (fullyCompleted) progress.copy(timerDemos = progress.timerDemos + 1) else progress
}
