package com.josuerdx.sem9_ejercicio1.ui.screens

import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.remember
import androidx.navigation.NavHostController
import com.josuerdx.sem9_ejercicio1.models.Pokemon
import com.josuerdx.sem9_ejercicio1.network.RetrofitInstance
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

@Composable
fun PokemonListScreen(navController: NavHostController) {
    val pokemons = remember { mutableStateListOf<Pokemon>() }

    LaunchedEffect(Unit) {
        CoroutineScope(Dispatchers.IO).launch {
            val response = RetrofitInstance.api.getPokemons(100, 0)
            pokemons.addAll(response)
        }
    }

    LazyColumn {
        items(pokemons) { pokemon ->
            Text(text = pokemon.name)
        }
    }
}