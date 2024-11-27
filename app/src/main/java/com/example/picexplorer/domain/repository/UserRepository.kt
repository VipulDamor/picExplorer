package com.example.picexplorer.domain.repository

import com.example.picexplorer.data.models.User

interface UserRepository {
    fun registerUser(user: User): Boolean
    fun loginUser(email: String, password: String): Boolean
}
