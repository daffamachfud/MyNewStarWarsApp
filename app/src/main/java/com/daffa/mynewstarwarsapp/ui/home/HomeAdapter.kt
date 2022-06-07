package com.daffa.mynewstarwarsapp.ui.home

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.daffa.mynewstarwarsapp.R
import com.daffa.mynewstarwarsapp.core.domain.model.Film
import com.daffa.mynewstarwarsapp.databinding.ItemFilmBinding
import java.util.ArrayList

class HomeAdapter: RecyclerView.Adapter<HomeAdapter.ListViewHolder>() {
    private var listData = ArrayList<Film>()
    var onItemClick: ((Film) -> Unit)? = null

    @SuppressLint("NotifyDataSetChanged")
    fun setData(newListData: List<Film>?) {
        if (newListData == null) return
        listData.clear()
        listData.addAll(newListData)
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) =
        ListViewHolder(LayoutInflater.from(parent.context).inflate(R.layout.item_film, parent, false))

    override fun getItemCount() = listData.size

    override fun onBindViewHolder(holder: ListViewHolder, position: Int) {
        val data = listData[position]
        holder.bind(data)
    }

    inner class ListViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        private val binding = ItemFilmBinding.bind(itemView)
        fun bind(data: Film) {
            with(binding) {
                Glide.with(itemView.context)
                    .load(data.imagePath)
                    .into(imgPoster)
                tvTitleFilm.text = data.title
                tvDescFilm.text = data.description
            }
        }

        init {
            binding.root.setOnClickListener {
                onItemClick?.invoke(listData[adapterPosition])
            }
        }
    }
}