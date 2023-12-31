package com.alfa.alfastory.ui.detail

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.alfa.alfastory.R
import com.alfa.alfastory.databinding.ActivityDetailBinding
import com.alfa.alfastory.utils.loadImage
import com.alfa.alfastory.response.ListStoryItem
import java.util.TimeZone

class DetailActivity : AppCompatActivity() {

    private var detailBinding: ActivityDetailBinding? = null
    private val binding get() = detailBinding!!

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        detailBinding = ActivityDetailBinding.inflate(layoutInflater)
        setContentView(binding.root)

        supportActionBar?.title = getString(R.string.detail_story)

        setData()
    }

    private fun setData() {
        @Suppress("DEPRECATION")
        val story = intent.getParcelableExtra<ListStoryItem>(DETAIL_STORY) as ListStoryItem
        loadImage(applicationContext, story.photoUrl, binding.ivDetail)
        binding.tvDetailName.text = story.name
        binding.tvGetDeskripsi.text = story.description
        binding.tvDateCreated.text =
            com.alfa.alfastory.utils.formatDate(story.createdAt, TimeZone.getDefault().id)
        binding.tvGetLocationLon.text = story.lon.toString()
        binding.tvGetLocationLat.text = story.lat.toString()
    }

    companion object {
        const val DETAIL_STORY = "detail_story"
    }
}