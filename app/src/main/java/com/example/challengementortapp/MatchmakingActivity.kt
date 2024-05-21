// MatchmakingActivity.kt
package com.example.challengementortapp

import android.os.Bundle
import android.widget.ArrayAdapter
import android.widget.ListView
import androidx.appcompat.app.AppCompatActivity
import com.example.challengementortapp.models.Aprendiz
import com.example.challengementortapp.models.Mentor
import com.example.challengementortapp.models.User
import com.example.challengementortapp.utils.findMatches

class MatchmakingActivity : AppCompatActivity() {

    private lateinit var matchListView: ListView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_matchmaking)

        matchListView = findViewById(R.id.matchListView)

        val mentors = loadMentors()
        val aprendizes = loadAprendizes()

        val matches = findMatches(mentors, aprendizes)

        val matchStrings = matches.map { match ->
            "Mentor: ${match.mentor.user.name} - Aprendiz: ${match.aprendiz.user.name} (Score: ${match.score})"
        }

        val adapter = ArrayAdapter(this, android.R.layout.simple_list_item_1, matchStrings)
        matchListView.adapter = adapter
    }

    private fun loadMentors(): List<Mentor> {
        return listOf(
            Mentor(User("Alice", "10 anos", listOf("Kotlin", "Android"), listOf("Programação"), "Bacharel em Ciência da Computação")),
            Mentor(User("Bob", "5 anos", listOf("Java", "Spring"), listOf("Desenvolvimento Web"), "Mestre em Engenharia de Software"))
        )
    }

    private fun loadAprendizes(): List<Aprendiz> {
        return listOf(
            Aprendiz(User("Carlos", "1 ano", listOf("Kotlin"), listOf("Programação"), "Estudante de Engenharia de Software")),
            Aprendiz(User("Diana", "2 anos", listOf("Java"), listOf("Desenvolvimento Web"), "Estudante de Ciência da Computação"))
        )
    }
}
