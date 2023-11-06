package com.example.animalcrossing.escenas
import com.example.animalcrossing.Data.Preguntas

import androidx.compose.runtime.Composable


import androidx.compose.material3.Button
import android.annotation.SuppressLint
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize

import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.runtime.remember
import androidx.compose.runtime.mutableStateOf

import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Surface
import androidx.compose.runtime.getValue
import androidx.compose.runtime.setValue
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.example.animalcrossing.Data.BaseDeDatos
import com.example.animalcrossing.Navegacion.NavegacionEscenas

@ExperimentalMaterial3Api
@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@Composable
fun SegundaEscena(controladorNavegacion: NavController, db:BaseDeDatos){ //Aqui sera el quiz
    Scaffold {

        Escena2Cuerpo(controladorNavegacion,db)
    }
}

@Composable
fun Escena2Cuerpo(controladorNavegacion: NavController, data:BaseDeDatos){
    //Aquí cargamos las preguntas
    val listaPreguntas by remember { mutableStateOf(Preguntas.listaPreguntas.shuffled()) }
    var indicePreguntaActual by remember { mutableStateOf(0) }
    var respuestaSeleccionada by remember { mutableStateOf("") }
    var puntuacion by remember { mutableStateOf(0) }
    var respuestaSeleccionadaEnabled by remember { mutableStateOf(true) }
    var mostrarMensajeEnhorabuena by remember { mutableStateOf(false) }

    val miColor = Color(112,129,94,255)
    val miColor2 = Color(190,140,104,255)

    if (indicePreguntaActual < 10) {

        val preguntaActual = listaPreguntas[indicePreguntaActual]
        if (respuestaSeleccionadaEnabled) { // Reorganizar opciones solo si se permite la selección
            preguntaActual.opciones.shuffled()
        }

        Column(
            modifier = Modifier
            .fillMaxSize()
        )
        {
            // Bloque blanco
            Column(
                modifier = Modifier
                    .background(Color.White)
                    .fillMaxWidth()
                    .padding(5.dp)

            ) {

                Text(
                    text = preguntaActual.pregunta,
                    modifier = Modifier
                        .fillMaxWidth()
                )
            }
            Column(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(4.dp)
                    .background(miColor2)
            ) {

                preguntaActual.opciones.forEach {opcion ->
                    Button(onClick = {
                        if (respuestaSeleccionadaEnabled) { // Comprobar si la opción se puede marcar
                        respuestaSeleccionada = opcion
                        respuestaSeleccionadaEnabled = false // Deshabilitar otras opciones



                        if (respuestaSeleccionada == preguntaActual.respuestaCorrecta) {
                            puntuacion++
                            mostrarMensajeEnhorabuena = true

                        }
                    }
                    },
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(8.dp),
                        enabled = respuestaSeleccionadaEnabled,
                        colors = ButtonDefaults.buttonColors(
                            containerColor = miColor
                        )

                    ) {
                        Text(opcion)
                    }
                }
            }

            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(8.dp),

                ) {
                Text( text = "Puntuación: $puntuacion",
                    modifier = Modifier
                        .padding(start = 16.dp)
                        .padding(8.dp)
                )

                Text(text = "${indicePreguntaActual+1}/10",
                    modifier = Modifier
                        .padding(end = 16.dp)
                        .padding(8.dp),
                )

                Button(onClick = {
                    respuestaSeleccionadaEnabled = true // Habilitar para la siguiente pregunta
                    indicePreguntaActual++
                    respuestaSeleccionada = ""
                    mostrarMensajeEnhorabuena = false
                },
                    colors = ButtonDefaults.buttonColors(
                        containerColor = miColor
                    )
                ) {
                    Text(text = "Sig pregunta")
                }

            }

            Column {
                if(mostrarMensajeEnhorabuena == true && respuestaSeleccionadaEnabled==false){
                    Text(text = "¡Enhorabuena!",
                        color = Color.Green,
                        modifier = Modifier
                            .padding(8.dp))

                }
                if(mostrarMensajeEnhorabuena == false && respuestaSeleccionadaEnabled==false){
                    Text(text = "La respuesta correcta es: ${preguntaActual.respuestaCorrecta}",
                        color = Color.Red,
                        modifier = Modifier
                            .padding(8.dp))

                }
            }

            }
        } else {
            if(data.jugadorDao().getNumActivePlayer() > 0){
                val gamer = data.jugadorDao().getActivePlayerData()
                data.jugadorDao().setPlayerLastScore(puntuacion, gamer.nombre)
                if(gamer.maxScore < puntuacion) {
                    data.jugadorDao().setPlayerMaxScore(puntuacion, gamer.nombre)
                }
                controladorNavegacion.navigate(route= NavegacionEscenas.TerceraEscena.route)
            }else{
                controladorNavegacion.navigate(route= NavegacionEscenas.PrimeraEscena.route)
            }

    }
}





//@ExperimentalMaterial3Api
//@Preview
//@Composable
//fun Preview() {
//    SegundaEscena()
//}
