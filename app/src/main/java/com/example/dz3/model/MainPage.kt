package com.example.dz3.model

import com.google.gson.annotations.SerializedName

data class MainPage(
    @SerializedName("home_store")
    val homeStore:List<DetailPhone>,
    @SerializedName("best_seller")
    val bestSeller:List<DetailPhone>
)