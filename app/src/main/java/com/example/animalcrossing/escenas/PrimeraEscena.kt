package com.example.animalcrossing.escenas

import android.annotation.SuppressLint
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource

import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp

import androidx.navigation.NavController
import androidx.room.Room

import com.example.animalcrossing.Navegacion.NavegacionEscenas

import com.example.animalcrossing.Data.DatabaseViewModel
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.animalcrossing.Data.BaseDeDatos
import com.example.animalcrossing.R


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

    val miColor = Color(112,129,94,255)

    Column (
        modifier = Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Image(
            painter = painterResource(id = R.drawable.animalcrossingquizzpic),
            contentDescription = "Icono del menú" //
        )
        //Text(text = "Animal Crossing Quiz")

        Button(onClick = { controladorNavegacion.navigate(route=NavegacionEscenas.SegundaEscena.route)},
            colors = ButtonDefaults.buttonColors(
                containerColor = miColor
            )
        ) {
            Text(text = "Jugar")
        }
        if (data.jugadorDao().getNumActivePlayer() > 0) {
            val activePlayer:String
            activePlayer = data.jugadorDao().getActivePlayer()
            Text(text = "Bienvenido " + activePlayer)
            Button(onClick = {
                //quitar el activeplayer
                data.jugadorDao().setPlayerActiveState(newName = activePlayer, state = false)
                controladorNavegacion.navigate(route = NavegacionEscenas.PrimeraEscena.route)},
                colors = ButtonDefaults.buttonColors(
                    containerColor = miColor
                )
            )

            {
                Text(text = "Cerrar Sesion")
            }
            Button(onClick = {
                controladorNavegacion.navigate(route = NavegacionEscenas.TerceraEscena.route)},
                colors = ButtonDefaults.buttonColors(
                    containerColor = miColor
                )
            )
            {
                Text(text = "Datos personales y ranking")
            }

        } else {
            Button(onClick = { controladorNavegacion.navigate(route = NavegacionEscenas.IniciarSesionEscena.route) },
                colors = ButtonDefaults.buttonColors(
                    containerColor = miColor
                )
            ) {
                Text(text = "Iniciar Sesion")
                }

            }
        }
}


