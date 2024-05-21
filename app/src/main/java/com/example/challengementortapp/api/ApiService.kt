package com.example.challengementortapp.api

import com.example.challengementortapp.models.User
import retrofit2.http.GET
import retrofit2.http.Path

interface ApiService {
    @GET("mentores")
    suspend fun getMentor(): List<User>

    @GET("aprendizes")
    suspend fun getAprendiz(): List<User>

    @GET("mentores/{id}")
    suspend fun getMentor(@Path("id") id: String): User

    @GET("aprendizes/{id}")
    suspend fun getAprendiz(@Path("id") id: String): User

    @GET("users")
    suspend fun getUsers(): List<User>
}

