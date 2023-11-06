package com.example.animalcrossing.escenas
//import com.example.animalcrossing.Data.Jugador

import android.annotation.SuppressLint
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.heightIn
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.text.BasicTextField
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.semantics.SemanticsProperties.ImeAction
import androidx.compose.ui.text.input.ImeAction.Companion.Done
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.NavController

import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.animalcrossing.Data.BaseDeDatos
import com.example.animalcrossing.Data.DatabaseViewModel
import com.example.animalcrossing.Data.Jugador
import com.example.animalcrossing.Navegacion.NavegacionEscenas


@ExperimentalMaterial3Api
@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@Composable

fun IniciarSesionEscena(controladorNavegacion: NavController, db:BaseDeDatos){


    val databaseViewModel: DatabaseViewModel = viewModel()
    //val db = databaseViewModel.datab

    Scaffold {

        Inicio(controladorNavegacion,db)
    }
}


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun Inicio(controladorNavegacion: NavController, data: BaseDeDatos) {
    var playerName by remember { mutableStateOf("") }
    val miColor = Color(112,129,94,255)

    Column(
        modifier = Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        TextField(
            value = playerName,
            onValueChange = { playerName = it },
            keyboardOptions = KeyboardOptions.Default.copy(
                imeAction = Done
            ),
            modifier = Modifier
                .fillMaxWidth()
                .heightIn(min = 56.dp)
                .background(Color.Gray)
        )

        Button(
            onClick = {
                if (playerName.isNotEmpty() && data.jugadorDao().getExistingPlayer(playerName) == 0) {
                    var playerId = data.jugadorDao().getNumPlayers()
                    playerId++
                    val newPlayer = Jugador(id = playerId, nombre = playerName, lastScore = 0, maxScore = 0, playerActive = true)
                    data.jugadorDao().insertJugador(newPlayer)
                    playerName = ""
                    controladorNavegacion.navigate(route= NavegacionEscenas.PrimeraEscena.route)
                }
                else if(playerName.isNotEmpty()){
                    data.jugadorDao().setPlayerActiveState(newName = playerName, state = true)
                    controladorNavegacion.navigate(route= NavegacionEscenas.PrimeraEscena.route)
                }
            },
            colors = ButtonDefaults.buttonColors(
                containerColor = miColor
            )
        ) {
            if (playerName.isNotEmpty() && data.jugadorDao().getExistingPlayer(playerName) > 0) {
                Text("Iniciar sesión")
            }else{
                Text("Guardar Jugador")
            }
        }
        Button(onClick = {
            data.jugadorDao().setAllPlayerActiveState(state = false)
            controladorNavegacion.navigate(route=NavegacionEscenas.PrimeraEscena.route)
            },
            colors = ButtonDefaults.buttonColors(
                containerColor = miColor
            )
        ) {
            Text("Continuar sin iniciar sesion")
        }
    }

}

/*
@ExperimentalMaterial3Api
@Preview
@Composable
fun sesionPreview(controladorNavegacion: NavController) {
    IniciarSesionEscena(controladorNavegacion)
}*/