package com.example.challengementortapp

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity

class LoginActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)

        val loginButton = findViewById<Button>(R.id.loginButton)
        val signupButton = findViewById<Button>(R.id.signupButton)

        loginButton.setOnClickListener {
            // Ação do botão de login
            startActivity(Intent(this, MainActivity::class.java))
        }

        signupButton.setOnClickListener {
            // Navegar para a tela de cadastro
            startActivity(Intent(this, SignupActivity::class.java))
        }
    }
}
