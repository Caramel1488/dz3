package com.example.dz3.shop


import com.example.dz3.model.Cart
import com.example.dz3.model.DetailPhone
import com.example.dz3.model.MainPage
import com.example.dz3.network.Network

class Repo {

    suspend fun findMainPage(): MainPage {
        return Network.api.getMainPage()
    }

    suspend fun findDetailPhone(): DetailPhone {
        return Network.api.getDetailPhone()
    }

    suspend fun findCart(): Cart{
        return Network.api.getCart()
    }
}