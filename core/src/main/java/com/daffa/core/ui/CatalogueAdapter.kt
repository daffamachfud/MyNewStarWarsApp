package com.daffa.core.ui

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.daffa.core.R
import com.daffa.core.databinding.ItemMenuCatalogueBinding

class CatalogueAdapter : RecyclerView.Adapter<CatalogueAdapter.ListViewHolder>() {
    var onItemClick: ((String) -> Unit)? = null
    private var list = ArrayList<String>()

    @SuppressLint("NotifyDataSetChanged")
    fun setMenu(newList: List<String>?) {
        if (newList == null) return
        list.clear()
        list.addAll(newList)
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ) = ListViewHolder(
        LayoutInflater.from(parent.context).inflate(R.layout.item_menu_catalogue, parent, false)
    )

    override fun onBindViewHolder(holder: ListViewHolder, position: Int) {
        val data = list[position]
        holder.bind(data)
    }

    override fun getItemCount() = list.size

    inner class ListViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        private val binding = ItemMenuCatalogueBinding.bind(itemView)
        fun bind(data: String) {
            binding.tvMenu.text = data
        }

        init {
            binding.root.setOnClickListener {
                onItemClick?.invoke(list[adapterPosition])
            }
        }
    }
}