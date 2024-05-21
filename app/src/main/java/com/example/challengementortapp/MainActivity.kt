package com.example.challengementortapp

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity
import androidx.work.OneTimeWorkRequestBuilder
import androidx.work.WorkManager
import com.example.challengementortapp.ui.AdvancedSearchActivity
import com.example.challengementortapp.ui.CreateProfileActivity
import java.util.concurrent.TimeUnit

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val createProfileButton: Button = findViewById(R.id.createProfileButton)
        createProfileButton.setOnClickListener {
            val intent = Intent(this, CreateProfileActivity::class.java)
            startActivity(intent)
        }

        val matchmakingButton: Button = findViewById(R.id.matchmakingButton)
        matchmakingButton.setOnClickListener {
            val intent = Intent(this, MatchmakingActivity::class.java)
            startActivity(intent)
        }

        val advancedSearchButton: Button = findViewById(R.id.advancedSearchButton)
        advancedSearchButton.setOnClickListener {
            val intent = Intent(this, AdvancedSearchActivity::class.java)
            startActivity(intent)
        }

        // Agendar uma notificação para simular notificações push
        scheduleNotification()
    }

    private fun scheduleNotification() {
        val notificationWork = OneTimeWorkRequestBuilder<NotificationWorker>()
            .setInitialDelay(10, TimeUnit.SECONDS) // Notificação após 10 segundos
            .build()

        WorkManager.getInstance(this).enqueue(notificationWork)
    }
}

