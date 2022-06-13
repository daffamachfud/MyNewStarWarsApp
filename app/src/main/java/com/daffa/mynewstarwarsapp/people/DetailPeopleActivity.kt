package com.daffa.mynewstarwarsapp.people

import android.os.Bundle
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.ContextCompat
import com.bumptech.glide.Glide
import com.daffa.core.domain.model.People
import com.daffa.mynewstarwarsapp.R
import com.daffa.mynewstarwarsapp.databinding.ActivityDetailPeopleBinding
import com.daffa.mynewstarwarsapp.film.DetailFilmActivity
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class DetailPeopleActivity : AppCompatActivity() {

    private lateinit var binding: ActivityDetailPeopleBinding
    private val viewModel: PeopleViewModel by viewModels()
    private var isFavorite = false

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityDetailPeopleBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val detail = intent.getParcelableExtra<People>(DetailFilmActivity.EXTRA_DATA)
        showDetailPeople(detail)

        binding.btnCloseDetail.setOnClickListener {
            finish()
        }
    }

    private fun showDetailPeople(detail: People?) {
        detail?.let { dataPeople ->
            Glide.with(this@DetailPeopleActivity)
                .load(detail.imagePath)
                .into(binding.imgDetailPeople)

            binding.tvDetailPeopleName.text = dataPeople.name

            //cek ke db apa dia ada di db ?
            viewModel.checkExistInFavorite(dataPeople.peopleId).observe(this) {
                isFavorite = it
                setFavorite(isFavorite, dataPeople)
            }

            binding.fab.setOnClickListener {
                isFavorite = !isFavorite
                setFavorite(isFavorite, dataPeople)
            }
        }
    }

    private fun setFavorite(statusFavorite: Boolean, people: People) {
        if (statusFavorite) {
            viewModel.setPeopleToFavorite(people)
            binding.fab.setImageDrawable(
                ContextCompat.getDrawable(
                    this,
                    R.drawable.ic_baseline_favorite
                )
            )
        } else {
            viewModel.deletePeopleFromFavorite(people)
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