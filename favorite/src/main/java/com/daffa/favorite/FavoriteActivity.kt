package com.daffa.favorite

import android.content.Intent
import android.os.Bundle
import android.view.View
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.daffa.core.ui.FavoriteAdapter
import com.daffa.mynewstarwarsapp.databinding.ActivityFavoriteBinding
import com.daffa.mynewstarwarsapp.di.FavoriteModuleDependencies
import dagger.hilt.android.EntryPointAccessors
import javax.inject.Inject

class FavoriteActivity : AppCompatActivity() {

    private lateinit var binding: ActivityFavoriteBinding

    @Inject
    lateinit var factory: ViewModelFactory

    private val favoriteViewModel: FavoriteViewModel by viewModels {
        factory
    }
    private val favoriteAdapter = FavoriteAdapter()

    override fun onCreate(savedInstanceState: Bundle?) {
        DaggerFavoriteComponent.builder()
            .context(this)
            .appDependencies(
                EntryPointAccessors.fromApplication(
                    applicationContext,
                    FavoriteModuleDependencies::class.java
                )
            )
            .build()
            .inject(this)
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
                if(favorite.isNotEmpty()){
                    binding.progressBar.visibility = View.GONE
                    binding.rvFavorite.visibility = View.VISIBLE
                    binding.layoutEmpty.visibility = View.GONE
                    favoriteAdapter.setData(favorite)
                }else{
                    binding.progressBar.visibility = View.GONE
                    binding.layoutEmpty.visibility = View.VISIBLE
                    binding.rvFavorite.visibility = View.GONE
                }
            }
        }
    }
}