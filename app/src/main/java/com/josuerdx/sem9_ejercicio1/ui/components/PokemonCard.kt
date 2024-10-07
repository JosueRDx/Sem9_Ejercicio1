package com.josuerdx.sem9_ejercicio1.ui.components

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun PokemonCard(name: String, onClick: () -> Unit) {
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .clickable(onClick = onClick) // Hacemos la tarjeta clickable
            .padding(8.dp),
        colors = CardDefaults.cardColors(
            containerColor = Color(0xFFFAFAFA) // Un color claro para la tarjeta
        ),
        elevation = CardDefaults.cardElevation(
            defaultElevation = 4.dp // Le damos algo de sombra
        )
    ) {
        Box(
            modifier = Modifier.padding(16.dp),
            contentAlignment = Alignment.CenterStart // Alineamos el texto a la izquierda
        ) {
            Text(
                text = name,
                style = MaterialTheme.typography.bodyLarge.copy(fontSize = 20.sp),
                color = Color.Black // Puedes cambiar el color según el diseño
            )
        }
    }
}
