package com.example.dz3.ui

import android.os.Bundle
import android.util.Log
import android.view.View
import androidx.fragment.app.Fragment
import androidx.lifecycle.lifecycleScope
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import by.kirich1409.viewbindingdelegate.viewBinding
import com.example.dz3.R
import com.example.dz3.autoCleared
import com.example.dz3.databinding.MainFragmentLayoutBinding
import com.example.dz3.network.Network
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class MainFragment : Fragment(R.layout.main_fragment_layout) {
    private val binding: MainFragmentLayoutBinding by viewBinding(MainFragmentLayoutBinding::bind)
    private var catListAdapter: CategoriesListAdapter by autoCleared()
    private var salesListAdapter: SalesListAdapter by autoCleared()
    private var itemListAdapter: ItemsListAdapter by autoCleared()
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
        initAdapters()
    }

    private fun initAdapters() {
        Log.d("Test", "Main Fragment cat adapter initied")
        catListAdapter = CategoriesListAdapter()
        with(binding.categoriesList) {
            adapter = catListAdapter
            layoutManager =
                LinearLayoutManager(requireContext(), LinearLayoutManager.HORIZONTAL, false)
            setHasFixedSize(true)
        }
        Log.d("Test", "Main Fragment cat adapter filled")
        Log.d("Test", "Main Fragment sales adapter initied")
        salesListAdapter = SalesListAdapter()
        with(binding.hotSalesList) {
            adapter = salesListAdapter
            layoutManager =
                LinearLayoutManager(requireContext(), LinearLayoutManager.HORIZONTAL, false)
            setHasFixedSize(true)
        }
        Log.d("Test", "Main Fragment items adapter initied")
        itemListAdapter = ItemsListAdapter()
        with(binding.itemsList) {
            adapter = itemListAdapter
            layoutManager = GridLayoutManager(requireContext(), 2)
            setHasFixedSize(true)
        }
        catListAdapter.submitList(catList)
        searchSales()
        searchItems()

    }

    fun searchSales() {
        lifecycleScope.launch(Dispatchers.IO) {
            salesListAdapter.submitList(Network.api.getMainPage().homeStore)
            Log.d("Test", "Main Fragment sales adapter filled")
        }
    }

    fun searchItems() {

        lifecycleScope.launch(Dispatchers.IO) {
            itemListAdapter.submitList(Network.api.getMainPage().bestSeller)
            Log.d("Test", "Main Fragment items adapter filled")


        }

    }
}