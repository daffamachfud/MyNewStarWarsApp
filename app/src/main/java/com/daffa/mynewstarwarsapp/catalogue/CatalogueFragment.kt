package com.daffa.mynewstarwarsapp.catalogue

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.daffa.core.ui.CatalogueAdapter
import com.daffa.mynewstarwarsapp.R
import com.daffa.mynewstarwarsapp.databinding.FragmentCatalogueBinding
import com.daffa.mynewstarwarsapp.people.PeopleActivity
import com.daffa.mynewstarwarsapp.starship.StarshipActivity
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class CatalogueFragment : Fragment() {

    private var _binding: FragmentCatalogueBinding? = null
    private val binding get() = _binding!!
    private val catalogueAdapter = CatalogueAdapter()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentCatalogueBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        if (activity != null) {
            val dataMenu = resources.getStringArray(R.array.catalogue).toList()
            catalogueAdapter.setMenu(
                dataMenu
            )
            catalogueAdapter.onItemClick = { select ->
                Log.d(TAG, "Click Menu $select")
                when (select) {
                    "Favorite" -> {
                        val uri = Uri.parse("favoriteapp://favorite")
                        startActivity(Intent(Intent.ACTION_VIEW, uri))
                    }
                    "People" -> {
                        val intent = Intent(activity, PeopleActivity::class.java)
                        startActivity(intent)
                    }
                    "Starship" -> {
                        val intent = Intent(activity, StarshipActivity::class.java)
                        startActivity(intent)
                    }
                }
            }

            with(binding.rvCatalogue) {
                layoutManager = LinearLayoutManager(context, RecyclerView.VERTICAL, false)
                setHasFixedSize(true)
                adapter = catalogueAdapter
            }
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        binding.rvCatalogue.adapter = null
        _binding = null
    }

    companion object {
        const val TAG = "CatalogueFragment"
    }
}