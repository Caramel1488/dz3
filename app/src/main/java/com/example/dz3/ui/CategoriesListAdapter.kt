package com.example.dz3.ui


import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.dz3.databinding.ItemCategLayoutBinding

class CategoriesListAdapter: ListAdapter<Pair<String, Int>, CategoriesListAdapter.Holder>(CategDiffUtilCallback()) {

    class CategDiffUtilCallback : DiffUtil.ItemCallback<Pair<String, Int>>() {
        override fun areItemsTheSame(oldItem: Pair<String, Int>, newItem: Pair<String, Int>): Boolean {
            return oldItem.first == newItem.first
        }

        override fun areContentsTheSame(oldItem: Pair<String, Int>, newItem: Pair<String, Int>): Boolean {
            return oldItem == newItem
        }
    }

    class Holder(
        private val binding: ItemCategLayoutBinding
    ) : RecyclerView.ViewHolder(binding.root) {

        fun bind(item: Pair<String,Int>) {

            with(binding) {
                catTitle.text = item.first
                imageInCircle.setImageResource(item.second)
            }
        }

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): Holder {
        val binding = ItemCategLayoutBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return Holder(binding)
    }

    override fun onBindViewHolder(holder: Holder, position: Int) {
        holder.bind(getItem(position))
    }
}