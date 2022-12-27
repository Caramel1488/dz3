package com.example.dz3.model

import com.google.gson.annotations.SerializedName

data class DetailPhone(
    @SerializedName("id")
    val id:String,
    @SerializedName("title")
    val title:String,
    @SerializedName("CPU")
    val cpu:String?,
    @SerializedName("camera")
    val camera:String?,
    @SerializedName("capacity")
    val capacity:List<Int>?,
    @SerializedName("color")
    val color:List<String>?,
    @SerializedName("images")
    val images:List<String>?,
    @SerializedName("picture")
    val picture:String?,
    @SerializedName("price")
    val price:String?,
    @SerializedName("rating")
    val rating:String?,
    @SerializedName("sd")
    val sd:String?,
    @SerializedName("ssd")
    val ssd:String?,

)