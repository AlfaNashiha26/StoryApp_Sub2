package com.alfa.alfastory.ui.story

import androidx.lifecycle.ViewModel
import com.alfa.alfastory.repository.UserRepository
import java.io.File

class UploadStoryViewModel(private val userRepository: UserRepository) : ViewModel() {
    fun uploadImage(file: File, description: String, lat: Double?, lon: Double?) = userRepository.uploadImage(file, description, lat, lon)
}