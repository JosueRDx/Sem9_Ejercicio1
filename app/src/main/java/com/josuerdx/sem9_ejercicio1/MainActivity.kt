package com.josuerdx.sem9_ejercicio1

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.josuerdx.sem9_ejercicio1.ui.screens.PokemonListScreen
import com.josuerdx.sem9_ejercicio1.ui.theme.Sem9_Ejercicio1Theme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            Sem9_Ejercicio1Theme {
                val navController = rememberNavController()
                NavHost(navController = navController, startDestination = "pokemon_list") {
                    composable("pokemon_list") { PokemonListScreen(navController) }
                    // Aquí se añadirá la pantalla de detalles
            }
        }
    }
}

