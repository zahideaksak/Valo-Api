package com.zahideaksak.valoagents.data.dto


import com.google.gson.annotations.SerializedName

data class ValorantCardResponse(
    @SerializedName("data")
    val `data`: List<Data>,
    @SerializedName("status")
    val status: Int
)