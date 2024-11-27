package com.example.picexplorer.ui.activity

import android.content.Intent
import android.os.Bundle
import android.view.View
import androidx.activity.enableEdgeToEdge
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.databinding.DataBindingUtil
import com.example.picexplorer.R
import com.example.picexplorer.data.repository.UserRepositoryImpl
import com.example.picexplorer.databinding.ActivityRegisterBinding
import com.example.picexplorer.domain.repository.UserRepository
import com.example.picexplorer.domain.usecase.RegisterUserUseCase
import com.example.picexplorer.ui.viewmodels.RegisterViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class RegisterActivity : AppCompatActivity() {


    private val viewModel by viewModels<RegisterViewModel>()


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()



        val binding: ActivityRegisterBinding =
            DataBindingUtil.setContentView(this, R.layout.activity_register)
        binding.setViewModel(viewModel)

        ViewCompat.setOnApplyWindowInsetsListener(binding.register) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }


        viewModel.validationResult.observe(this) { data ->
            binding.emailLayout.error = data.emailError
            binding.passwordLayout.error = data.passwordError
            binding.ageLayout.error = data.ageError
        }
    }

    fun gotoLoginScreen(view: View) {
        finish()
        val intent = Intent(this, LoginActivity::class.java)
        startActivity(intent)
    }

    fun performRegister(view: View) {
        viewModel.onRegisterClick()
    }
}