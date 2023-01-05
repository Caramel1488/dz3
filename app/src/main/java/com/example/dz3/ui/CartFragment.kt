package com.example.dz3.ui

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.recyclerview.widget.LinearLayoutManager
import by.kirich1409.viewbindingdelegate.viewBinding
import com.example.dz3.DetailImagesAdapter
import com.example.dz3.R
import com.example.dz3.autoCleared
import com.example.dz3.databinding.CartFragmentLayoutBinding
import com.example.dz3.databinding.DetailPhoneLayoutBinding
import com.example.dz3.shop.VM

class CartFragment: Fragment(R.layout.cart_fragment_layout) {
    private val binding: CartFragmentLayoutBinding by viewBinding(CartFragmentLayoutBinding::bind)
    private val viewModel: VM by viewModels()
    private var cartListAdapter: CartListAdapter by autoCleared()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initAdapter()
        viewModel.searchCart()
        viewModel.cart.observe(viewLifecycleOwner){
            cartListAdapter.submitList(it.basket)
            binding.totalTextView.text = binding.totalTextView.text.toString() + it.total + " $"
        }
    }

    private fun initAdapter() {
        cartListAdapter = CartListAdapter()
        with(binding.cartList){
            adapter = cartListAdapter
            layoutManager = LinearLayoutManager(requireContext())
        }
    }
}