package com.unsa.lab07lista.data

/**
 * Origen de los apuntes que muestra la app.
 *
 * Por ahora la colección se genera en memoria con datos de prueba del
 * semestre 2026-B. La interfaz solo conoce obtenerApuntes(), así que cuando
 * el proyecto final pase a persistencia (Room o un servicio remoto) bastará
 * con cambiar el cuerpo de esa función, sin tocar ningún composable.
 */
object ApuntesRepositorio {

    private const val NUEVAS_PLATAFORMAS = "Desarrollo de Nuevas Plataformas"
    private const val INTELIGENCIA_ARTIFICIAL = "Inteligencia Artificial"
    private const val REDES = "Redes y Comunicaciones"
    private const val SOFTWARE = "Ingeniería de Software"
    private const val SEGURIDAD = "Seguridad Informática"
    private const val PROYECTOS = "Gestión de Proyectos de TI"

    private val apuntes: List<Apunte> = listOf(
        Apunte(1, "Introducción a Jetpack Compose", NUEVAS_PLATAFORMAS, "Lucía Mamani", 1, 12,
            "Funciones composables, recomposición y diferencias con el sistema de vistas XML.",
            TipoApunte.RESUMEN, "31/08/2026"),
        Apunte(2, "Row, Column y Box con ejemplos", NUEVAS_PLATAFORMAS, "Diego Quispe", 3, 8,
            "Ejercicios de distribución con pesos, alineación y espaciado entre elementos.",
            TipoApunte.EJERCICIOS, "14/09/2026"),
        Apunte(3, "Estado y flujo unidireccional", NUEVAS_PLATAFORMAS, "Lucía Mamani", 5, 15,
            "remember, rememberSaveable y elevación de estado con ejemplos de formularios.",
            TipoApunte.DIAPOSITIVAS, "28/09/2026"),
        Apunte(4, "Canvas y animaciones simples", NUEVAS_PLATAFORMAS, "Jeanpiero Huamani", 8, 10,
            "Dibujo de formas, animateFloatAsState y transiciones controladas por estado.",
            TipoApunte.LABORATORIO, "19/10/2026"),
        Apunte(5, "Búsqueda informada: A* y heurísticas", INTELIGENCIA_ARTIFICIAL, "Andrea Ccama", 2, 18,
            "Comparación entre búsqueda en anchura, voraz y A* con heurísticas admisibles.",
            TipoApunte.RESUMEN, "07/09/2026"),
        Apunte(6, "Práctica calificada 1 resuelta", INTELIGENCIA_ARTIFICIAL, "Renato Flores", 4, 6,
            "Solución comentada de los cuatro problemas de la primera práctica calificada.",
            TipoApunte.EXAMEN, "21/09/2026"),
        Apunte(7, "Regresión lineal y logística", INTELIGENCIA_ARTIFICIAL, "Andrea Ccama", 6, 22,
            "Función de costo, descenso de gradiente y métricas de clasificación.",
            TipoApunte.DIAPOSITIVAS, "05/10/2026"),
        Apunte(8, "Redes neuronales con Keras", INTELIGENCIA_ARTIFICIAL, "Mauricio Apaza", 9, 14,
            "Guía paso a paso para entrenar una red densa sobre el conjunto MNIST.",
            TipoApunte.LABORATORIO, "22/10/2026"),
        Apunte(9, "Modelo OSI y TCP/IP", REDES, "Valeria Turpo", 1, 9,
            "Capas, protocolos representativos y encapsulamiento de datos.",
            TipoApunte.RESUMEN, "01/09/2026"),
        Apunte(10, "Subneteo VLSM paso a paso", REDES, "Diego Quispe", 3, 16,
            "Veinte ejercicios de división de redes con máscaras de longitud variable.",
            TipoApunte.EJERCICIOS, "15/09/2026"),
        Apunte(11, "Configuración de VLAN en Packet Tracer", REDES, "Valeria Turpo", 5, 11,
            "Creación de VLAN, enlaces troncales y enrutamiento entre VLAN.",
            TipoApunte.LABORATORIO, "29/09/2026"),
        Apunte(12, "Examen parcial 2025-B", REDES, "Renato Flores", 8, 5,
            "Examen parcial del semestre anterior con las respuestas verificadas.",
            TipoApunte.EXAMEN, "16/10/2026"),
        Apunte(13, "Requisitos funcionales y no funcionales", SOFTWARE, "Camila Huanca", 2, 13,
            "Técnicas de elicitación, plantilla IEEE 830 y ejemplos de historias de usuario.",
            TipoApunte.RESUMEN, "08/09/2026"),
        Apunte(14, "Diagramas UML de casos de uso", SOFTWARE, "Jeanpiero Huamani", 4, 9,
            "Actores, relaciones include y extend, y casos resueltos de sistemas académicos.",
            TipoApunte.EJERCICIOS, "22/09/2026"),
        Apunte(15, "Patrones de diseño creacionales", SOFTWARE, "Camila Huanca", 6, 20,
            "Singleton, Factory Method, Builder y Abstract Factory con código en Kotlin.",
            TipoApunte.DIAPOSITIVAS, "06/10/2026"),
        Apunte(16, "Pruebas unitarias con JUnit", SOFTWARE, "Mauricio Apaza", 7, 10,
            "Estructura de una prueba, aserciones y cobertura en proyectos Gradle.",
            TipoApunte.LABORATORIO, "13/10/2026"),
        Apunte(17, "Criptografía simétrica y asimétrica", SEGURIDAD, "Sofía Choque", 2, 17,
            "AES, RSA, intercambio de claves y usos de cada esquema.",
            TipoApunte.RESUMEN, "09/09/2026"),
        Apunte(18, "Ejercicios de cifrado clásico", SEGURIDAD, "Diego Quispe", 3, 7,
            "César, Vigenère y transposición resueltos a mano y en Python.",
            TipoApunte.EJERCICIOS, "16/09/2026"),
        Apunte(19, "OWASP Top 10 explicado", SEGURIDAD, "Sofía Choque", 6, 19,
            "Las diez vulnerabilidades web más críticas con ejemplos y mitigaciones.",
            TipoApunte.DIAPOSITIVAS, "07/10/2026"),
        Apunte(20, "Práctica calificada 2 resuelta", SEGURIDAD, "Renato Flores", 8, 6,
            "Solución de la segunda práctica sobre autenticación y control de acceso.",
            TipoApunte.EXAMEN, "20/10/2026"),
        Apunte(21, "Acta de constitución del proyecto", PROYECTOS, "Lucía Mamani", 1, 8,
            "Plantilla comentada del acta de constitución según la guía PMBOK.",
            TipoApunte.RESUMEN, "02/09/2026"),
        Apunte(22, "Cronograma y ruta crítica", PROYECTOS, "Camila Huanca", 4, 12,
            "Cálculo de holguras y ruta crítica con diagramas de red resueltos.",
            TipoApunte.EJERCICIOS, "23/09/2026"),
        Apunte(23, "Scrum en la práctica", PROYECTOS, "Mauricio Apaza", 7, 14,
            "Roles, eventos y artefactos de Scrum aplicados a un proyecto de curso.",
            TipoApunte.DIAPOSITIVAS, "14/10/2026"),
        Apunte(24, "Examen parcial 2025-B", PROYECTOS, "Valeria Turpo", 9, 4,
            "Preguntas del parcial anterior sobre alcance, cronograma y costos.",
            TipoApunte.EXAMEN, "21/10/2026"),
    )

    /** Todos los apuntes, ordenados por id. */
    fun obtenerApuntes(): List<Apunte> = apuntes
}
