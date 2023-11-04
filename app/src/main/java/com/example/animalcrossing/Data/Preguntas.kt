package com.example.animalcrossing.Data

data class Preguntas(
    val pregunta: String,
    val opciones: List<String>,
    val respuestaCorrecta: String) {
}

val listaPreguntas = listOf(
    Preguntas(
    pregunta = "¿Cuantas habitaciones tiene la casa sin haber pagado la hipoteca?",
    opciones = listOf("1","2","3","4"),
    respuestaCorrecta = "1"
),
    Preguntas(
        pregunta = "¿Como se llama el sucio capitalista que no para de meterte en hipotecas?",
        opciones = listOf("Tom Nook","Canela","Albino","Pepita"),
        respuestaCorrecta = "Tom Nook"
    )

    )