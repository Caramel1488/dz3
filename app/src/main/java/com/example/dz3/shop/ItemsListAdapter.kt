package com.example.dz3.shop


import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.dz3.R
import com.example.dz3.databinding.ItemLayoutBinding
import com.example.dz3.model.DetailPhone

class ItemsListAdapter(
    private val onClick: (position: Int) -> Unit
) :
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
        private val binding: ItemLayoutBinding,
        private val onClick: (position: Int) -> Unit
    ) : RecyclerView.ViewHolder(binding.root) {

        init {
            binding.root.setOnClickListener {
                onClick(adapterPosition)
            }
        }

        fun bind(item: DetailPhone) {
            with(binding) {
                Glide.with(itemView)
                    .load(item.picture)
                    .placeholder(R.drawable.phone)
                    .into(picture)
                price.text = item.disPrice + "$"
                title.text = item.title
            }
        }

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): Holder {
        val binding = ItemLayoutBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return Holder(binding, onClick)
    }

    override fun onBindViewHolder(holder: Holder, position: Int) {
        holder.bind(getItem(position))
    }
}