package com.daffa.mynewstarwarsapp.people

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.daffa.core.data.Resource
import com.daffa.core.ui.PeopleAdapter
import com.daffa.mynewstarwarsapp.databinding.ActivityPeopleBinding
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class PeopleActivity : AppCompatActivity() {

    private lateinit var binding: ActivityPeopleBinding
    private val peopleViewModel: PeopleViewModel by viewModels()
    private val peopleAdapter = PeopleAdapter()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityPeopleBinding.inflate(layoutInflater)
        setContentView(binding.root)

        loadData()
        with(binding.rvPeople) {
            layoutManager = LinearLayoutManager(context, RecyclerView.VERTICAL, false)
            setHasFixedSize(true)
            adapter = peopleAdapter
        }

        peopleAdapter.onItemClick = { select ->
            val intent = Intent(this, DetailPeopleActivity::class.java)
            intent.putExtra(DetailPeopleActivity.EXTRA_DATA, select)
            startActivity(intent)
        }
    }

    private fun loadData() {
        peopleViewModel.people.observe(this) { people ->
            if (people != null) {
                when (people) {
                    is Resource.Loading -> {
                        binding.progressBar.visibility = View.VISIBLE
                    }
                    is Resource.Success -> {
                        binding.progressBar.visibility = View.GONE
                        peopleAdapter.setData(people.data)
                    }
                    is Resource.Error -> {
                        binding.progressBar.visibility = View.GONE
                        Toast.makeText(
                            this@PeopleActivity,
                            "Error ${people.message}",
                            Toast.LENGTH_LONG
                        ).show()
                    }
                }
            }

        }
    }
}