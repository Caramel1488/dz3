package com.example.dz3.shop


import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.core.content.ContextCompat.getColor
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.example.dz3.R
import com.example.dz3.databinding.ItemCategLayoutBinding

class CategoriesListAdapter(
    private val onClick: (position: Int) -> Unit
): ListAdapter<Pair<String, Int>, CategoriesListAdapter.Holder>(CategDiffUtilCallback()) {

    private val checkList = mutableListOf<Boolean>(true, false,false,false,false)

    fun changeList(position: Int){
        for (i in 0 until checkList.size){
            if(checkList[i]) checkList[i] = false
        }
        checkList[position]=true
    }

    class CategDiffUtilCallback : DiffUtil.ItemCallback<Pair<String, Int>>() {
        override fun areItemsTheSame(oldItem: Pair<String, Int>, newItem: Pair<String, Int>): Boolean {
            return oldItem.first == newItem.first
        }

        override fun areContentsTheSame(oldItem: Pair<String, Int>, newItem: Pair<String, Int>): Boolean {
            return oldItem == newItem
        }
    }

    class Holder(
        private val binding: ItemCategLayoutBinding,
        private val checkList: MutableList<Boolean>,
        private val onClick: (position: Int) -> Unit
    ) : RecyclerView.ViewHolder(binding.root) {

        init {
            binding.root.setOnClickListener {
                onClick(adapterPosition)

            }
        }


        fun bind(item: Pair<String,Int>) {

            with(binding) {
                catTitle.text = item.first
                imageInCircle.setImageResource(item.second)
                if (checkList[position]){
                    circle.setColorFilter(getColor(binding.root.context, R.color.coral_500))
                    imageInCircle.setColorFilter(getColor(binding.root.context, R.color.white))
                    catTitle.setTextColor(getColor(binding.root.context, R.color.coral_500))
                }else{
                    circle.setColorFilter(getColor(binding.root.context, R.color.white))
                    imageInCircle.setColorFilter(getColor(binding.root.context, R.color.black))
                    catTitle.setTextColor(getColor(binding.root.context, R.color.black))
                }
            }

        }

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): Holder {
        val binding = ItemCategLayoutBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return Holder(binding, checkList, onClick)
    }

    override fun onBindViewHolder(holder: Holder, position: Int) {
        holder.bind(getItem(position))
    }
}