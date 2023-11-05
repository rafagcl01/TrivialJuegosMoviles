package com.example.animalcrossing.escenas

import android.annotation.SuppressLint
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.NavController
import androidx.room.Room
import com.example.animalcrossing.Data.PlayerDatabase
import com.example.animalcrossing.Navegacion.NavegacionEscenas

@ExperimentalMaterial3Api
@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@Composable
fun PrimeraEscena(controladorNavegacion: NavController){
    Scaffold {
        Escena1Cuerpo(controladorNavegacion)
    }
}

@Composable
fun Escena1Cuerpo(controladorNavegacion: NavController){
    Column (
        modifier = Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ){
        Text(text = "Animal Crossing Quiz")
        Button(onClick = { controladorNavegacion.navigate(route=NavegacionEscenas.SegundaEscena.route)},
            colors = ButtonDefaults.buttonColors(
                containerColor = Color.Red,
                contentColor = Color.White
            )
            ) {
            Text(text = "Jugar")
        }
        ////////////////////////////// AÑADIR BOTON para ir a escena de iniciar sesion
    }

   // val context = LocalContext.current
   // val database = Room.databaseBuilder(
   //     context,
   //     PlayerDatabase::class.java, "player_database"
   // ).build()

   // val playerDao = database.playerDao()
}

//@ExperimentalMaterial3Api
//@OptIn(ExperimentalMaterial3Api::class)
//@Preview
//@Composable
//fun DefaultPreview(){
//    PrimeraEscena()
//}