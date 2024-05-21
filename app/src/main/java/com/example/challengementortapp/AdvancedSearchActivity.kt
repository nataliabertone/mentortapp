// AdvancedSearchActivity.kt
package com.example.challengementortapp.ui

import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.lifecycleScope
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.challengementortapp.R
import com.example.challengementortapp.api.RetrofitInstance
import com.example.challengementortapp.models.User
import kotlinx.coroutines.launch

class AdvancedSearchActivity : AppCompatActivity() {

    private lateinit var recyclerView: RecyclerView
    private lateinit var userAdapter: UserAdapter
    private val userList = mutableListOf<User>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_advanced_search)

        recyclerView = findViewById(R.id.recyclerView)
        userAdapter = UserAdapter(userList)
        recyclerView.layoutManager = LinearLayoutManager(this)
        recyclerView.adapter = userAdapter

        fetchUsers()
    }

    private fun fetchUsers() {
        lifecycleScope.launch {
            try {
                val users = RetrofitInstance.api.getUsers()
                userList.clear()
                userList.addAll(users)
                userAdapter.notifyDataSetChanged()
            } catch (e: Exception) {
                Toast.makeText(this@AdvancedSearchActivity, "Erro ao obter usuários", Toast.LENGTH_SHORT).show()
                Log.e("AdvancedSearchActivity", "Erro: ${e.message}")
            }
        }
    }
}
