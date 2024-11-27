package com.example.picexplorer.ui.viewmodels

import android.text.Editable
import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.picexplorer.data.models.User
import com.example.picexplorer.domain.usecase.RegisterUserUseCase
import com.example.picexplorer.utils.ValidationResult
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class RegisterViewModel @Inject constructor(private val registerUserUseCase: RegisterUserUseCase) : ViewModel() {

    private val _email = MutableLiveData<String>()
    val email: LiveData<String> = _email

    private val _password = MutableLiveData<String>()
    val password: LiveData<String> = _password

    private val _age = MutableLiveData<String>()
    val age: LiveData<String> = _age

    private val _validationResult = MutableLiveData<ValidationResult>()
    val validationResult: LiveData<ValidationResult> = _validationResult



    fun setEmail(email: Editable) {
        _email.value = email.toString()
    }
    fun setPassword(passWord: Editable) {
        _password.value = passWord.toString()
    }
    fun setAge(age: Editable) {
        _age.value = age.toString()
    }


    fun onRegisterClick() {
        val ageInt = age.value.toString().toIntOrNull() ?: 0
        Log.d("TAG", "execute: email ::: "+email.value)
        val result = registerUserUseCase.execute(
            User(
                email.value.toString(),
                password.value.toString(),
                ageInt
            )
        )
        _validationResult.value = result
    }
}
