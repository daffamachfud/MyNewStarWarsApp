package com.daffa.mynewstarwarsapp.home

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.daffa.core.data.Resource
import com.daffa.core.ui.HomeAdapter
import com.daffa.mynewstarwarsapp.databinding.FragmentHomeBinding
import com.daffa.mynewstarwarsapp.film.DetailFilmActivity
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class HomeFragment : Fragment() {

    private var _binding: FragmentHomeBinding? = null
    private val binding get() = _binding!!
    private val homeViewModel: HomeViewModel by viewModels()
    private var homeAdapter = HomeAdapter()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentHomeBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        if (activity != null) {
            homeViewModel.film.observe(viewLifecycleOwner) { film ->
                if (film != null) {
                    when (film) {
                        is Resource.Loading -> {
                            binding.layoutMovie.progressBar.visibility = View.VISIBLE
                        }
                        is Resource.Success -> {
                            binding.layoutMovie.progressBar.visibility = View.GONE
                            homeAdapter.setData(film.data)
                        }
                        is Resource.Error -> {
                            binding.layoutMovie.progressBar.visibility = View.GONE
                            Toast.makeText(
                                requireActivity(),
                                "Error ${film.message}",
                                Toast.LENGTH_LONG
                            ).show()
                        }
                    }
                }

            }

            homeAdapter.onItemClick = { select ->
                val intent = Intent(activity, DetailFilmActivity::class.java)
                intent.putExtra(DetailFilmActivity.EXTRA_DATA, select)
                startActivity(intent)
            }

            with(binding.layoutMovie.rvHighRating) {
                layoutManager = LinearLayoutManager(context, RecyclerView.VERTICAL, false)
                setHasFixedSize(true)
                adapter = homeAdapter
            }
        }

    }

    override fun onDestroyView() {
        super.onDestroyView()
        binding.layoutMovie.rvHighRating.adapter = null
        _binding = null
    }
}