package com.josuerdx.sem9_ejercicio1.network

import com.josuerdx.sem9_ejercicio1.models.Pokemon
import retrofit2.http.GET
import retrofit2.http.Query

interface ApiService {
    @GET("pokemon")
    suspend fun getPokemons(
        @Query("limit") limit: Int,
        @Query("offset") offset: Int
    ): List<Pokemon>
}