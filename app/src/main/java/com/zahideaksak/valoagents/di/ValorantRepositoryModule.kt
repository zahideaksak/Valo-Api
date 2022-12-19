package com.zahideaksak.valoagents.di

import com.zahideaksak.valoagents.data.repository.ValorantRepository
import com.zahideaksak.valoagents.data.repository.ValorantRepositoryImpl
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ViewModelComponent
import dagger.hilt.android.scopes.ViewModelScoped

@Module
@InstallIn(ViewModelComponent::class)
abstract class ValorantRepositoryModule {

    @Binds
    @ViewModelScoped
    abstract fun bindValorantRepository(valorantRepositoryImpl: ValorantRepositoryImpl): ValorantRepository
}