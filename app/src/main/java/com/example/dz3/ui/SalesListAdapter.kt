package com.example.dz3.ui


import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.dz3.R
import com.example.dz3.databinding.ItemCategLayoutBinding
import com.example.dz3.databinding.ItemSaleLayoutBinding
import com.example.dz3.model.DetailPhone

class SalesListAdapter: ListAdapter<DetailPhone, SalesListAdapter.Holder>(SalesDiffUtilCallback()) {

    class SalesDiffUtilCallback : DiffUtil.ItemCallback<DetailPhone>() {
        override fun areItemsTheSame(oldItem: DetailPhone, newItem: DetailPhone): Boolean {
            return oldItem.id == newItem.id
        }

        override fun areContentsTheSame(oldItem: DetailPhone, newItem: DetailPhone): Boolean {
            return oldItem == newItem
        }
    }

    class Holder(
        private val binding: ItemSaleLayoutBinding
    ) : RecyclerView.ViewHolder(binding.root) {

        fun bind(item: DetailPhone) {

            with(binding) {
                Glide.with(itemView)
                    .load(item.picture)
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