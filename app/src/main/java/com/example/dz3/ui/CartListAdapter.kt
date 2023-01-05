package com.example.dz3.ui

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.dz3.R
import com.example.dz3.databinding.ItemCartLayoutBinding
import com.example.dz3.model.CartPhone


class CartListAdapter :
    ListAdapter<CartPhone, CartListAdapter.Holder>(ItemDiffUtilCallback()) {

    class ItemDiffUtilCallback : DiffUtil.ItemCallback<CartPhone>() {
        override fun areItemsTheSame(oldItem: CartPhone, newItem: CartPhone): Boolean {
            return oldItem.id == newItem.id
        }

        override fun areContentsTheSame(oldItem: CartPhone, newItem: CartPhone): Boolean {
            return oldItem == newItem
        }
    }

    class Holder(
        private val binding: ItemCartLayoutBinding
    ) : RecyclerView.ViewHolder(binding.root) {

        fun bind(item: CartPhone) {
            with(binding) {
                Glide.with(itemView)
                    .load(item.images)
                    .placeholder(R.drawable.phone)
                    .into(imageImageView)
                priceTextView.text = item.price + "$"
                titleTextView.text = item.title
            }
        }

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): Holder {
        val binding = ItemCartLayoutBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return Holder(binding)
    }

    override fun onBindViewHolder(holder: Holder, position: Int) {
        holder.bind(getItem(position))
    }
}