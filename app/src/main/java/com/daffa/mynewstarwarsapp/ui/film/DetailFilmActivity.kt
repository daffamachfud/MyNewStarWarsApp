package com.daffa.mynewstarwarsapp.ui.film

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.bumptech.glide.Glide
import com.daffa.mynewstarwarsapp.core.domain.model.Film
import com.daffa.mynewstarwarsapp.databinding.ActivityDetailFilmBinding

class DetailFilmActivity : AppCompatActivity() {

    companion object {
        const val EXTRA_DATA = "extra_data"
    }

    private lateinit var binding: ActivityDetailFilmBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityDetailFilmBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val detail = intent.getParcelableExtra<Film>(EXTRA_DATA)
        showDetailFilm(detail)

        initAction()
    }

    private fun initAction() {
        binding.btnCloseDetail.setOnClickListener {
            finish()
        }
    }

    private fun showDetailFilm(detail: Film?) {
        detail?.let {
            Glide.with(this@DetailFilmActivity)
                .load(detail.imagePath)
                .into(binding.imgDetailFilm)

            binding.tvDetailFilmCrawl.text = it.description
        }
    }
}