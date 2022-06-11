package com.daffa.mynewstarwarsapp.favorite

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.bumptech.glide.Glide
import com.daffa.core.domain.model.Favorite
import com.daffa.mynewstarwarsapp.databinding.ActivityDetailFavoriteBinding

class DetailFavoriteActivity : AppCompatActivity() {

    private lateinit var binding: ActivityDetailFavoriteBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityDetailFavoriteBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val detail = intent.getParcelableExtra<Favorite>(EXTRA_DATA)
        showDetailFavorite(detail)
    }

    private fun showDetailFavorite(detail: Favorite?) {
        detail?.let { data ->
            Glide.with(this@DetailFavoriteActivity)
                .load(detail.imagePath)
                .into(binding.imgDetailFavorite)

            binding.tvDetail.text = data.name
        }
    }

    companion object {
        const val EXTRA_DATA = "extra_data"
    }
}