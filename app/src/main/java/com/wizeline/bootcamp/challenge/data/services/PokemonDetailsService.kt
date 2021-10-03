package com.wizeline.bootcamp.challenge.data.services

import com.wizeline.bootcamp.challenge.data.mock.PokemonDetails
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Path

interface PokemonDetailsService {
    // Define your method to the the 'pokemon/{id}' endpoint
    @GET("pokemon/{id}")
    suspend fun getPokemonDetails(@Path("id") id: Long) : Response<PokemonDetails>
}