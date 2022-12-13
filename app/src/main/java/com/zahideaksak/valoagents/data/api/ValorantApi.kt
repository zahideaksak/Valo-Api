package com.zahideaksak.valoagents.data.api

import com.zahideaksak.valoagents.data.dto.ValorantCardResponse
import retrofit2.http.GET
import retrofit2.http.Query

interface ValorantApi {
    @GET("data")
    fun getAgentsWithHealthPoint(@Query("hp") healthQuery: String): ValorantCardResponse
}