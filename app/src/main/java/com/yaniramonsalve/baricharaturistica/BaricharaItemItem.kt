package com.yaniramonsalve.baricharaturistica


import com.google.gson.annotations.SerializedName

data class BaricharaItemItem(
    @SerializedName("introduction")
    val introduction: String,
    @SerializedName("name")
    val name: String,
    @SerializedName("urlPicture")
    val urlPicture: String,
    @SerializedName("valoration")
    val valoration: Double
)