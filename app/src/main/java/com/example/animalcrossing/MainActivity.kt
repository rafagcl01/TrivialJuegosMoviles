@file:OptIn(ExperimentalMaterial3Api::class)


package com.example.animalcrossing

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview

import com.example.animalcrossing.Navegacion.Navegacion
import com.example.animalcrossing.Navegacion.NavegacionEscenas

import androidx.room.Room
import com.example.animalcrossing.Data.BaseDeDatos

import com.example.animalcrossing.escenas.PrimeraEscena
import com.example.animalcrossing.escenas.SegundaEscena
import com.example.animalcrossing.ui.theme.AnimalCrossingTheme

class MainActivity : ComponentActivity() {

    lateinit var db: BaseDeDatos

    @OptIn(ExperimentalMaterial3Api::class)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        db = Room.databaseBuilder(applicationContext, BaseDeDatos::class.java, "app-database")
            .allowMainThreadQueries()
            .build()

        setContent {
            AnimalCrossingTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {

                    Navegacion(db)
                }
            }
        }
    }
}



@OptIn(ExperimentalMaterial3Api::class)
@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    AnimalCrossingTheme {
        //Navegacion(db)

    }
}