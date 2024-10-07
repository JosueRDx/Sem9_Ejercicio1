package com.josuerdx.sem9_ejercicio1.ui.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.josuerdx.sem9_ejercicio1.models.PokemonDetail
import com.josuerdx.sem9_ejercicio1.network.RetrofitInstance
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

@Composable
fun PokemonDetailScreen(pokemonName: String) {
    var pokemonDetail by remember { mutableStateOf<PokemonDetail?>(null) }
    var isLoading by remember { mutableStateOf(true) }

    LaunchedEffect(pokemonName) {
        CoroutineScope(Dispatchers.IO).launch {
            try {
                val response = RetrofitInstance.api.getPokemonDetails(pokemonName)
                pokemonDetail = response
            } catch (e: Exception) {
                e.printStackTrace() // Maneja el error en caso de que ocurra
            } finally {
                isLoading = false
            }
        }
    }

    // Estructura de la pantalla
    if (isLoading) {
        Box(
            modifier = Modifier.fillMaxSize(),
            contentAlignment = Alignment.Center
        ) {
            CircularProgressIndicator()
        }
    } else {
        pokemonDetail?.let { detail ->
            Column(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(16.dp)
                    .background(Color(0xFFECEFF1)), // Color de fondo suave
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                // Nombre del Pokémon
                Text(
                    text = detail.name.capitalize(),
                    style = MaterialTheme.typography.headlineLarge.copy(
                        fontWeight = FontWeight.Bold
                    ),
                    modifier = Modifier.padding(vertical = 16.dp)
                )

                // Información básica (Altura y Peso)
                Text(
                    text = "Altura: ${detail.height / 10.0} m",
                    style = MaterialTheme.typography.bodyLarge.copy(fontSize = 18.sp)
                )
                Text(
                    text = "Peso: ${detail.weight / 10.0} kg",
                    style = MaterialTheme.typography.bodyLarge.copy(fontSize = 18.sp)
                )

                Spacer(modifier = Modifier.height(16.dp))

                // Tarjeta para habilidades
                Text(
                    text = "Habilidades",
                    style = MaterialTheme.typography.headlineSmall.copy(fontWeight = FontWeight.Bold),
                    modifier = Modifier.padding(vertical = 8.dp)
                )

                LazyColumn {
                    items(detail.abilities) { ability ->
                        Card(
                            shape = RoundedCornerShape(8.dp),
                            modifier = Modifier
                                .fillMaxWidth()
                                .padding(vertical = 4.dp),
                            elevation = CardDefaults.cardElevation(4.dp)
                        ) {
                            Box(modifier = Modifier.padding(16.dp)) {
                                Text(
                                    text = ability.ability.name.capitalize(),
                                    style = MaterialTheme.typography.bodyLarge
                                )
                            }
                        }
                    }
                }

                Spacer(modifier = Modifier.height(16.dp))

                // Tarjeta para estadísticas
                Text(
                    text = "Estadísticas",
                    style = MaterialTheme.typography.headlineSmall.copy(fontWeight = FontWeight.Bold),
                    modifier = Modifier.padding(vertical = 8.dp)
                )

                LazyColumn {
                    items(detail.stats) { stat ->
                        Card(
                            shape = RoundedCornerShape(8.dp),
                            modifier = Modifier
                                .fillMaxWidth()
                                .padding(vertical = 4.dp),
                            elevation = CardDefaults.cardElevation(4.dp)
                        ) {
                            Box(modifier = Modifier.padding(16.dp)) {
                                Text(
                                    text = "${stat.stat.name.capitalize()}: ${stat.base_stat}",
                                    style = MaterialTheme.typography.bodyLarge
                                )
                            }
                        }
                    }
                }
            }
        } ?: run {
            Box(
                modifier = Modifier.fillMaxSize(),
                contentAlignment = Alignment.Center
            ) {
                Text(text = "Detalles no encontrados", style = MaterialTheme.typography.bodyLarge)
            }
        }
    }
}
