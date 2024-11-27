package com.example.picexplorer.data.repository

import com.example.picexplorer.data.models.User
import com.example.picexplorer.domain.repository.UserRepository
import javax.inject.Inject

class UserRepositoryImpl @Inject constructor() : UserRepository {

    override fun registerUser(user: User): Boolean {
        return true
    }

    override fun loginUser(email: String, password: String): Boolean {
        return true
    }
}