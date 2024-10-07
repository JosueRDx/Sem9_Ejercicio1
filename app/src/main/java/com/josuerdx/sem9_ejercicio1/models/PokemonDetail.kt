package com.josuerdx.sem9_ejercicio1.models

data class PokemonDetail(
    val name: String,
    val height: Int,
    val weight: Int,
    val base_experience: Int,
    val abilities: List<Ability>,
    val stats: List<Stat>
)

data class Ability(
    val ability: AbilityDetail
)

data class AbilityDetail(
    val name: String
)

data class Stat(
    val base_stat: Int,
    val stat: StatDetail
)

data class StatDetail(
    val name: String
)