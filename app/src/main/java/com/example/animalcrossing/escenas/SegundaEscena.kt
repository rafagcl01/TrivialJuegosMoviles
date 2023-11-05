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
import androidx.compose.material3.Surface
import androidx.compose.runtime.getValue
import androidx.compose.runtime.setValue
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController

@ExperimentalMaterial3Api
@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@Composable
fun SegundaEscena(){ //Aqui sera el quiz
    Scaffold {
        
        Contenido()
    }
}

@Composable
fun Contenido(
){
    //Aquí cargamos las preguntas
    val listaPreguntas by remember { mutableStateOf(Preguntas.listaPreguntas.shuffled()) }
    var indicePreguntaActual by remember { mutableStateOf(0) }
    var respuestaSeleccionada by remember { mutableStateOf("") }
    var puntuacion by remember { mutableStateOf(0) }

    if (indicePreguntaActual < 10) {
        val preguntaActual = listaPreguntas[indicePreguntaActual]


        Column(
            modifier = Modifier
            //.fillMaxSize()
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
                    .fillMaxSize()
                    .padding(4.dp)
                    .background(Color.Gray)
            ) {

                preguntaActual.opciones.shuffled().forEach {opcion ->
                    Button(onClick = { respuestaSeleccionada = opcion
                        if (respuestaSeleccionada == preguntaActual.respuestaCorrecta){
                            puntuacion++
                        }
                        indicePreguntaActual++
                    },
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(8.dp)

                    ) {
                        Text(opcion)
                    }
                    }
                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(8.dp),

                ) {
                    Text( text = "Puntuación: $puntuacion",
                        modifier = Modifier
                            .background(Color.White)
                            .padding(start = 16.dp)
                            .padding(8.dp)

                    )

                    Text(text = "${indicePreguntaActual+1}/10",
                        modifier = Modifier
                            .background(Color.White)
                            .padding(end = 16.dp)
                            .padding(8.dp),


                        )


                }

            }
        }
    } else {
        //Pasamos a otra escena
    }
}

@ExperimentalMaterial3Api
@Preview
@Composable
fun Preview() {
    SegundaEscena()
}



