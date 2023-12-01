package com.alfa.alfastory.ui.welcome

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.asLiveData
import com.alfa.alfastory.retrofit.UserModel
import com.alfa.alfastory.repository.UserRepository

class WelcomeViewModel (private val userRepository: UserRepository) : ViewModel() {
    fun getSession(): LiveData<UserModel> {
        return userRepository.getSession().asLiveData()
    }
}