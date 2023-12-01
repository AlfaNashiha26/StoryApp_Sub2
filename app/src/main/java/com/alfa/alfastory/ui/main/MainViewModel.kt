package com.alfa.alfastory.ui.main

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.asLiveData
import androidx.lifecycle.viewModelScope
import androidx.paging.PagingData
import androidx.paging.cachedIn
import com.alfa.alfastory.retrofit.UserModel
import com.alfa.alfastory.repository.UserRepository
import com.alfa.alfastory.response.ListStoryItem
import kotlinx.coroutines.launch

class MainViewModel(private val userRepository: UserRepository) : ViewModel() {

    val listStory: LiveData<PagingData<ListStoryItem>> =
        userRepository.getStory().cachedIn(viewModelScope)

    fun getSession(): LiveData<UserModel> {
        return userRepository.getSession().asLiveData()
    }

    fun logout() {
        viewModelScope.launch {
            userRepository.logout()
        }
    }
}