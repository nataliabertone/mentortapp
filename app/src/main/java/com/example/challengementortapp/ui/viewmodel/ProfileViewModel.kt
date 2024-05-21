package com.example.challengementortapp.ui.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.liveData
import com.example.challengementortapp.repository.ProfileRepository
import kotlinx.coroutines.Dispatchers

class ProfileViewModel : ViewModel() {
    private val repository = ProfileRepository()

    // LiveData para obter a lista de mentores
    val mentor = liveData(Dispatchers.IO) {
        val data = repository.getMentor()
        emit(data)
    }

    // LiveData para obter a lista de aprendizes
    val aprendiz = liveData(Dispatchers.IO) {
        val data = repository.getAprendiz()
        emit(data)
    }
}
