package com.example.animalcrossing.escenas

import android.annotation.SuppressLint
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.NavController


@ExperimentalMaterial3Api
@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@Composable
fun IniciarSesionEscena(controladorNavegacion: NavController){
    Scaffold {

        Inicio(controladorNavegacion)
    }
}


@Composable
fun Inicio(controladorNavegacion: NavController) {
}

@ExperimentalMaterial3Api
@Preview
@Composable
fun sesionPreview(controladorNavegacion: NavController) {
    IniciarSesionEscena(controladorNavegacion)
}