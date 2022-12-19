package com.zahideaksak.valoagents.di

import com.zahideaksak.valoagents.domain.GetAgentWithHealthPointUseCase
import com.zahideaksak.valoagents.domain.GetAgentWithHealthPointUseCaseImpl
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ViewModelComponent
import dagger.hilt.android.scopes.ViewModelScoped

@Module
@InstallIn(ViewModelComponent::class)

abstract class UseCaseModule {

    @Binds
    @ViewModelScoped
    abstract fun bindGetPokeUseCase(pokeWithHealthPointUseCaseImpl: GetAgentWithHealthPointUseCaseImpl): GetAgentWithHealthPointUseCase
}