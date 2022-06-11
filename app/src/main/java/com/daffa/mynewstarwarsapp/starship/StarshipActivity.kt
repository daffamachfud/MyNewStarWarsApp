package com.daffa.mynewstarwarsapp.starship

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.daffa.core.data.Resource
import com.daffa.core.ui.StarshipAdapter
import com.daffa.mynewstarwarsapp.databinding.ActivityStarshipBinding
import com.daffa.mynewstarwarsapp.film.DetailFilmActivity
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class StarshipActivity : AppCompatActivity() {

    private lateinit var binding: ActivityStarshipBinding
    private val starshipViewModel: StarshipViewModel by viewModels()
    private val starshipAdapter = StarshipAdapter()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityStarshipBinding.inflate(layoutInflater)
        setContentView(binding.root)

        loadData()
        with(binding.rvStarship) {
            layoutManager = LinearLayoutManager(context, RecyclerView.VERTICAL, false)
            setHasFixedSize(true)
            adapter = starshipAdapter
        }
        starshipAdapter.onItemClick = { select ->
            val intent = Intent(this, DetailStarshipActivity::class.java)
            intent.putExtra(DetailFilmActivity.EXTRA_DATA, select)
            startActivity(intent)
        }
    }

    private fun loadData() {
        starshipViewModel.starship.observe(this) { starship ->
            if (starship != null) {
                when (starship) {
                    is Resource.Loading -> {
                        binding.progressBar.visibility = View.VISIBLE
                    }
                    is Resource.Success -> {
                        binding.progressBar.visibility = View.GONE
                        starshipAdapter.setData(starship.data)
                    }
                    is Resource.Error -> {
                        binding.progressBar.visibility = View.GONE
                        Toast.makeText(
                            this@StarshipActivity,
                            "Error ${starship.message}",
                            Toast.LENGTH_LONG
                        ).show()
                    }
                }
            }

        }
    }

}