package com.example.challengementortapp

import android.os.Bundle
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity


class SignupActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_signup) // Infla o layout diretamente

        val signupButton = findViewById<Button>(R.id.signupButton)
        val loginButton = findViewById<Button>(R.id.loginButton)

        signupButton.setOnClickListener {
            // Ação do botão de cadastro, por enquanto apenas um placeholder
            finish()
        }

        loginButton.setOnClickListener {
            // Navegar de volta para a tela de login
            finish()
        }
    }
}
