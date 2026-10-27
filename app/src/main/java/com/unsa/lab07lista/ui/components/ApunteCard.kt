package com.unsa.lab07lista.ui.components

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.unsa.lab07lista.data.Apunte
import com.unsa.lab07lista.data.TipoApunte
import com.unsa.lab07lista.ui.theme.IDNP_lab_07Theme

/**
 * Composable reutilizable para representar un registro de [Apunte]
 * dentro de la lista dinámica.
 */
@Composable
fun ApunteCard(
    apunte: Apunte,
    modifier: Modifier = Modifier,
) {
    Card(
        modifier = modifier.fillMaxWidth(),
        shape = RoundedCornerShape(12.dp),
        colors = CardDefaults.cardColors(
            containerColor = Color.White,
        ),
        elevation = CardDefaults.cardElevation(
            defaultElevation = 2.dp,
        ),
    ) {
        Column(
            modifier = Modifier.padding(16.dp),
        ) {
            // Fila superior: Tipo de apunte y Semana
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceBetween,
                verticalAlignment = Alignment.CenterVertically,
            ) {
                TipoBadge(tipo = apunte.tipo)

                Surface(
                    shape = RoundedCornerShape(16.dp),
                    color = MaterialTheme.colorScheme.primaryContainer,
                ) {
                    Text(
                        text = "Semana ${apunte.semana}",
                        modifier = Modifier.padding(horizontal = 10.dp, vertical = 4.dp),
                        style = MaterialTheme.typography.labelMedium,
                        color = MaterialTheme.colorScheme.onPrimaryContainer,
                        fontWeight = FontWeight.SemiBold,
                    )
                }
            }

            Spacer(modifier = Modifier.height(8.dp))

            // Curso
            Text(
                text = apunte.curso,
                style = MaterialTheme.typography.labelLarge,
                color = MaterialTheme.colorScheme.primary,
                fontWeight = FontWeight.Bold,
            )

            Spacer(modifier = Modifier.height(4.dp))

            // Título
            Text(
                text = apunte.titulo,
                style = MaterialTheme.typography.titleMedium,
                fontWeight = FontWeight.Bold,
                color = MaterialTheme.colorScheme.onBackground,
            )

            Spacer(modifier = Modifier.height(6.dp))

            // Descripción
            Text(
                text = apunte.descripcion,
                style = MaterialTheme.typography.bodyMedium,
                color = MaterialTheme.colorScheme.onSurfaceVariant,
                maxLines = 3,
                overflow = TextOverflow.Ellipsis,
            )

            Spacer(modifier = Modifier.height(12.dp))

            // Fila inferior: Autor, Páginas y Fecha
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceBetween,
                verticalAlignment = Alignment.CenterVertically,
            ) {
                Column {
                    Text(
                        text = "Por: ${apunte.autor}",
                        style = MaterialTheme.typography.bodySmall,
                        fontWeight = FontWeight.Medium,
                        color = MaterialTheme.colorScheme.onBackground,
                    )
                    Text(
                        text = apunte.fechaPublicacion,
                        style = MaterialTheme.typography.labelSmall,
                        color = MaterialTheme.colorScheme.onSurfaceVariant,
                    )
                }

                Surface(
                    shape = RoundedCornerShape(8.dp),
                    color = MaterialTheme.colorScheme.outlineVariant.copy(alpha = 0.5f),
                ) {
                    Text(
                        text = "${apunte.paginas} págs.",
                        modifier = Modifier.padding(horizontal = 8.dp, vertical = 4.dp),
                        style = MaterialTheme.typography.labelSmall,
                        color = MaterialTheme.colorScheme.onSurfaceVariant,
                        fontWeight = FontWeight.Medium,
                    )
                }
            }
        }
    }
}

/**
 * Insignia visual que identifica el tipo de apunte con un color diferenciado.
 */
@Composable
private fun TipoBadge(tipo: TipoApunte) {
    val (backgroundColor, contentColor) = when (tipo) {
        TipoApunte.RESUMEN -> Color(0xFFDBEAFE) to Color(0xFF1E40AF)
        TipoApunte.EJERCICIOS -> Color(0xFFDCFCE7) to Color(0xFF166534)
        TipoApunte.EXAMEN -> Color(0xFFFEE2E2) to Color(0xFF991B1B)
        TipoApunte.DIAPOSITIVAS -> Color(0xFFF3E8FF) to Color(0xFF6B21A8)
        TipoApunte.LABORATORIO -> Color(0xFFFEF3C7) to Color(0xFF92400E)
    }

    Surface(
        shape = RoundedCornerShape(6.dp),
        color = backgroundColor,
    ) {
        Text(
            text = tipo.etiqueta,
            modifier = Modifier.padding(horizontal = 8.dp, vertical = 4.dp),
            style = MaterialTheme.typography.labelSmall,
            color = contentColor,
            fontWeight = FontWeight.Bold,
        )
    }
}

@Preview(showBackground = true)
@Composable
private fun ApunteCardPreview() {
    IDNP_lab_07Theme {
        ApunteCard(
            apunte = Apunte(
                id = 1,
                titulo = "Introducción a Jetpack Compose",
                curso = "Desarrollo de Nuevas Plataformas",
                autor = "Lucía Mamani",
                semana = 1,
                paginas = 12,
                descripcion = "Funciones composables, recomposición y diferencias con el sistema de vistas XML.",
                tipo = TipoApunte.RESUMEN,
                fechaPublicacion = "31/08/2026",
            ),
            modifier = Modifier.padding(16.dp),
        )
    }
}
