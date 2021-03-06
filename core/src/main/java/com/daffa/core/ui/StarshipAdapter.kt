package com.daffa.core.ui

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.daffa.core.R
import com.daffa.core.databinding.ItemStarshipBinding
import com.daffa.core.domain.model.Starship

class StarshipAdapter : RecyclerView.Adapter<StarshipAdapter.ListViewHolder>() {

    private var listData = ArrayList<Starship>()
    var onItemClick: ((Starship) -> Unit)? = null

    fun setData(newListData: List<Starship>?) {
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
            LayoutInflater.from(parent.context).inflate(R.layout.item_starship, parent, false)
        )

    override fun onBindViewHolder(holder: ListViewHolder, position: Int) {
        val data = listData[position]
        holder.bind(data)
    }

    override fun getItemCount(): Int = listData.size

    inner class ListViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        private val binding = ItemStarshipBinding.bind(itemView)
        fun bind(data: Starship) {
            with(binding) {
                Glide.with(itemView.context)
                    .load(data.imagePath)
                    .into(imgStarship)
                tvStarshipName.text = data.name
            }
        }

        init {
            binding.root.setOnClickListener {
                onItemClick?.invoke(listData[adapterPosition])
            }
        }
    }
}