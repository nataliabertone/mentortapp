// Matchmaking.kt
package com.example.challengementortapp.utils

import com.example.challengementortapp.models.Mentor
import com.example.challengementortapp.models.Aprendiz

data class Match(val mentor: Mentor, val aprendiz: Aprendiz, val score: Int)

fun findMatches(mentors: List<Mentor>, aprendizes: List<Aprendiz>): List<Match> {
    val matches = mutableListOf<Match>()

    for (mentor in mentors) {
        for (aprendiz in aprendizes) {
            val score = calculateMatchScore(mentor, aprendiz)
            if (score > 0) {
                matches.add(Match(mentor, aprendiz, score))
            }
        }
    }
    return matches.sortedByDescending { it.score }
}

fun calculateMatchScore(mentor: Mentor, aprendiz: Aprendiz): Int {
    val commonSkills = mentor.user.skills.intersect(aprendiz.user.skills).size
    val commonInterests = mentor.user.interests.intersect(aprendiz.user.interests).size
    return commonSkills + commonInterests
}

