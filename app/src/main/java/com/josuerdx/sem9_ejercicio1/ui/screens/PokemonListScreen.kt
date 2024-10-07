package com.josuerdx.sem9_ejercicio1.ui.screens

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Card
import androidx.compose.material3.Text
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import com.josuerdx.sem9_ejercicio1.models.Pokemon
import com.josuerdx.sem9_ejercicio1.network.RetrofitInstance
import com.josuerdx.sem9_ejercicio1.ui.components.PokemonCard
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

@Composable
fun PokemonListScreen(navController: NavHostController) {
    val pokemons = remember { mutableStateListOf<Pokemon>() }

    LaunchedEffect(Unit) {
        CoroutineScope(Dispatchers.IO).launch {
            val response = RetrofitInstance.api.getPokemons(100, 0)
            pokemons.addAll(response.results)
        }
    }

    // Column para tener márgenes generales en la lista
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp)
    ) {
        Text(
            text = "Pokémon List",
            style = MaterialTheme.typography.headlineLarge,
            modifier = Modifier
                .align(Alignment.CenterHorizontally)
                .padding(bottom = 16.dp) // Espacio entre el título y la lista
        )

        LazyColumn(
            verticalArrangement = Arrangement.spacedBy(8.dp) // Espacio entre cada item
        ) {
            items(pokemons) { pokemon ->
                PokemonCard(
                    name = pokemon.name,
                    onClick = { navController.navigate("pokemon_detail/${pokemon.name}") }
                )
            }
        }
    }
}
