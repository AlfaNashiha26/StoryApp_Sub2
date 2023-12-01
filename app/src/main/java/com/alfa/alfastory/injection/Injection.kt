package com.alfa.alfastory.injection

import com.alfa.alfastory.repository.UserRepository
import android.content.Context
import android.util.Log
import com.alfa.alfastory.R
import com.alfa.alfastory.database.StoryDatabase
import com.alfa.alfastory.retrofit.ApiConfig
import com.alfa.alfastory.utils.UserPreference
import com.alfa.alfastory.utils.dataStore
import kotlinx.coroutines.flow.first
import kotlinx.coroutines.runBlocking

object Injection {
    fun provideRepository(context: Context): UserRepository {
        val pref = UserPreference.getInstance(context.dataStore)
        val user = runBlocking { pref.getUser().first() }
        Log.d(context.getString(R.string.token_disimpan), user.token)
        val apiService = ApiConfig.getApiService(user.token)
        val storyDatabase = StoryDatabase.getDatabase(context)
        return UserRepository(apiService, pref, storyDatabase)
    }

}