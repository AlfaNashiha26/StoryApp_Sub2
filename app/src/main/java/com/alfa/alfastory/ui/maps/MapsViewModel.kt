package com.alfa.alfastory.ui.maps

import androidx.lifecycle.ViewModel
import com.alfa.alfastory.repository.UserRepository

class MapsViewModel (private val userRepository: UserRepository) : ViewModel() {
    fun getListStoryLocation() = userRepository.getStoryWithLocation()
}