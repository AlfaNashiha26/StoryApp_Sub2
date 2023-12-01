package com.alfa.alfastory.ui.login

import com.alfa.alfastory.repository.UserRepository
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.alfa.alfastory.retrofit.UserModel
import kotlinx.coroutines.launch

class LoginViewModel(private val userRepository: UserRepository) : ViewModel() {

    fun loginUser(email: String, password: String)=
        userRepository.login(email, password)

    fun saveSession(user: UserModel)=
        viewModelScope.launch {
            userRepository.saveSession(user)
        }
}