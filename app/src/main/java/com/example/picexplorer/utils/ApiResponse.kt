package com.example.picexplorer.utils

sealed class ApiResponse<out T> {
    data class Success<out T>(val data: T) : ApiResponse<T>()
    data class Error(val errorMessage: String, val errorCode: Int? = null) : ApiResponse<Nothing>()
    data object Loading : ApiResponse<Nothing>()
}
