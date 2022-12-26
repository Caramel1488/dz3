package com.example.dz3.ui

import android.os.Bundle
import android.util.Log
import android.view.View
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import by.kirich1409.viewbindingdelegate.viewBinding
import com.example.dz3.R
import com.example.dz3.autoCleared
import com.example.dz3.databinding.MainFragmentLayoutBinding

class MainFragment: Fragment(R.layout.main_fragment_layout) {
    private val binding: MainFragmentLayoutBinding by viewBinding(MainFragmentLayoutBinding::bind)
    private var catListAdapter: CategoriesListAdapter by autoCleared()
    private val catList = listOf<Pair<String, Int>>(
        Pair("Phones", R.drawable.phone),
        Pair("Computer", R.drawable.computer),
        Pair("Health", R.drawable.health),
        Pair("Books", R.drawable.book),
        Pair("Garden", R.drawable.plant),
    )

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        Log.d("Test", "Main Fragment created")
        initAdapter()
    }

    private fun initAdapter() {
        Log.d("Test", "Main Fragment cat adapter initied")
        catListAdapter = CategoriesListAdapter()
        with(binding.categoriesList){
            adapter = catListAdapter
            layoutManager = LinearLayoutManager(requireContext(), LinearLayoutManager.HORIZONTAL, false)
            setHasFixedSize(true)
        }
        Log.d("Test", "Main Fragment cat adapter filled")
        catListAdapter.submitList(catList)
    }

}