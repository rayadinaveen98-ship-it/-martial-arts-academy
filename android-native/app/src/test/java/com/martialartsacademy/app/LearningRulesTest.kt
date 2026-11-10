package com.martialartsacademy.app

import org.junit.Assert.*
import org.junit.Test

class LearningRulesTest {
    @Test fun scopeIsExactlyThreePrerequisiteLinkedBoxingConcepts() {
        assertEquals(listOf("stance", "footwork", "jab"), BoxingCurriculum.lessons.map { it.id })
        assertTrue(BoxingCurriculum.lessons.all { it.steps.size == 4 && it.questions.size == 2 })
        assertTrue(BoxingCurriculum.lessons.all { it.errors.size == 3 })
    }

    @Test fun initialStateUnlocksOnlyStanceAndQuizIsNotAvailable() {
        val p = LearnerProgress(goal = "Learn the basics")
        assertTrue(LearningRules.unlocked(p, "stance"))
        assertFalse(LearningRules.unlocked(p, "footwork"))
        assertFalse(LearningRules.unlocked(p, "jab"))
        assertFalse(LearningRules.knowledgeCheckAvailable(p, "stance"))
        assertFalse(LearningRules.unlocked(p, "unlisted"))
    }

    @Test fun exactlyFourStepsUnlockKnowledgeCheckNotPhysicalMastery() {
        var p = LearnerProgress(goal = "Learn the basics")
        p = LearningRules.visit(p, "stance", 0)
        p = LearningRules.visit(p, "stance", 0)
        assertEquals(1, LearningRules.visitedCount(p, "stance"))
        p = LearningRules.visit(p, "stance", 100)
        assertEquals(1, LearningRules.visitedCount(p, "stance"))
        assertFalse(LearningRules.knowledgeCheckAvailable(p, "stance"))
        for (index in 1..3) p = LearningRules.visit(p, "stance", index)
        assertEquals(4, LearningRules.visitedCount(p, "stance"))
        assertTrue(LearningRules.knowledgeCheckAvailable(p, "stance"))
        assertTrue(p.completed.isEmpty())
        assertFalse(LearningRules.unlocked(p, "footwork"))
    }

    @Test fun knowledgeCheckOnlyUnlocksNextAfterAllAnswersCorrect() {
        var p = LearnerProgress(goal = "Learn the basics")
        p = LearningRules.completeKnowledgeCheck(p, "stance", 2)
        assertFalse("Cannot bypass study", "stance" in p.completed)
        (0..3).forEach { p = LearningRules.visit(p, "stance", it) }
        p = LearningRules.completeKnowledgeCheck(p, "stance", 1)
        assertFalse("No partial-credit unlock", "stance" in p.completed)
        p = LearningRules.completeKnowledgeCheck(p, "stance", 2)
        assertTrue("stance" in p.completed)
        assertTrue(LearningRules.unlocked(p, "footwork"))
        assertFalse(LearningRules.unlocked(p, "jab"))
        assertEquals("footwork", LearningRules.nextLesson(p).id)
    }

    @Test fun lockedLessonCannotHaveFakeProgress() {
        val p = LearnerProgress(goal = "Learn the basics")
        val changed = LearningRules.visit(p, "jab", 3)
        assertSame(p, changed)
        assertEquals(0, LearningRules.visitedCount(changed, "jab"))
    }

    @Test fun noteIsSavedAsPlainTextAndClampedTo600Characters() {
        val p = LearnerProgress(goal = "Learn the basics")
        val raw = "<script>alert('unsafe')</script>".repeat(40)
        val changed = LearningRules.updateNote(p, "stance", raw)
        assertEquals(raw.take(600), changed.notes["stance"])
        assertEquals(600, changed.notes["stance"]!!.length)
        assertTrue(changed.completed.isEmpty())
    }

    @Test fun stoppingTimerDoesNotCreateFakeSessionCompletion() {
        val p = LearnerProgress(goal = "Learn the basics")
        assertEquals(0, LearningRules.afterTimerDemo(p, false).timerDemos)
        assertEquals(1, LearningRules.afterTimerDemo(p, true).timerDemos)
        assertTrue(p.completed.isEmpty())
    }

    @Test fun finishingAllConceptsDoesNotClaimTechnicalProficiency() {
        var p = LearnerProgress(goal = "Learn the basics")
        BoxingCurriculum.lessons.forEach { lesson ->
            lesson.steps.indices.forEach { step ->
                p = LearningRules.visit(p, lesson.id, step)
            }
            p = LearningRules.completeKnowledgeCheck(p, lesson.id, lesson.questions.size)
        }
        assertEquals(3, p.completed.size)
        assertEquals("jab", LearningRules.nextLesson(p).id)
        // No field representing boxing mastery, strike accuracy, form scores or coach certification exists.
        assertTrue(p.timerDemos == 0)
    }
}
