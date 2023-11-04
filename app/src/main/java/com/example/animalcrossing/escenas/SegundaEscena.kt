package com.example.animalcrossing.escenas

import androidx.compose.runtime.Composable

import android.annotation.SuppressLint
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Button
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview

import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Surface
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
fun Contenido(){
    Column(
        modifier = Modifier
            //.fillMaxSize()
    )
    {
        // Bloque blanco
        Column(
            modifier = Modifier
                .background(Color.White)
                //.fillMaxWidth()
                .height(30.dp) // Altura superior
        ) {

            Text(
                text = "Pregunta",
                modifier = Modifier
                    .fillMaxWidth()
            )
        }

        // Botones con las respuestas
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .fillMaxSize()
                .padding(4.dp)
                .background(Color.Gray)
        ) {
            Button(
                onClick = {  },
                modifier = Modifier
                    .fillMaxWidth() // Ocupar todo el ancho de la pantalla
                    .padding(8.dp)
            ) {
                Text("Opcion 1")
            }
            Button(
                onClick = { },
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(8.dp)
            ) {
                Text("Opcion 2")
            }
            Button(
                onClick = {  },
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(8.dp)
            ) {
                Text("Opcion 3")
            }
            Button(
                onClick = { },
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(8.dp)
            ) {
                Text("Opcion 4")
            }
        }
    }

}

@ExperimentalMaterial3Api
@Preview
@Composable
fun Preview() {
    SegundaEscena()
}



