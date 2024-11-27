package com.example.picexplorer.domain.usecase

import com.example.picexplorer.data.models.User
import com.example.picexplorer.data.repository.UserRepositoryImpl
import com.example.picexplorer.domain.repository.UserRepository
import com.example.picexplorer.utils.ValidationResult
import com.example.picexplorer.utils.isValidEmail
import com.example.picexplorer.utils.isValidPassword
import javax.inject.Inject


class RegisterUserUseCase @Inject constructor(private val repository: UserRepository) {
    fun execute(user: User): ValidationResult {
        if (!user.email.isValidEmail()) {
            return ValidationResult(emailError = "Invalid email address.")
        }
        if (!user.password.isValidPassword()) {
            return ValidationResult(passwordError = "Password must be between 6 and 12 characters.")
        }
        if (!isValidAge(user.age)) {
            return ValidationResult(ageError = "Age must be between 18 and 99.")
        }
        repository.registerUser(user)
        return ValidationResult(isSuccess = true)
    }

    private fun isValidAge(age: Int): Boolean {
        return age in 18..99
    }
}


