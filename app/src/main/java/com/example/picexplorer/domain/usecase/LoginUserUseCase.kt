package com.example.picexplorer.domain.usecase

import com.example.picexplorer.domain.repository.UserRepository
import com.example.picexplorer.utils.ValidationLogin
import com.example.picexplorer.utils.isValidEmail
import com.example.picexplorer.utils.isValidPassword

class LoginUserUseCase(private val repository: UserRepository) {

    fun execute(email: String, password: String): ValidationLogin {
        if (!email.isValidEmail()) {
            return ValidationLogin(emailError = "Invalid email address.")
        }
        if (!password.isValidPassword()) {
            return ValidationLogin(passwordError = "Password must be between 6 and 12 characters.")
        }
        repository.loginUser(email, password)
        return ValidationLogin(isSuccess = true)
    }

}