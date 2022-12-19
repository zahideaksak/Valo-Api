package com.zahideaksak.valoagents.data.source

import com.zahideaksak.valoagents.data.NetworkResponseState
import com.zahideaksak.valoagents.data.api.ValorantApi
import com.zahideaksak.valoagents.data.dto.Data
import com.zahideaksak.valoagents.utility.addSearchPrefix
import javax.inject.Inject

class RemoteDataSourceImpl @Inject constructor(private val valorantApi: ValorantApi) :
    RemoteDataSource {
    override suspend fun getAgentsWithHealthPoint(healthPoint: String): NetworkResponseState<List<Data>> =
        try {
            val response =
                valorantApi.getAgentsWithHealthPoint(healthPoint.addSearchPrefix(KEY_GTE_PREFIX))
            NetworkResponseState.Success(response.data)
        } catch (e: Exception) {
            NetworkResponseState.Error(e)
        }

    companion object {
        private const val KEY_GTE_PREFIX = "gte"
    }

}