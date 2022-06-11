package com.daffa.mynewstarwarsapp.ui.film

import android.os.Bundle
import android.view.View
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.ContextCompat
import com.bumptech.glide.Glide
import com.daffa.mynewstarwarsapp.R
import com.daffa.mynewstarwarsapp.core.domain.model.Film
import com.daffa.mynewstarwarsapp.databinding.ActivityDetailFilmBinding
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

@AndroidEntryPoint
class DetailFilmActivity : AppCompatActivity() {

    private val viewModel: DetailFilmViewModel by viewModels()

    private lateinit var binding: ActivityDetailFilmBinding
    private var isFavorite = false

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityDetailFilmBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val detail = intent.getParcelableExtra<Film>(EXTRA_DATA)
        showDetailFilm(detail)

        binding.btnCloseDetail.setOnClickListener {
            finish()
        }
    }

    private fun showDetailFilm(detail: Film?) {
        detail?.let { dataFilm ->
            Glide.with(this@DetailFilmActivity)
                .load(detail.imagePath)
                .into(binding.imgDetailFilm)

            binding.tvDetailFilmCrawl.text = dataFilm.description

            //cek ke db apa dia ada di db ?
            viewModel.checkExistInFavorite(dataFilm.filmId).observe(this){
                isFavorite = it
                setFavorite(isFavorite,dataFilm)
            }


//            setFavorite(isFavorite, dataFilm)
            binding.fab.setOnClickListener {
                isFavorite = !isFavorite
                setFavorite(isFavorite, dataFilm)
            }
        }
    }

    private fun setFavorite(statusFavorite: Boolean, film: Film) {
        if (statusFavorite) {
            viewModel.setFilmToFavorite(film)
            binding.fab.setImageDrawable(
                ContextCompat.getDrawable(
                    this,
                    R.drawable.ic_baseline_favorite
                )
            )
        } else {
            viewModel.deleteFilmFromFavorite(film)
            binding.fab.setImageDrawable(
                ContextCompat.getDrawable(
                    this,
                    R.drawable.ic_baseline_favorite_border_24
                )
            )
        }
    }

    companion object {
        const val EXTRA_DATA = "extra_data"
    }
}