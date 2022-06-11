package com.daffa.core.ui

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.content.ContextCompat
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.daffa.core.R
import com.daffa.core.databinding.ItemFavoriteBinding
import com.daffa.core.domain.model.Favorite

class FavoriteAdapter : RecyclerView.Adapter<FavoriteAdapter.ListViewHolder>() {

    private var listData = ArrayList<Favorite>()
    var onItemClick: ((Favorite) -> Unit)? = null

    @SuppressLint("NotifyDataSetChanged")
    fun setData(newListData: List<Favorite>?) {
        if (newListData == null) return
        listData.clear()
        listData.addAll(newListData)
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): ListViewHolder =
        ListViewHolder(
            LayoutInflater.from(parent.context).inflate(R.layout.item_favorite, parent, false)
        )

    override fun onBindViewHolder(holder: ListViewHolder, position: Int) {
        val data = listData[position]
        holder.bind(data)
    }

    override fun getItemCount(): Int = listData.size

    inner class ListViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        private val binding = ItemFavoriteBinding.bind(itemView)

        @SuppressLint("UseCompatLoadingForDrawables")
        fun bind(data: Favorite) {
            with(binding) {
                Glide.with(itemView.context)
                    .load(data.imagePath)
                    .into(imgFavorite)
                when (data.type) {
                    "film" -> binding.imgFavoriteSign.setImageDrawable(
                        ContextCompat.getDrawable(
                            itemView.context,
                            R.drawable.ic_baseline_movie_filter_24
                        )
                    )
                    "people" -> binding.imgFavoriteSign.setImageDrawable(
                        ContextCompat.getDrawable(
                            itemView.context,
                            R.drawable.ic_baseline_people_24
                        )
                    )
                    "starship" -> binding.imgFavoriteSign.setImageDrawable(
                        ContextCompat.getDrawable(
                            itemView.context,
                            R.drawable.ic_baseline_airplane_ticket_24
                        )
                    )
                }
                tvDescFavorite.text = data.name
            }
        }

        init {
            binding.root.setOnClickListener {
                onItemClick?.invoke(listData[adapterPosition])
            }
        }
    }
}