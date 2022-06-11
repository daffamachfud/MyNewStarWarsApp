package com.daffa.mynewstarwarsapp.favorite

import android.content.Intent
import android.os.Bundle
import android.view.View
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.daffa.core.ui.FavoriteAdapter
import com.daffa.mynewstarwarsapp.databinding.ActivityFavoriteBinding
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class FavoriteActivity : AppCompatActivity() {

    private lateinit var binding: ActivityFavoriteBinding
    private val favoriteViewModel: FavoriteViewModel by viewModels()
    private val favoriteAdapter = FavoriteAdapter()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityFavoriteBinding.inflate(layoutInflater)
        setContentView(binding.root)

        loadData()
        with(binding.rvFavorite) {
            layoutManager = LinearLayoutManager(context, RecyclerView.VERTICAL, false)
            setHasFixedSize(true)
            adapter = favoriteAdapter
        }

        favoriteAdapter.onItemClick = { select ->
            val intent = Intent(this, DetailFavoriteActivity::class.java)
            intent.putExtra(DetailFavoriteActivity.EXTRA_DATA, select)
            startActivity(intent)
        }
    }

    private fun loadData() {
        binding.progressBar.visibility = View.VISIBLE
        favoriteViewModel.favorite.observe(this) { favorite ->
            if (favorite != null) {
                binding.progressBar.visibility = View.GONE
                favoriteAdapter.setData(favorite)
            }
        }
    }
}