// User.kt
package com.example.challengementortapp.models

data class User(
    val name: String,
    val experience: String,
    val skills: List<String>,
    val interests: List<String>,
    val education: String
)
