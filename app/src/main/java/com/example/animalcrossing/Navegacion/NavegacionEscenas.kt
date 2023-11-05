package com.example.animalcrossing.Navegacion

sealed class NavegacionEscenas(val route: String) {
    object PrimeraEscena: NavegacionEscenas("primera_escena")
    object SegundaEscena: NavegacionEscenas("segunda_escena")
    object TerceraEscena: NavegacionEscenas("tercera_escena")
    object IniciarSesionEscena: NavegacionEscenas("iniciar_sesion_escena")
}




