package com.josuerdx.sem9_ejercicio1.ui.screens

import androidx.compose.material3.Text
import androidx.compose.runtime.Composable

@Composable
fun PokemonDetailScreen(pokemonName: String) {
    Text(text = "Detalles de $pokemonName")
}