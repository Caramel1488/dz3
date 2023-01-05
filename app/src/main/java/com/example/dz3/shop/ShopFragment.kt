package com.example.dz3.shop

import android.os.Bundle
import android.util.Log
import android.view.View
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.lifecycleScope
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import by.kirich1409.viewbindingdelegate.viewBinding
import com.example.dz3.R
import com.example.dz3.autoCleared

import com.example.dz3.databinding.ShopFragmentLayoutBinding
import com.example.dz3.network.Network
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class ShopFragment : Fragment(R.layout.shop_fragment_layout) {
    private val binding: ShopFragmentLayoutBinding by viewBinding(ShopFragmentLayoutBinding::bind)
    private var catListAdapter: CategoriesListAdapter by autoCleared()
    private var salesListAdapter: SalesListAdapter by autoCleared()
    private var itemListAdapter: ItemsListAdapter by autoCleared()
    private val viewModel : VM by viewModels()
    private val catList = listOf(
        Pair("Phones", R.drawable.phone),
        Pair("Computer", R.drawable.computer),
        Pair("Health", R.drawable.ic_health),
        Pair("Books", R.drawable.book),
        Pair("Garden", R.drawable.ic_grass),
    )

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        Log.d("Test", "Main Fragment created")
        initAdapters()

        binding.filterImageView.setOnClickListener {
            findNavController().navigate(ShopFragmentDirections.actionActionShopToBottomSheetFragment())
        }
        viewModel.searchMainInfo()
        observe()
    }

    private fun observe() {
        viewModel.itemsList.observe(viewLifecycleOwner){
            itemListAdapter.submitList(it)
        }
        viewModel.salesList.observe(viewLifecycleOwner){
            salesListAdapter.submitList(it)
        }
    }

    private fun initAdapters() {
        Log.d("Test", "Main Fragment cat adapter initied")
        catListAdapter = CategoriesListAdapter(){position ->
            catListAdapter.changeList(position)
        }
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
        itemListAdapter = ItemsListAdapter(){position ->
            findNavController().navigate(ShopFragmentDirections.actionMainFragmentToProductFragment())
        }
        with(binding.itemsList) {
            adapter = itemListAdapter
            layoutManager = GridLayoutManager(requireContext(), 2)
        }
        catListAdapter.submitList(catList)



    }


}