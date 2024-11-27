package com.example.picexplorer.ui.activity

import android.content.Intent
import android.os.Bundle
import android.view.View
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.databinding.DataBindingUtil
import com.example.picexplorer.R
import com.example.picexplorer.data.repository.UserRepositoryImpl
import com.example.picexplorer.databinding.ActivityLoginBinding
import com.example.picexplorer.domain.repository.UserRepository
import com.example.picexplorer.domain.usecase.LoginUserUseCase
import com.example.picexplorer.ui.viewmodels.LoginViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class LoginActivity : AppCompatActivity() {

    private lateinit var viewModel: LoginViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()

        val userRepository: UserRepository = UserRepositoryImpl()
        val registerUserUseCase = LoginUserUseCase(userRepository)
        viewModel = LoginViewModel(registerUserUseCase)

        val binding: ActivityLoginBinding =
            DataBindingUtil.setContentView(this, R.layout.activity_login)
        binding.setViewModel(viewModel)


        ViewCompat.setOnApplyWindowInsetsListener(binding.login) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
        viewModel.validationResult.observe(this) { data ->
            binding.usernameLayout.error = data.emailError
            binding.loginPasswordLayout.error = data.passwordError
        }

    }

    fun gotoRegisterScreen(view: View) {
        val intent = Intent(this, RegisterActivity::class.java)
        startActivity(intent)
    }

    fun performLogin(view: View) {
        viewModel.performUserLogin()
        if (viewModel.validationResult.value?.isSuccess == true) {
            val intent = Intent(this, MainActivity::class.java)
            startActivity(intent)
        }
    }
}