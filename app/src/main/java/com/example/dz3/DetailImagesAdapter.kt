package com.example.dz3


import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.dz3.R
import com.example.dz3.databinding.ItemSaleLayoutBinding



class DetailImagesAdapter: ListAdapter<String, DetailImagesAdapter.Holder>(SalesDiffUtilCallback()) {

    class SalesDiffUtilCallback : DiffUtil.ItemCallback<String>() {
        override fun areItemsTheSame(oldItem: String, newItem: String): Boolean {
            return oldItem == newItem
        }

        override fun areContentsTheSame(oldItem: String, newItem: String): Boolean {
            return oldItem == newItem
        }
    }

    class Holder(
        private val binding: ItemSaleLayoutBinding
    ) : RecyclerView.ViewHolder(binding.root) {

        fun bind(item: String) {

            with(binding) {
                Glide.with(itemView)
                    .load(item)
                    .placeholder(R.drawable.phone)
                    .into(picture)

            }
        }

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): Holder {
        val binding = ItemSaleLayoutBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return Holder(binding)
    }

    override fun onBindViewHolder(holder: Holder, position: Int) {
        holder.bind(getItem(position))
    }
}