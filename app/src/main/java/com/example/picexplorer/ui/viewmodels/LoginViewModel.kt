package com.example.picexplorer.ui.viewmodels

import android.text.Editable
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.picexplorer.domain.usecase.LoginUserUseCase
import com.example.picexplorer.utils.ValidationLogin

class LoginViewModel(private val loginUserUseCase: LoginUserUseCase) : ViewModel() {

    private val _email = MutableLiveData<String>()
    val email: LiveData<String> = _email

    private val _password = MutableLiveData<String>()
    val password: LiveData<String> = _password


    private val _validationResult = MutableLiveData<ValidationLogin>()
    val validationResult: LiveData<ValidationLogin> = _validationResult


    fun setEmail(email: Editable) {
        _email.value = email.toString()
    }

    fun setPassword(passWord: Editable) {
        _password.value = passWord.toString()
    }

    fun performUserLogin() {
        _validationResult.value =
            loginUserUseCase.execute(email.value.toString(), password.value.toString())
    }

}
