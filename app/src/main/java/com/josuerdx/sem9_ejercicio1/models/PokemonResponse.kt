package com.josuerdx.sem9_ejercicio1.models


data class PokemonResponse(
    val results: List<Pokemon>
)

data class Pokemon(
    val name: String,
    val url: String
)
