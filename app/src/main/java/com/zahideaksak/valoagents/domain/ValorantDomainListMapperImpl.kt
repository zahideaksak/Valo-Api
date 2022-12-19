package com.zahideaksak.valoagents.domain

import com.zahideaksak.valoagents.data.dto.Data
import javax.inject.Inject

class ValorantDomainListMapperImpl @Inject constructor() : ValorantListMapper<Data, ValorantEntity> {
    override fun map(input: List<Data>?): List<ValorantEntity> {
        return input?.map {
            ValorantEntity(
                id = it.uuid.orEmpty(),
                name = it.displayName.orEmpty(),
                imageUrl = it.displayIcon.orEmpty(),
                superType = it.description.orEmpty()
            )
        } ?: emptyList()
    }
}