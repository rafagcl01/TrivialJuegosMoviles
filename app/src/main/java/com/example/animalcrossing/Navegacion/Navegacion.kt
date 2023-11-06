package com.example.animalcrossing.Navegacion

import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.runtime.Composable
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.animalcrossing.Data.BaseDeDatos
import com.example.animalcrossing.Data.DatabaseViewModel
import com.example.animalcrossing.escenas.IniciarSesionEscena
import com.example.animalcrossing.escenas.PrimeraEscena
import com.example.animalcrossing.escenas.SegundaEscena
import com.example.animalcrossing.escenas.TerceraEscena


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun Navegacion(db: BaseDeDatos){

    val databaseViewModel: DatabaseViewModel = viewModel()
    databaseViewModel.datab = db


    val controladorNavegacion = rememberNavController()
    NavHost(navController = controladorNavegacion, startDestination = NavegacionEscenas.PrimeraEscena.route){
        composable(route = NavegacionEscenas.PrimeraEscena.route ){
            PrimeraEscena(controladorNavegacion,db)
        }
        composable(route = NavegacionEscenas.SegundaEscena.route ){
            SegundaEscena(controladorNavegacion,db)
        }
        composable(route = NavegacionEscenas.TerceraEscena.route ){
            TerceraEscena(controladorNavegacion,db)
        }
        composable(route = NavegacionEscenas.IniciarSesionEscena.route ){
            IniciarSesionEscena(controladorNavegacion,db)
        }


    }



}


