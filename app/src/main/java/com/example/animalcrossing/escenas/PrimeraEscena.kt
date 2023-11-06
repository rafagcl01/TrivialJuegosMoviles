package com.example.animalcrossing.escenas

import android.annotation.SuppressLint
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Button
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview

import androidx.navigation.NavController
import androidx.room.Room

import com.example.animalcrossing.Navegacion.NavegacionEscenas

import com.example.animalcrossing.Data.DatabaseViewModel
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.animalcrossing.Data.BaseDeDatos


@ExperimentalMaterial3Api
@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@Composable

fun PrimeraEscena(controladorNavegacion: NavController, db:BaseDeDatos){

    val databaseViewModel: DatabaseViewModel = viewModel()
   // val db = databaseViewModel.datab

    Scaffold {
        Escena1Cuerpo(controladorNavegacion,db)
    }
}

@Composable
fun Escena1Cuerpo(controladorNavegacion: NavController, data: BaseDeDatos){



    Column (
        modifier = Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(text = "Animal Crossing Quiz")
        Button(onClick = { controladorNavegacion.navigate(route = NavegacionEscenas.SegundaEscena.route) }) {
            Text(text = "Jugar")
        }
        if (data.jugadorDao().getNumActivePlayer() > 0) {
            val activePlayer:String
            activePlayer = data.jugadorDao().getActivePlayer()
            Text(text = "Bienvenido " + activePlayer)
            Button(onClick = {
                //quitar el activeplayer
                data.jugadorDao().setPlayerActiveState(newName = activePlayer, state = false)
                controladorNavegacion.navigate(route = NavegacionEscenas.PrimeraEscena.route)})
            {
                Text(text = "Cerrar Sesion")
            }
        } else {
            Button(onClick = { controladorNavegacion.navigate(route = NavegacionEscenas.IniciarSesionEscena.route) }) {
                Text(text = "Iniciar Sesion")
                }

            }
        }
}


