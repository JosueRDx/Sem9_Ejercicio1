package com.josuerdx.sem9_ejercicio1.network

import com.josuerdx.sem9_ejercicio1.models.PokemonResponse
import retrofit2.http.GET
import retrofit2.http.Query
import com.josuerdx.sem9_ejercicio1.models.PokemonDetail
import retrofit2.http.Path

interface ApiService {
    @GET("pokemon")
    suspend fun getPokemons(
        @Query("limit") limit: Int,
        @Query("offset") offset: Int
    ): PokemonResponse

    @GET("pokemon/{name}")
    suspend fun getPokemonDetails(
        @Path("name") name: String
    ): PokemonDetail
}