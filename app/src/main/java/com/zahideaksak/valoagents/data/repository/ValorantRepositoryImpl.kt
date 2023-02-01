package com.zahideaksak.valoagents.data.repository

import com.zahideaksak.valoagents.data.NetworkResponseState
import com.zahideaksak.valoagents.data.dto.Data
import com.zahideaksak.valoagents.data.source.RemoteDataSource
import com.zahideaksak.valoagents.di.IoDispatcher
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import javax.inject.Inject

class ValorantRepositoryImpl @Inject constructor(
    private val remoteDataSource: RemoteDataSource,
    @IoDispatcher private val ioDispatcher: CoroutineDispatcher = Dispatchers.IO,
) : ValorantRepository {
    override suspend fun getAgentsWithHealtPoint(healthPoint: String): NetworkResponseState<List<Data>> {
        return withContext(ioDispatcher) {
            try {
                remoteDataSource.getAgentsWithHealthPoint(healthPoint)
            } catch (e: Exception) {
                NetworkResponseState.Error(e)
            }
        }
    }
}