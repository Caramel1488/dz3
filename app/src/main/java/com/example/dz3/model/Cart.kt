package com.example.dz3.model

import com.google.gson.annotations.SerializedName

data class Cart(
    @SerializedName("basket")
    val basket:List<CartPhone>,
    @SerializedName("delivery")
    val delivery:String,
    @SerializedName("id")
    val id:String,
    @SerializedName("total")
    val total:String,
)