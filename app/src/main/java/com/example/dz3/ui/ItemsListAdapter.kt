package com.example.dz3.ui


import android.util.Log
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.dz3.R
import com.example.dz3.databinding.ItemLayoutBinding
import com.example.dz3.model.DetailPhone
import timber.log.Timber

class ItemsListAdapter :
    ListAdapter<DetailPhone, ItemsListAdapter.Holder>(ItemDiffUtilCallback()) {

    class ItemDiffUtilCallback : DiffUtil.ItemCallback<DetailPhone>() {
        override fun areItemsTheSame(oldItem: DetailPhone, newItem: DetailPhone): Boolean {
            return oldItem.id == newItem.id
        }

        override fun areContentsTheSame(oldItem: DetailPhone, newItem: DetailPhone): Boolean {
            return oldItem == newItem
        }
    }

    class Holder(
        private val binding: ItemLayoutBinding
    ) : RecyclerView.ViewHolder(binding.root) {

        fun bind(item: DetailPhone) {
            Log.d("Test","bind")

            with(binding) {
                Glide.with(itemView)
                    .load(item.picture)
                    .placeholder(R.drawable.phone)
                    .into(picture)
                price.text = item.disPrice + "$"
            }
        }

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): Holder {
        val binding = ItemLayoutBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return Holder(binding)
    }

    override fun onBindViewHolder(holder: Holder, position: Int) {
        holder.bind(getItem(position))
    }
}