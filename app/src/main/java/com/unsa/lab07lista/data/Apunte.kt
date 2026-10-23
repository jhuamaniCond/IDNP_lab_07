package com.unsa.lab07lista.data

/** Tipo de material de un apunte, con el texto con que se muestra en pantalla. */
enum class TipoApunte(val etiqueta: String) {
    RESUMEN("Resumen"),
    EJERCICIOS("Ejercicios resueltos"),
    EXAMEN("Examen pasado"),
    DIAPOSITIVAS("Diapositivas"),
    LABORATORIO("Guía de laboratorio"),
}

/**
 * Un apunte publicado en CampusDocs: el registro que muestra la lista de la
 * pantalla de inicio y su pantalla de detalle.
 *
 * Los campos titulo, curso, semana, paginas y descripcion son los mismos que
 * pide el formulario «Subir apunte» (Lab 05), de modo que un apunte creado
 * desde el formulario encaja sin conversión en esta lista. id es la clave
 * estable del registro y tipo clasifica el material.
 *
 * Es un modelo de datos puro: no conoce Compose ni cómo se dibuja.
 */
data class Apunte(
    val id: Int,
    val titulo: String,
    val curso: String,
    val autor: String,
    val semana: Int,
    val paginas: Int,
    val descripcion: String,
    val tipo: TipoApunte,
    /** Fecha de publicación en formato dd/MM/aaaa. */
    val fechaPublicacion: String,
)
