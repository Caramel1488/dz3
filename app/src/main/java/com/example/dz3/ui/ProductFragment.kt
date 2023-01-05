package com.example.dz3.ui

import android.os.Bundle
import android.util.Log
import android.view.View
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.recyclerview.widget.LinearLayoutManager
import by.kirich1409.viewbindingdelegate.viewBinding
import com.example.dz3.DetailImagesAdapter
import com.example.dz3.R
import com.example.dz3.autoCleared
import com.example.dz3.databinding.DetailPhoneLayoutBinding
import com.example.dz3.model.DetailPhone
import com.example.dz3.network.Network
import com.example.dz3.shop.VM

class ProductFragment : Fragment(R.layout.detail_phone_layout) {
    private val binding: DetailPhoneLayoutBinding by viewBinding(DetailPhoneLayoutBinding::bind)
    private var imagesListAdapter: DetailImagesAdapter by autoCleared()
    private val viewModel: VM by viewModels()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initAdapter()
        viewModel.searchDetailPhone()
        viewModel.detailPhone.observe(viewLifecycleOwner){
            bindInfo(it)
        }
    }

    private fun initAdapter() {
        imagesListAdapter = DetailImagesAdapter()
        with(binding.imagesList) {
            adapter = imagesListAdapter
            layoutManager = LinearLayoutManager(requireContext(), LinearLayoutManager.HORIZONTAL, false)

        }
    }

    private fun bindInfo(phone:DetailPhone) {
        imagesListAdapter.submitList(phone.images)
        with(binding) {
            titleTextview.text = phone.title
            procTextView.text = phone.cpu
            cameraTextView.text = phone.camera
            sdTextView.text = phone.ssd
            storageTextView.text = phone.sd
            addButton.text = "Add to cart ${phone.price} $"
        }
    }
}