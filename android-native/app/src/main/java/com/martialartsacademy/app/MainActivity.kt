package com.martialartsacademy.app

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.BackHandler
import androidx.activity.compose.setContent
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.LifecycleEventObserver
import androidx.lifecycle.compose.LocalLifecycleOwner
import kotlinx.coroutines.delay

private val Background = Color(0xFF090C17)
private val Panel = Color(0xFF151C2B)
private val Raised = Color(0xFF202A3B)
private val Crimson = Color(0xFFF52F4C)
private val Blue = Color(0xFF709EFF)
private val White = Color(0xFFF4F7FF)
private val Muted = Color(0xFFADBAD0)
private val Border = Color(0xFF3A4659)
private enum class Screen { HOME, SKILL, QUIZ, TIMER, JOURNEY, SETTINGS }
private enum class SkillTab { STUDY, ERRORS, MEDIA }

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent { AcademyNativeApp() }
    }
}

@Composable
private fun AcademyNativeApp() {
    val context = LocalContext.current
    val store = remember { AcademyStore(context.applicationContext) }
    var progress by remember { mutableStateOf(store.load()) }
    var screen by remember { mutableStateOf(Screen.HOME) }
    var currentLesson by remember { mutableStateOf("stance") }
    var step by remember { mutableIntStateOf(0) }
    var tab by remember { mutableStateOf(SkillTab.STUDY) }
    var error by remember { mutableIntStateOf(-1) }
    var explanation by remember { mutableStateOf(false) }
    var question by remember { mutableIntStateOf(0) }
    var chosen by remember { mutableIntStateOf(-1) }
    var timerDuration by remember { mutableIntStateOf(30) }
    var remaining by remember { mutableIntStateOf(30) }
    var round by remember { mutableIntStateOf(1) }
    var timerState by remember { mutableStateOf("ready") }
    var paused by remember { mutableStateOf(false) }

    fun save(newProgress: LearnerProgress) { progress = newProgress; store.save(newProgress) }
    fun openSkill(id: String) {
        if (!LearningRules.unlocked(progress, id)) return
        currentLesson = id
        step = 0
        tab = SkillTab.STUDY
        explanation = false
        error = -1
        save(LearningRules.visit(progress, id, 0))
        screen = Screen.SKILL
    }
    fun visit(n: Int) {
        val last = BoxingCurriculum.lessons.first { it.id == currentLesson }.steps.lastIndex
        step = n.coerceIn(0, last)
        explanation = false
        save(LearningRules.visit(progress, currentLesson, step))
    }
    val owner = LocalLifecycleOwner.current
    DisposableEffect(owner) {
        val listener = LifecycleEventObserver { _, event ->
            if (event == Lifecycle.Event.ON_STOP && timerState in listOf("work", "rest")) paused = true
        }
        owner.lifecycle.addObserver(listener)
        onDispose { owner.lifecycle.removeObserver(listener) }
    }
    LaunchedEffect(timerState, paused, remaining) {
        if (!paused && timerState in listOf("work", "rest")) {
            delay(1000L)
            when {
                remaining > 1 -> remaining--
                timerState == "work" && round == 1 -> { timerState = "rest"; remaining = 15 }
                timerState == "rest" -> { timerState = "work"; round = 2; remaining = timerDuration }
                else -> {
                    timerState = "complete"; remaining = 0
                    save(LearningRules.afterTimerDemo(progress, true))
                }
            }
        }
    }
    // Pauses the timer on in-app navigation as well as backgrounding.
    LaunchedEffect(screen) {
        if (screen != Screen.TIMER && timerState in listOf("work", "rest")) paused = true
    }
    BackHandler(progress.onboarded && screen != Screen.HOME) {
        screen = if (screen == Screen.QUIZ) Screen.SKILL else Screen.HOME
    }
    MaterialTheme(colorScheme = darkColorScheme(
        primary = Crimson, secondary = Blue, background = Background,
        surface = Panel, onBackground = White, onSurface = White
    )) {
        Surface(Modifier.fillMaxSize(), color = Background) {
            if (!progress.onboarded) {
                Onboarding { goal, stance, space ->
                    save(progress.copy(goal = goal, stance = stance, space = space))
                    screen = Screen.HOME
                }
            } else {
                Scaffold(containerColor = Background,
                    topBar = {
                        Row(Modifier.fillMaxWidth().background(Background)
                            .padding(horizontal = 18.dp, vertical = 14.dp),
                            verticalAlignment = Alignment.CenterVertically) {
                            Text("A", color = Crimson, fontSize = 34.sp, fontWeight = FontWeight.Black)
                            Spacer(Modifier.width(13.dp))
                            Column(Modifier.weight(1f)) {
                                Text("MARTIAL ARTS", color = White, fontWeight = FontWeight.Black,
                                    fontSize = 13.sp, letterSpacing = 2.sp)
                                Text("A C A D E M Y", color = Muted, fontSize = 10.sp, letterSpacing = 2.sp)
                            }
                            TextButton(onClick = { screen = Screen.SETTINGS }) {
                                Text("PROFILE", color = Muted, fontSize = 11.sp)
                            }
                        }
                    },
                    bottomBar = {
                        Row(Modifier.fillMaxWidth().background(Panel).navigationBarsPadding()
                            .padding(vertical = 7.dp), horizontalArrangement = Arrangement.SpaceEvenly) {
                            listOf(Screen.HOME to "HOME", Screen.SKILL to "LEARN",
                                Screen.TIMER to "TIMER", Screen.JOURNEY to "JOURNEY").forEach { pair ->
                                val selected = screen == pair.first ||
                                    (pair.first == Screen.SKILL && screen == Screen.QUIZ)
                                TextButton(onClick = {
                                    if (pair.first == Screen.SKILL) openSkill(LearningRules.nextLesson(progress).id)
                                    else screen = pair.first
                                }) {
                                    Text(pair.second, fontSize = 10.sp,
                                        fontWeight = if (selected) FontWeight.Black else FontWeight.Medium,
                                        color = if (selected) Crimson else Muted)
                                }
                            }
                        }
                    }) { inset ->
                    val pageModifier = Modifier.fillMaxSize().padding(inset).verticalScroll(rememberScrollState())
                        .padding(horizontal = 18.dp, vertical = 10.dp)
                    when (screen) {
                        Screen.HOME -> Home(pageModifier, progress, ::openSkill)
                        Screen.SKILL -> {
                            val lesson = BoxingCurriculum.lessons.first { it.id == currentLesson }
                            Skill(pageModifier, lesson, progress, step, tab, error, explanation,
                                onTab = { tab = it },
                                onStep = ::visit,
                                onError = { error = if (error == it) -1 else it },
                                onExplanation = { explanation = !explanation },
                                onNote = { save(LearningRules.updateNote(progress, currentLesson, it)) },
                                onQuiz = {
                                    if (LearningRules.knowledgeCheckAvailable(progress, currentLesson)) {
                                        question = 0; chosen = -1; screen = Screen.QUIZ
                                    }
                                },
                                onBack = { screen = Screen.HOME })
                        }
                        Screen.QUIZ -> {
                            val lesson = BoxingCurriculum.lessons.first { it.id == currentLesson }
                            Quiz(pageModifier, lesson, question, chosen,
                                select = { if (chosen == -1) chosen = it },
                                next = {
                                    val q = lesson.questions[question]
                                    if (chosen == q.correct) {
                                        if (question < lesson.questions.lastIndex) {
                                            question++; chosen = -1
                                        } else {
                                            save(LearningRules.completeKnowledgeCheck(progress,
                                                currentLesson, lesson.questions.size))
                                            screen = Screen.JOURNEY
                                        }
                                    } else chosen = -1
                                }, back = { screen = Screen.SKILL })
                        }
                        Screen.TIMER -> Timer(pageModifier, timerDuration, timerState, remaining, round, paused,
                            setDuration = { if (timerState == "ready") { timerDuration = it; remaining = it } },
                            start = { round = 1; remaining = timerDuration; timerState = "work"; paused = false },
                            togglePause = { paused = !paused },
                            end = { timerState = "ready"; round = 1; remaining = timerDuration; paused = false })
                        Screen.JOURNEY -> Journey(pageModifier, progress, ::openSkill)
                        Screen.SETTINGS -> Profile(pageModifier, progress, ::save)
                    }
                }
            }
        }
    }
}

@Composable
private fun Heading(label: String, title: String, description: String? = null) {
    Text(label, color = Crimson, fontWeight = FontWeight.Bold, fontSize = 11.sp, letterSpacing = 1.3.sp)
    Spacer(Modifier.height(7.dp))
    Text(title, color = White, fontWeight = FontWeight.Black, fontSize = 29.sp, lineHeight = 34.sp)
    if (description != null) {
        Spacer(Modifier.height(8.dp))
        Text(description, color = Muted, fontSize = 14.sp, lineHeight = 21.sp)
    }
}

@Composable
private fun Frame(modifier: Modifier = Modifier, content: @Composable ColumnScope.() -> Unit) {
    Card(modifier.fillMaxWidth(), shape = RoundedCornerShape(20.dp),
        colors = CardDefaults.cardColors(containerColor = Panel),
        border = BorderStroke(1.dp, Border)) {
        Column(Modifier.padding(18.dp), content = content)
    }
}

@Composable
private fun Primary(title: String, enabled: Boolean = true, onClick: () -> Unit) {
    Button(onClick = onClick, enabled = enabled, modifier = Modifier.fillMaxWidth().heightIn(min = 52.dp),
        shape = RoundedCornerShape(13.dp),
        colors = ButtonDefaults.buttonColors(containerColor = Crimson)) {
        Text(title, fontSize = 13.sp, fontWeight = FontWeight.Bold)
    }
}

@Composable
private fun Choose(label: String, options: List<String>, value: String, onChange: (String) -> Unit) {
    Text(label, color = Muted, fontSize = 11.sp, fontWeight = FontWeight.Bold)
    options.forEach { option ->
        val active = option == value
        Surface(Modifier.fillMaxWidth().clickable { onChange(option) }, shape = RoundedCornerShape(12.dp),
            color = if (active) Crimson.copy(alpha = 0.18f) else Panel,
            border = BorderStroke(1.dp, if (active) Crimson else Border)) {
            Text(option, Modifier.padding(13.dp), color = White, fontSize = 14.sp)
        }
    }
}

@Composable
private fun Onboarding(finish: (String, String, String) -> Unit) {
    var goal by remember { mutableStateOf("Learn the basics") }
    var stance by remember { mutableStateOf("Unsure") }
    var space by remember { mutableStateOf("Not sure") }
    Column(Modifier.fillMaxSize().verticalScroll(rememberScrollState()).padding(22.dp),
        verticalArrangement = Arrangement.spacedBy(13.dp)) {
        Spacer(Modifier.height(27.dp))
        Heading("WELCOME TO THE ACADEMY", "YOUR JOURNEY STARTS HERE",
            "Three connected beginner boxing concepts. Verified physical coaching is not available yet.")
        Choose("YOUR GOAL", listOf("Learn the basics", "Build coordination", "Gentle activity"), goal) { goal = it }
        Choose("STANCE ORIENTATION", listOf("Unsure", "Orthodox", "Southpaw"), stance) { stance = it }
        Text("Stance selection is descriptive, not a technical recommendation.", color = Muted, fontSize = 12.sp)
        Choose("AVAILABLE SPACE", listOf("Clear open space", "Limited space", "Not sure"), space) { space = it }
        Primary("ENTER THE ACADEMY") { finish(goal, stance, space) }
    }
}

@Composable
private fun Home(modifier: Modifier, progress: LearnerProgress, open: (String) -> Unit) {
    val next = LearningRules.nextLesson(progress)
    Column(modifier, verticalArrangement = Arrangement.spacedBy(14.dp)) {
        Heading("YOUR LEARNING JOURNEY", "BOXING FOUNDATIONS",
            "Learn the concepts first. A01 training poses remain blocked until coach-reviewed.")
        Box(Modifier.fillMaxWidth().height(180.dp).background(
            Brush.linearGradient(listOf(Color(0xFF63203A), Color(0xFF1F2B40), Background)),
            RoundedCornerShape(24.dp))) {
            Column(Modifier.align(Alignment.BottomStart).padding(20.dp)) {
                Text("FOUNDATION 0" + (BoxingCurriculum.indexOf(next.id) + 1),
                    color = Color(0xFFFFA8B7), fontSize = 11.sp, letterSpacing = 2.sp)
                Text(next.title.uppercase(), color = White, fontSize = 25.sp, fontWeight = FontWeight.Black)
                Text("CONCEPT STUDY • NO UNVERIFIED POSES", color = Muted, fontSize = 10.sp)
            }
        }
        Primary("CONTINUE LEARNING") { open(next.id) }
        Text("YOUR PATH", color = White, fontWeight = FontWeight.Bold, letterSpacing = 1.sp)
        BoxingCurriculum.lessons.forEachIndexed { i, lesson ->
            val unlocked = LearningRules.unlocked(progress, lesson.id)
            Frame(Modifier.clickable(enabled = unlocked) { open(lesson.id) }) {
                Row(verticalAlignment = Alignment.CenterVertically) {
                    Text("0" + (i + 1), color = Crimson, fontSize = 25.sp, fontWeight = FontWeight.Black)
                    Spacer(Modifier.width(13.dp))
                    Column(Modifier.weight(1f)) {
                        Text(lesson.title, color = White, fontWeight = FontWeight.Bold)
                        Text(when {
                            lesson.id in progress.completed -> "UNDERSTANDING CHECK COMPLETE"
                            !unlocked -> "LOCKED • PREVIOUS CHECK REQUIRED"
                            else -> LearningRules.visitedCount(progress, lesson.id).toString() + "/4 CONCEPTS EXPLORED"
                        }, color = Muted, fontSize = 11.sp)
                    }
                    Text(if (unlocked) "›" else "·", fontSize = 25.sp, color = Crimson)
                }
            }
        }
        Spacer(Modifier.height(18.dp))
    }
}

@Composable
private fun Skill(modifier: Modifier, lesson: SkillLesson, progress: LearnerProgress,
    step: Int, tab: SkillTab, expandedError: Int, explanation: Boolean,
    onTab: (SkillTab) -> Unit, onStep: (Int) -> Unit,
    onError: (Int) -> Unit, onExplanation: () -> Unit,
    onNote: (String) -> Unit, onQuiz: () -> Unit, onBack: () -> Unit) {
    val visited = LearningRules.visitedCount(progress, lesson.id)
    val current = lesson.steps[step]
    val ready = LearningRules.knowledgeCheckAvailable(progress, lesson.id)
    Column(modifier, verticalArrangement = Arrangement.spacedBy(13.dp)) {
        TextButton(onClick = onBack) { Text("‹ BACK TO HOME", color = Muted) }
        Heading("SKILL STUDIO / BOXING FOUNDATIONS", lesson.title.uppercase(), lesson.subtitle)
        Frame {
            Text("INSTRUCTOR A01 · VISUAL CONCEPT ONLY", color = Blue, fontSize = 11.sp)
            Spacer(Modifier.height(8.dp))
            Box(Modifier.fillMaxWidth().height(140.dp).background(
                Brush.linearGradient(listOf(Raised, Color(0xFF381929), Panel)),
                RoundedCornerShape(14.dp)), contentAlignment = Alignment.Center) {
                Column(horizontalAlignment = Alignment.CenterHorizontally) {
                    Text("A01", color = Crimson, fontSize = 48.sp, fontWeight = FontWeight.Black)
                    Text("NO VERIFIED TRAINER MOTION", color = White, fontSize = 11.sp)
                }
            }
            Text("The character and teaching media are still awaiting technical review.",
                Modifier.padding(top = 9.dp), color = Muted, fontSize = 12.sp)
        }
        Row(horizontalArrangement = Arrangement.spacedBy(7.dp)) {
            SkillTab.entries.forEach { option ->
                val active = option == tab
                Surface(Modifier.weight(1f).clickable { onTab(option) }, shape = RoundedCornerShape(11.dp),
                    color = if (active) Crimson else Panel,
                    border = BorderStroke(1.dp, if (active) Crimson else Border)) {
                    Text(option.name, Modifier.padding(vertical = 12.dp), color = if (active) White else Muted,
                        textAlign = TextAlign.Center, fontWeight = FontWeight.Bold, fontSize = 11.sp)
                }
            }
        }
        when (tab) {
            SkillTab.STUDY -> {
                Frame {
                    Text("INTERACTIVE CONCEPT STUDY · " + visited + "/4 VISITED",
                        color = Blue, fontSize = 11.sp, fontWeight = FontWeight.Bold)
                    Spacer(Modifier.height(12.dp))
                    Row(horizontalArrangement = Arrangement.spacedBy(7.dp)) {
                        lesson.steps.forEachIndexed { index, _ ->
                            Surface(Modifier.weight(1f).height(46.dp).clickable { onStep(index) },
                                color = if (index == step) Crimson else Raised,
                                shape = RoundedCornerShape(10.dp)) {
                                Box(contentAlignment = Alignment.Center) {
                                    Text((index + 1).toString(), color = White, fontWeight = FontWeight.Bold)
                                }
                            }
                        }
                    }
                    Spacer(Modifier.height(16.dp))
                    Text(current.tag, color = Crimson, fontSize = 11.sp, fontWeight = FontWeight.Bold)
                    Text(current.title, color = White, fontWeight = FontWeight.Black, fontSize = 22.sp)
                    Text(current.concept, Modifier.padding(vertical = 12.dp), color = White, lineHeight = 22.sp)
                    OutlinedButton(onClick = onExplanation, modifier = Modifier.fillMaxWidth(),
                        border = BorderStroke(1.dp, Border)) {
                        Text(if (explanation) "HIDE EXPLANATION" else "WHY THIS MATTERS", color = Blue)
                    }
                    if (explanation) {
                        Text(current.reason, Modifier.padding(vertical = 9.dp), color = Muted)
                    }
                    Row(horizontalArrangement = Arrangement.spacedBy(8.dp)) {
                        OutlinedButton(onClick = { onStep(step - 1) }, enabled = step > 0,
                            modifier = Modifier.weight(1f)) { Text("PREVIOUS", fontSize = 11.sp) }
                        Button(onClick = { onStep(step + 1) }, enabled = step < lesson.steps.lastIndex,
                            modifier = Modifier.weight(1f)) { Text("NEXT STEP", fontSize = 11.sp) }
                    }
                }
                Frame {
                    Text("YOUR LEARNING NOTE", color = Muted, fontSize = 11.sp)
                    OutlinedTextField(value = progress.notes[lesson.id].orEmpty(), onValueChange = onNote,
                        modifier = Modifier.fillMaxWidth(), minLines = 2, maxLines = 4,
                        label = { Text("A question to revisit") })
                    Text("Saved locally • 600-character limit", color = Muted, fontSize = 11.sp)
                }
                Primary(if (ready) "START KNOWLEDGE CHECK" else "EXPLORE ALL FOUR CONCEPT STEPS",
                    enabled = ready, onClick = onQuiz)
            }
            SkillTab.ERRORS -> lesson.errors.forEachIndexed { i, item ->
                Frame(Modifier.clickable { onError(i) }) {
                    Text(item.title, color = White, fontWeight = FontWeight.Bold)
                    Text(item.why, Modifier.padding(top = 7.dp), color = Muted)
                    if (expandedError == i) {
                        HorizontalDivider(Modifier.padding(vertical = 10.dp), color = Border)
                        Text("LEARNING PRINCIPLE", color = Crimson, fontSize = 11.sp)
                        Text(item.principle, Modifier.padding(top = 6.dp), color = White)
                    }
                }
            }
            SkillTab.MEDIA -> Frame {
                Text("INSTRUCTIONAL MEDIA NOT RELEASED", color = Crimson, fontWeight = FontWeight.Bold)
                Text("The A01 rig and physical poses are not coach-verified. No fake angles or automated technique scores are available.",
                    Modifier.padding(top = 10.dp), color = White, lineHeight = 22.sp)
                Text("Required: model → rig QA → licensed instructor reference → qualified boxing-coach review.",
                    Modifier.padding(top = 9.dp), color = Muted)
            }
        }
        Spacer(Modifier.height(18.dp))
    }
}

@Composable
private fun Quiz(modifier: Modifier, lesson: SkillLesson, index: Int, chosen: Int,
    select: (Int) -> Unit, next: () -> Unit, back: () -> Unit) {
    val item = lesson.questions[index]
    Column(modifier, verticalArrangement = Arrangement.spacedBy(15.dp)) {
        TextButton(onClick = back) { Text("‹ BACK TO LESSON", color = Muted) }
        Heading("KNOWLEDGE CHECK", (index + 1).toString() + " / " + lesson.questions.size, lesson.title)
        Frame {
            Text(item.prompt, color = White, fontWeight = FontWeight.Bold,
                fontSize = 22.sp, lineHeight = 29.sp)
            Spacer(Modifier.height(12.dp))
            item.answers.forEachIndexed { n, answer ->
                Surface(Modifier.fillMaxWidth().padding(vertical = 4.dp).clickable { select(n) },
                    color = if (chosen == n) Crimson.copy(alpha = 0.20f) else Raised,
                    shape = RoundedCornerShape(11.dp),
                    border = BorderStroke(1.dp, if (chosen == n) Crimson else Border)) {
                    Text(answer, Modifier.padding(14.dp), color = White)
                }
            }
            if (chosen >= 0) {
                Text(if (chosen == item.correct) "CORRECT UNDERSTANDING" else "REVISIT THE CONCEPT",
                    Modifier.padding(top = 14.dp),
                    color = if (chosen == item.correct) Blue else Crimson, fontWeight = FontWeight.Bold)
                Text(item.explanation, Modifier.padding(top = 6.dp), color = Muted)
            }
        }
        if (chosen >= 0) Primary(if (chosen == item.correct) "CONTINUE" else "TRY AGAIN", onClick = next)
        Text("Concept knowledge is not a coach-certified physical skill.",
            color = Muted, fontSize = 12.sp)
    }
}

@Composable
private fun Timer(modifier: Modifier, duration: Int, state: String, remaining: Int,
    round: Int, paused: Boolean,
    setDuration: (Int) -> Unit, start: () -> Unit, togglePause: () -> Unit, end: () -> Unit) {
    Column(modifier, verticalArrangement = Arrangement.spacedBy(16.dp)) {
        Heading("TRAINING INTERFACE", "TIMER DEMO",
            "A functioning interaction test; not a recommended boxing workout or physical assessment.")
        Frame {
            Text("DEMO ROUND DURATION", color = Muted, fontSize = 11.sp)
            Row(horizontalArrangement = Arrangement.spacedBy(7.dp)) {
                listOf(30, 45, 60).forEach { n ->
                    OutlinedButton(onClick = { setDuration(n) }, enabled = state == "ready",
                        modifier = Modifier.weight(1f),
                        border = BorderStroke(1.dp, if (n == duration) Crimson else Border)) {
                        Text(n.toString() + "s", fontSize = 11.sp)
                    }
                }
            }
            Text(when (state) {
                "ready" -> "READY"
                "rest" -> "REST / 15 SECONDS"
                "complete" -> "DEMO COMPLETE"
                else -> "ROUND " + round + " / 2"
            }, Modifier.fillMaxWidth().padding(top = 18.dp), color = Crimson,
                textAlign = TextAlign.Center, fontWeight = FontWeight.Bold)
            Text("%02d:%02d".format(remaining / 60, remaining % 60),
                Modifier.fillMaxWidth(), fontSize = 60.sp, textAlign = TextAlign.Center,
                fontWeight = FontWeight.Black, color = White)
            if (paused) Text("PAUSED • TIME NOT COUNTED", Modifier.fillMaxWidth(),
                textAlign = TextAlign.Center, color = Blue)
            Spacer(Modifier.height(12.dp))
            when (state) {
                "ready" -> Primary("START DEMO", onClick = start)
                "complete" -> Primary("RESET DEMO", onClick = end)
                else -> {
                    Primary(if (paused) "RESUME" else "PAUSE", onClick = togglePause)
                    OutlinedButton(onClick = end, modifier = Modifier.fillMaxWidth()) {
                        Text("END WITHOUT COMPLETION CREDIT", color = Muted)
                    }
                }
            }
        }
        Text("The timer pauses when the app is backgrounded.", color = Muted, fontSize = 12.sp)
    }
}

@Composable
private fun Journey(modifier: Modifier, progress: LearnerProgress, open: (String) -> Unit) {
    Column(modifier, verticalArrangement = Arrangement.spacedBy(14.dp)) {
        Heading("PERSONAL LEARNING RECORD", "YOUR JOURNEY",
            "Comprehension and timer demos are not physical skill certifications.")
        Frame {
            Text(progress.completed.size.toString() + " / 3", color = Crimson,
                fontSize = 40.sp, fontWeight = FontWeight.Black)
            Text("CONCEPT KNOWLEDGE CHECKS COMPLETE", color = Muted, fontSize = 11.sp)
            Text("Timer UI demos completed: " + progress.timerDemos,
                Modifier.padding(top = 8.dp), color = White)
        }
        BoxingCurriculum.lessons.forEach { lesson ->
            val enabled = LearningRules.unlocked(progress, lesson.id)
            Frame(Modifier.clickable(enabled = enabled) { open(lesson.id) }) {
                Text(lesson.title, color = White, fontWeight = FontWeight.Bold)
                Text(when {
                    lesson.id in progress.completed -> "Understanding check complete"
                    !enabled -> "Previous concept check required"
                    else -> LearningRules.visitedCount(progress, lesson.id).toString() + " of 4 concepts explored"
                }, color = Muted)
                progress.notes[lesson.id]?.takeIf { it.isNotBlank() }?.let {
                    Text("YOUR NOTE: " + it, Modifier.padding(top = 8.dp), color = Blue)
                }
            }
        }
    }
}

@Composable
private fun Profile(modifier: Modifier, progress: LearnerProgress, save: (LearnerProgress) -> Unit) {
    Column(modifier, verticalArrangement = Arrangement.spacedBy(12.dp)) {
        Heading("PERSONALIZATION", "YOUR PROFILE")
        Choose("GOAL", listOf("Learn the basics", "Build coordination", "Gentle activity"),
            progress.goal) { save(progress.copy(goal = it)) }
        Choose("STANCE", listOf("Unsure", "Orthodox", "Southpaw"),
            progress.stance) { save(progress.copy(stance = it)) }
        Choose("SPACE", listOf("Clear open space", "Limited space", "Not sure"),
            progress.space) { save(progress.copy(space = it)) }
        Text("Offline-first · no account, camera, or external data.",
            color = Muted, fontSize = 12.sp)
    }
}
