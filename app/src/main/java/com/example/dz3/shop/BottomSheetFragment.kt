package com.example.dz3.shop

import android.os.Bundle
import android.view.View
import android.widget.ArrayAdapter
import by.kirich1409.viewbindingdelegate.viewBinding
import com.example.dz3.R
import com.example.dz3.databinding.BottomSheetLayoutBinding
import com.google.android.material.bottomsheet.BottomSheetDialogFragment


class BottomSheetFragment: BottomSheetDialogFragment(R.layout.bottom_sheet_layout) {

    private val binding: BottomSheetLayoutBinding by viewBinding(BottomSheetLayoutBinding::bind)

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)


        val brands = arrayOf("Samsung", "Iphone", "Huawei")
        val prices = arrayOf("100 - 300", "300 - 500", "500 +")


        val adapterBrands: ArrayAdapter<String> =
            ArrayAdapter<String>(requireContext(), android.R.layout.simple_spinner_item, brands)
        val adapterPrices: ArrayAdapter<String> =
            ArrayAdapter<String>(requireContext(), android.R.layout.simple_spinner_item, prices)

        adapterBrands.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
        adapterPrices.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
        binding.brandSpinner.adapter = adapterBrands
        binding.priceSpinner.adapter = adapterPrices
    }
}