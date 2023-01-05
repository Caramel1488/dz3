package com.example.dz3.model

import com.google.gson.annotations.SerializedName

data class CartPhone(
    @SerializedName("id")
    val id:String,
    @SerializedName("title")
    val title:String,
    @SerializedName("images")
    val images:String?,
    @SerializedName("price")
    val price:String?,
)