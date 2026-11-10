package com.martialartsacademy.app

import android.content.Context
import org.json.JSONArray
import org.json.JSONObject

/** Local-only persistence. Distinct from website localStorage; no accounts or network. */
class AcademyStore(context: Context) {
    private val prefs = context.getSharedPreferences("academy_native_v1", Context.MODE_PRIVATE)
    private val key = "learner_progress"

    fun load(): LearnerProgress {
        val raw = prefs.getString(key, null) ?: return LearnerProgress()
        return try {
            val json = JSONObject(raw)
            val savedVisited = mutableMapOf<String, Set<Int>>()
            val v = json.optJSONObject("visited") ?: JSONObject()
            val vKeys = v.keys()
            while (vKeys.hasNext()) {
                val id = vKeys.next()
                val values = v.optJSONArray(id) ?: JSONArray()
                val set = buildSet {
                    for (i in 0 until values.length()) add(values.optInt(i, -1))
                }.filter { it >= 0 }.toSet()
                savedVisited[id] = set
            }
            val done = mutableSetOf<String>()
            val arr = json.optJSONArray("completed") ?: JSONArray()
            for (i in 0 until arr.length()) arr.optString(i).takeIf { it.isNotEmpty() }?.let(done::add)
            val notes = mutableMapOf<String, String>()
            val storedNotes = json.optJSONObject("notes") ?: JSONObject()
            val noteKeys = storedNotes.keys()
            while (noteKeys.hasNext()) {
                val id = noteKeys.next()
                notes[id] = storedNotes.optString(id).take(600)
            }
            val validIds = BoxingCurriculum.lessons.map { it.id }.toSet()
            LearnerProgress(
                goal = json.optString("goal"),
                stance = json.optString("stance", "Unsure"),
                space = json.optString("space", "Not sure"),
                visited = savedVisited.filterKeys { it in validIds },
                completed = done.intersect(validIds),
                notes = notes.filterKeys { it in validIds },
                timerDemos = json.optInt("timerDemos", 0).coerceAtLeast(0)
            )
        } catch (_: Exception) { LearnerProgress() }
    }

    fun save(p: LearnerProgress) {
        val visited = JSONObject()
        p.visited.forEach { (id, steps) ->
            visited.put(id, JSONArray().apply { steps.sorted().forEach { put(it) } })
        }
        val notes = JSONObject()
        p.notes.forEach { (id, note) -> notes.put(id, note.take(600)) }
        val json = JSONObject()
            .put("goal", p.goal)
            .put("stance", p.stance)
            .put("space", p.space)
            .put("visited", visited)
            .put("completed", JSONArray().apply { p.completed.sorted().forEach { put(it) } })
            .put("notes", notes)
            .put("timerDemos", p.timerDemos)
        prefs.edit().putString(key, json.toString()).apply()
    }
}
