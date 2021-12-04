package com.yaniramonsalve.baricharaturistica.model


import com.google.gson.annotations.SerializedName
import java.io.Serializable

data class BaricharaItemItem(
    @SerializedName("descripcionLarga")
    val descripcionLarga: String,
    @SerializedName("introduction")
    val introduction: String,
    @SerializedName("name")
    val name: String,
    @SerializedName("urlPicture")
    val urlPicture: String,
    @SerializedName("valoration")
    val valoration: Double
): Serializable