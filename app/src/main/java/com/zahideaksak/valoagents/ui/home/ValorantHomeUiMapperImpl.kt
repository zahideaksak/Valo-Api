package com.zahideaksak.valoagents.ui.home

import com.zahideaksak.valoagents.domain.ValorantEntity
import com.zahideaksak.valoagents.domain.ValorantListMapper
import javax.inject.Inject

class ValorantHomeUiMapperImpl @Inject constructor() :
    ValorantListMapper<ValorantEntity, HomeUiData> {
    override fun map(input: List<ValorantEntity>?): List<HomeUiData> {
        return input?.map {
            HomeUiData(it.name, it.imageUrl)
        } ?: emptyList()
    }
}