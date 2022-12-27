package com.example.dz3.network

import com.example.dz3.model.Cart
import com.example.dz3.model.DetailPhone
import com.example.dz3.model.MainPage
import retrofit2.http.GET

interface Api {
    @GET("654bd15e-b121-49ba-a588-960956b15175")
    suspend fun getMainPage(): MainPage

    @GET("6c14c560-15c6-4248-b9d2-b4508df7d4f5")
    suspend fun getDetailPhone(): DetailPhone

    @GET("53539a72-3c5f-4f30-bbb1-6ca10d42c149")
    suspend fun getCart(): Cart
}