package com.unsa.lab07lista.ui.screens

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
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
 * Pantalla principal que muestra la lista de apuntes utilizando un [LazyColumn].
 */
@Composable
fun ApuntesListaScreen(
    modifier: Modifier = Modifier,
    apuntes: List<Apunte> = ApuntesRepositorio.obtenerApuntes(),
    contentPadding: PaddingValues = PaddingValues(16.dp),
) {
    LazyColumn(
        modifier = modifier.fillMaxSize(),
        contentPadding = contentPadding,
        verticalArrangement = Arrangement.spacedBy(12.dp),
    ) {
        item {
            HeaderSeccion(totalRegistros = apuntes.size)
        }

        items(
            items = apuntes,
            key = { apunte -> apunte.id },
        ) { apunte ->
            ApunteCard(apunte = apunte)
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
                text = "Semestre 2026-B",
                style = MaterialTheme.typography.bodySmall,
                color = MaterialTheme.colorScheme.onSurfaceVariant,
            )
        }

        Text(
            text = "$totalRegistros registros",
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
