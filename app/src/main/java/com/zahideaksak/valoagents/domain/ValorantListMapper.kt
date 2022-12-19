package com.zahideaksak.valoagents.domain

interface ValorantListMapper<I, O> : ValorantMapper<List<I>, List<O>>

interface ValorantMapper<I, O> {
    fun map(input: I?): O
}
