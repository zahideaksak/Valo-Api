package com.zahideaksak.valoagents.di

import com.zahideaksak.valoagents.data.dto.Data
import com.zahideaksak.valoagents.domain.ValorantDomainListMapperImpl
import com.zahideaksak.valoagents.domain.ValorantEntity
import com.zahideaksak.valoagents.domain.ValorantListMapper
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ViewModelComponent
import dagger.hilt.android.scopes.ViewModelScoped

@Module
@InstallIn(ViewModelComponent::class)
abstract class PokeMapperModule {

    @Binds
    @ViewModelScoped
    abstract fun bindValorantDomainListMapper(valorantDomainListMapperImpl: ValorantDomainListMapperImpl): ValorantListMapper<Data, ValorantEntity>

//    @Binds
//    @ViewModelScoped
//    abstract fun bindValorantHomeUiMapper(valorantHomeUiMapperImpl: ValorantHomeUiMapperImpl) :ValorantListMapper<ValorantEntity, HomeUiData>
}