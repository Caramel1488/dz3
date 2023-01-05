package com.example.dz3.shop

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.dz3.model.Cart
import com.example.dz3.model.DetailPhone
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class VM: ViewModel() {

    private val repository = Repo()

    private var salesListLiveData = MutableLiveData<List<DetailPhone>>()
    private var itemsListLiveData = MutableLiveData<List<DetailPhone>>()
    private var detailPhoneLiveData = MutableLiveData<DetailPhone>()
    private var cartLiveData = MutableLiveData<Cart>()

    val salesList: LiveData<List<DetailPhone>>
        get() = salesListLiveData
    val itemsList: LiveData<List<DetailPhone>>
        get() = itemsListLiveData
    val detailPhone: LiveData<DetailPhone>
        get() = detailPhoneLiveData
    val cart: LiveData<Cart>
        get() = cartLiveData

    fun searchMainInfo(){
        viewModelScope.launch(Dispatchers.IO) {
            val mainPage = repository.findMainPage()
            salesListLiveData.postValue(mainPage.homeStore)
            itemsListLiveData.postValue(mainPage.bestSeller)
        }
    }

    fun searchDetailPhone(){
        viewModelScope.launch(Dispatchers.IO) {
            val detailPhone = repository.findDetailPhone()
            detailPhoneLiveData.postValue(detailPhone)
        }
    }

    fun searchCart(){
        viewModelScope.launch(Dispatchers.IO) {
            val cart = repository.findCart()
            cartLiveData.postValue(cart)
        }
    }
}