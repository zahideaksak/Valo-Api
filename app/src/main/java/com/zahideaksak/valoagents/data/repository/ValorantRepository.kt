package com.zahideaksak.valoagents.data.repository

import com.zahideaksak.valoagents.data.NetworkResponseState
import com.zahideaksak.valoagents.data.dto.Data

interface ValorantRepository {
    suspend fun getAgentsWithHealtPoint(healthPoint: String): NetworkResponseState<List<Data>>
}