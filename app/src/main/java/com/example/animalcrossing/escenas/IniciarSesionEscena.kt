package com.example.animalcrossing.escenas

import android.annotation.SuppressLint
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview


@ExperimentalMaterial3Api
@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@Composable
fun IniciarSesionEscena(){
    Scaffold {

        Inicio()
    }
}


@Composable
fun Inicio() {
}

@ExperimentalMaterial3Api
@Preview
@Composable
fun sesionPreview() {
    IniciarSesionEscena()
}