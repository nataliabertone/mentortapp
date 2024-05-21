package com.example.challengementortapp.ui

import android.content.Context
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Spinner
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.challengementortapp.R

class CreateProfileActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_create_profile)

        val nameEditText: EditText = findViewById(R.id.name)
        val experienceEditText: EditText = findViewById(R.id.experience)
        val skillsEditText: EditText = findViewById(R.id.skills)
        val interestsEditText: EditText = findViewById(R.id.interests)
        val educationEditText: EditText = findViewById(R.id.education)
        val roleSpinner: Spinner = findViewById(R.id.role)
        val saveButton: Button = findViewById(R.id.saveProfile)

        saveButton.setOnClickListener {
            val name = nameEditText.text.toString().trim()
            val experience = experienceEditText.text.toString().trim()
            val skills = skillsEditText.text.toString().trim().split(",").map { it.trim() }
            val interests = interestsEditText.text.toString().trim().split(",").map { it.trim() }
            val education = educationEditText.text.toString().trim()
            val role = roleSpinner.selectedItem.toString()

            if (name.isEmpty() || experience.isEmpty() || skills.isEmpty() || interests.isEmpty() || education.isEmpty() || role.isEmpty()) {
                Toast.makeText(this, "Por favor, preencha todos os campos", Toast.LENGTH_SHORT).show()
            } else {
                saveUserProfile(name, experience, skills, interests, education, role)
                Toast.makeText(this, "Perfil salvo com sucesso!", Toast.LENGTH_SHORT).show()
                finish() // Fecha a atividade após salvar o perfil
            }
        }
    }

    private fun saveUserProfile(name: String, experience: String, skills: List<String>, interests: List<String>, education: String, role: String) {
        val sharedPreferences = getSharedPreferences("UserProfile", Context.MODE_PRIVATE)
        val editor = sharedPreferences.edit()
        editor.putString("name", name)
        editor.putString("experience", experience)
        editor.putString("skills", skills.joinToString(","))
        editor.putString("interests", interests.joinToString(","))
        editor.putString("education", education)
        editor.putString("role", role)
        editor.apply() // Salva os dados de forma assíncrona
    }
}

