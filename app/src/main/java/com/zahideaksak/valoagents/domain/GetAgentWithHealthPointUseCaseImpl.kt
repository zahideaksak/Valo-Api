package com.zahideaksak.valoagents.domain

import com.zahideaksak.valoagents.data.NetworkResponseState
import com.zahideaksak.valoagents.data.dto.Data
import com.zahideaksak.valoagents.data.repository.ValorantRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import javax.inject.Inject

class GetAgentWithHealthPointUseCaseImpl @Inject constructor(
    private val valorantRepository: ValorantRepository,
    private val valorantListMapper: ValorantListMapper<Data, ValorantEntity>,
) : GetAgentWithHealthPointUseCase {
    override fun invoke(healthPoint: String): Flow<NetworkResponseState<List<ValorantEntity>>> =
        flow {
            emit(NetworkResponseState.Loading)
            when (val response = valorantRepository.getAgentsWithHealtPoint(healthPoint)) {
                is NetworkResponseState.Error -> emit(response)
                NetworkResponseState.Loading -> Unit
                is NetworkResponseState.Success -> emit(NetworkResponseState.Success(
                    valorantListMapper.map(response.result)))
            }
        }

}