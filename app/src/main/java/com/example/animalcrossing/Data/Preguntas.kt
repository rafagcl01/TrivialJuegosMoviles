package com.example.animalcrossing.Data

data class Preguntas(
    val pregunta: String,
    val opciones: List<String>,
    val respuestaCorrecta: String ){

    companion object{
        val listaPreguntas = listOf(
            Preguntas(
                pregunta = "¿Cuántas mejoras puede llegar a tener la casa?",
                opciones = listOf("3","6","8","10"),
                respuestaCorrecta = "8"
            ),
            Preguntas(
                pregunta = "¿Como se llama el sucio capitalista que no para de meterte en hipotecas?",
                opciones = listOf("Tom Nook","Canela","Albino","Pepita"),
                respuestaCorrecta = "Tom Nook"
            ),
            Preguntas(
                pregunta = "¿Cuál es la última habitacion que consigues con las mejoras de la casa?",
                opciones = listOf("Cocina","Sótano","Segunda planta","Comedor"),
                respuestaCorrecta = "Sótano"
            ),
            Preguntas(
                pregunta = "¿Qué personaje te da información diaria nada más empezar el día?",
                opciones = listOf("Giroide","Totakeke","Tom Nook","Canela"),
                respuestaCorrecta = "Canela"
            ),
            Preguntas(
                pregunta = "¿Cuántas personalidades hay dentro del juego?",
                opciones = listOf("4","8","12","16"),
                respuestaCorrecta = "8"
            ),
            Preguntas(
                pregunta = "¿Cuál de estás NO es una personalidad?",
                opciones = listOf("Gracioso","Gruñon","Dulce","Presumida"),
                respuestaCorrecta = "Gracioso"
            ),
            Preguntas(
                pregunta = "¿Cuándo es mayormente el evento de caza de bichos?",
                opciones = listOf("Primavera","Verano","Otoño","Invierno"),
                respuestaCorrecta = "Verano"
            ),
            Preguntas(
                pregunta = "¿Cuándo es el evento de pesca?",
                opciones = listOf("Primavera y verano","Otoño e invierno","Primavera y otoño","Todas las estaciones"),
                respuestaCorrecta = "Todas las estaciones"
            ),
            Preguntas(
                pregunta = "¿Cuál de estos bichos es el mas caro?",
                opciones = listOf("Tarántula","Escarabajo astado hércules","Mariposa monarca","Abeja"),
                respuestaCorrecta = "Escarabajo astado hércules"
            ),
            Preguntas(
                pregunta = "¿Que ocurre cuando encuentras al fantasma Buh y hablas con él?",
                opciones = listOf("Te asustas","Se asusta","Te persigue","Te regala su esencia"),
                respuestaCorrecta = "Se asusta"
            ),
            Preguntas(
                pregunta = "¿Cuántos fragmentos de esencia del fantasma Buh tienes que recuperar?",
                opciones = listOf("2","3","4","5"),
                respuestaCorrecta = "5"
            ),
            Preguntas(
                pregunta = "¿Qué día de la semana puedes comprar nabos?",
                opciones = listOf("Domingo","Viernes","Miercoles","Lunes"),
                respuestaCorrecta = "Domingo"
            ),
            Preguntas(
                pregunta = "¿Cómo se llama el personaje que visita tu isla y te vende alfombras y papel de pared?",
                opciones = listOf("Alcatifa","Ladino","Leocadio","Teobaldo"),
                respuestaCorrecta = "Alcatifa"
            ),
            Preguntas(
                pregunta = "¿Cómo se llama el personaje que visita tu isla y te vende obras de arte?",
                opciones = listOf("Canela","Ladino","Kamilo","Teobaldo"),
                respuestaCorrecta = "Ladino"
            )
        )
    }
}

