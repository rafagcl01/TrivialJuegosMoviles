package com.example.animalcrossing.Navegacion

import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.animalcrossing.escenas.IniciarSesionEscena
import com.example.animalcrossing.escenas.PrimeraEscena
import com.example.animalcrossing.escenas.SegundaEscena
import com.example.animalcrossing.escenas.TerceraEscena


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun Navegacion(){
    val controladorNavegacion = rememberNavController()
    NavHost(navController = controladorNavegacion, startDestination = NavegacionEscenas.PrimeraEscena.route){
        composable(route = NavegacionEscenas.PrimeraEscena.route ){
            PrimeraEscena(controladorNavegacion)
        }
        composable(route = NavegacionEscenas.SegundaEscena.route ){
            SegundaEscena(controladorNavegacion)
        }
        composable(route = NavegacionEscenas.TerceraEscena.route ){
            TerceraEscena(controladorNavegacion)
        }
        composable(route = NavegacionEscenas.IniciarSesionEscena.route ){
            IniciarSesionEscena(controladorNavegacion)
        }

    }



        




}


