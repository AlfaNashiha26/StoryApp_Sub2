package com.alfa.alfastory.ui.register

import com.alfa.alfastory.repository.UserRepository
import androidx.lifecycle.ViewModel

class RegisterViewModel(private val userRepository: UserRepository) : ViewModel() {

    fun registerUser(name: String, email: String, password: String) =
        userRepository.register(name ,email, password)
    }