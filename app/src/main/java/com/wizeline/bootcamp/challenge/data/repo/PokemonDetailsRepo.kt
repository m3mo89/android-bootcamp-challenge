package com.wizeline.bootcamp.challenge.data.repo

import com.wizeline.bootcamp.challenge.data.services.PokemonDetailsService
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class PokemonDetailsRepo @Inject constructor(
    private val pokemonDetailsService: PokemonDetailsService
) {
    // Implement the getPokemonDetails(id) method
    suspend fun getPokemonDetails(id: Long) =
        pokemonDetailsService.getPokemonDetails(id)
}
