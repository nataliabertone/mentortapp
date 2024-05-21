package com.example.challengementortapp.repository

import com.example.challengementortapp.api.ApiClient
import com.example.challengementortapp.api.ApiService
import com.example.challengementortapp.models.User

class ProfileRepository {
    private val apiService: ApiService by lazy {
        ApiClient.instance.create(ApiService::class.java)
    }

    // Função para obter a lista de mentores
    suspend fun getMentor(): List<User> {
        return apiService.getMentor()
    }

    // Função para obter a lista de aprendizes
    suspend fun getAprendiz(): List<User> {
        return apiService.getAprendiz()
    }

    // Função para obter um mentor específico pelo ID
    suspend fun getMentor(id: String): User {
        return apiService.getMentor(id)
    }

    // Função para obter um aprendiz específico pelo ID
    suspend fun getAprendiz(id: String): User {
        return apiService.getAprendiz(id)
    }
}
