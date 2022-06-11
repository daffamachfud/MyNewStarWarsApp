package com.daffa.mynewstarwarsapp.starship

import android.os.Bundle
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.ContextCompat
import com.bumptech.glide.Glide
import com.daffa.core.domain.model.Starship
import com.daffa.mynewstarwarsapp.R
import com.daffa.mynewstarwarsapp.databinding.ActivityDetailStarshipBinding
import com.daffa.mynewstarwarsapp.film.DetailFilmActivity
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class DetailStarshipActivity : AppCompatActivity() {

    private lateinit var binding: ActivityDetailStarshipBinding
    private val viewModel: StarshipViewModel by viewModels()
    private var isFavorite = false

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityDetailStarshipBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val detail = intent.getParcelableExtra<Starship>(DetailFilmActivity.EXTRA_DATA)
        showDetailStarship(detail)
    }

    private fun showDetailStarship(detail: Starship?) {
        detail?.let { dataStarship ->
            Glide.with(this@DetailStarshipActivity)
                .load(detail.imagePath)
                .into(binding.imgDetailStarship)

            binding.tvDetailStarshipName.text = dataStarship.name

            //cek ke db apa dia ada di db ?
            viewModel.checkExistInFavorite(dataStarship.starshipId).observe(this) {
                isFavorite = it
                setFavorite(isFavorite, dataStarship)
            }

            binding.fab.setOnClickListener {
                isFavorite = !isFavorite
                setFavorite(isFavorite, dataStarship)
            }
        }
    }

    private fun setFavorite(statusFavorite: Boolean, starship: Starship) {
        if (statusFavorite) {
            viewModel.setStarshipToFavorite(starship)
            binding.fab.setImageDrawable(
                ContextCompat.getDrawable(
                    this,
                    R.drawable.ic_baseline_favorite
                )
            )
        } else {
            viewModel.deleteStarshipFromFavorite(starship)
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