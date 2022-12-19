package com.zahideaksak.valoagents.domain

import com.zahideaksak.valoagents.data.NetworkResponseState
import kotlinx.coroutines.flow.Flow

interface GetAgentWithHealthPointUseCase {
    operator fun invoke(healthPoint: String): Flow<NetworkResponseState<List<ValorantEntity>>>
}