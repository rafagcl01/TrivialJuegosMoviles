package com.example.animalcrossing.Data

data class Preguntas(
    val pregunta: String,
    val opciones: List<String>,
    val respuestaCorrecta: String ){

    companion object{
        val listaPreguntas = listOf(
            Preguntas(
                pregunta = "¿Como se llama el sucio capitalista que no para de meterte en hipotecas?",
                opciones = listOf("Tom Nook","Canela","Albino","Pepita"),
                respuestaCorrecta = "Tom Nook"

            ),
            Preguntas(
                pregunta = "¿Cuantas habitaciones tiene la casa sin haber pagado la hipoteca?",
                opciones = listOf("1","2","3","4"),
                respuestaCorrecta = "1"
            )
        )
    }
}

