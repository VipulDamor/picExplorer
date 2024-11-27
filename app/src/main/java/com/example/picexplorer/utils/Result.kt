package com.example.picexplorer.utils

data class ValidationResult(
    val emailError: String? = null,
    val passwordError: String? = "",
    val ageError: String? = "",
    val isSuccess : Boolean = false
)
data class ValidationLogin(
    val emailError: String? = null,
    val passwordError: String? = "",
    val isSuccess : Boolean = false
)