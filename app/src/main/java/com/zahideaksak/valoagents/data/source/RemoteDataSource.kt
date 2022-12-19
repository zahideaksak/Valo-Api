package com.zahideaksak.valoagents.data.source

import com.zahideaksak.valoagents.data.NetworkResponseState
import com.zahideaksak.valoagents.data.dto.Data

interface RemoteDataSource {
    suspend fun getAgentsWithHealthPoint(healthPoint: String): NetworkResponseState<List<Data>>
}