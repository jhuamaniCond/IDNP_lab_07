package com.unsa.lab07lista.ui.screens

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.unsa.lab07lista.data.Apunte
import com.unsa.lab07lista.data.ApuntesRepositorio
import com.unsa.lab07lista.ui.components.ApunteCard
import com.unsa.lab07lista.ui.theme.IDNP_lab_07Theme

/**
 * Pantalla principal que muestra la lista de apuntes utilizando un [LazyColumn],
 * incorporando selección interactiva, separación visual y jerarquía tipográfica.
 */
@Composable
fun ApuntesListaScreen(
    modifier: Modifier = Modifier,
    apuntes: List<Apunte> = ApuntesRepositorio.obtenerApuntes(),
    contentPadding: PaddingValues = PaddingValues(16.dp),
) {
    var selectedApunteId by remember { mutableStateOf<Int?>(null) }
    val apunteSeleccionado = apuntes.find { it.id == selectedApunteId }

    LazyColumn(
        modifier = modifier.fillMaxSize(),
        contentPadding = contentPadding,
        verticalArrangement = Arrangement.spacedBy(12.dp),
    ) {
        item {
            HeaderSeccion(totalRegistros = apuntes.size)
        }

        // Banner informativo cuando hay un apunte seleccionado (Acción de selección)
        if (apunteSeleccionado != null) {
            item {
                Card(
                    modifier = Modifier.fillMaxWidth(),
                    colors = CardDefaults.cardColors(
                        containerColor = MaterialTheme.colorScheme.primaryContainer,
                    ),
                    shape = androidx.compose.foundation.shape.RoundedCornerShape(8.dp),
                ) {
                    Column(
                        modifier = Modifier.padding(12.dp),
                    ) {
                        Text(
                            text = "Apunte seleccionado:",
                            style = MaterialTheme.typography.labelSmall,
                            color = MaterialTheme.colorScheme.onPrimaryContainer,
                            fontWeight = FontWeight.Bold,
                        )
                        Spacer(modifier = Modifier.height(2.dp))
                        Text(
                            text = apunteSeleccionado.titulo,
                            style = MaterialTheme.typography.bodyMedium,
                            color = MaterialTheme.colorScheme.onPrimaryContainer,
                            fontWeight = FontWeight.SemiBold,
                        )
                        Text(
                            text = "Curso: ${apunteSeleccionado.curso} (${apunteSeleccionado.paginas} págs.)",
                            style = MaterialTheme.typography.bodySmall,
                            color = MaterialTheme.colorScheme.onPrimaryContainer.copy(alpha = 0.8f),
                        )
                    }
                }
            }
        }

        items(
            items = apuntes,
            key = { apunte -> apunte.id },
        ) { apunte ->
            ApunteCard(
                apunte = apunte,
                isSelected = apunte.id == selectedApunteId,
            ) {
                selectedApunteId = if (selectedApunteId == apunte.id) null else apunte.id
            }
        }
    }
}

/**
 * Encabezado simple que muestra el título de la sección y la cantidad de elementos.
 */
@Composable
private fun HeaderSeccion(
    totalRegistros: Int,
    modifier: Modifier = Modifier,
) {
    Row(
        modifier = modifier
            .fillMaxWidth()
            .padding(vertical = 4.dp),
        horizontalArrangement = Arrangement.SpaceBetween,
        verticalAlignment = Alignment.CenterVertically,
    ) {
        Column {
            Text(
                text = "Apuntes Universitarios",
                style = MaterialTheme.typography.titleLarge,
                fontWeight = FontWeight.Bold,
                color = MaterialTheme.colorScheme.onBackground,
            )
            Text(
                text = "Semestre 2026-B • Toque una tarjeta para seleccionar",
                style = MaterialTheme.typography.bodySmall,
                color = MaterialTheme.colorScheme.onSurfaceVariant,
            )
        }

        Text(
            text = "$totalRegistros reg.",
            style = MaterialTheme.typography.labelMedium,
            fontWeight = FontWeight.SemiBold,
            color = MaterialTheme.colorScheme.primary,
        )
    }
}

@Preview(showBackground = true)
@Composable
private fun ApuntesListaScreenPreview() {
    IDNP_lab_07Theme {
        ApuntesListaScreen()
    }
}
