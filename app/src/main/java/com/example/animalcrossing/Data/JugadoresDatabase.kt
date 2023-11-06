package com.example.animalcrossing.Data

import androidx.lifecycle.ViewModel
import androidx.room.Dao
import androidx.room.Database
import androidx.room.Entity
import androidx.room.Insert
import androidx.room.PrimaryKey
import androidx.room.Query
import androidx.room.RoomDatabase


//Definimos la tabla jugadores que contendra la info de cada jugador
@Entity(tableName = "jugadores")
data class Jugador(
    @PrimaryKey(autoGenerate = true) val id: Int = 0,
    val nombre: String,
    val lastScore: Int,
    val maxScore: Int,
    val playerActive: Boolean
)


//definimos el objeto que nos permite realizar operaciones con la base de datos y las definimos las mismas
@Dao
interface JugadorDao {
    @Insert
     fun insertJugador(jugador: Jugador)

    @Query("SELECT * FROM jugadores")
    fun getAllJugadores(): List<Jugador>

    @Query("UPDATE jugadores SET playerActive = :state WHERE nombre = :newName")
    fun setPlayerActiveState(newName: String, state:Boolean)

    @Query("UPDATE jugadores SET playerActive = :state")
    fun setAllPlayerActiveState(state:Boolean)

    @Query("SELECT count(playerActive) FROM jugadores WHERE playerActive = 1")
    fun getNumActivePlayer(): Int

    @Query("SELECT nombre FROM jugadores WHERE playerActive = 1")
    fun getActivePlayer(): String

    @Query("SELECT count(nombre) FROM jugadores WHERE nombre = :newName")
    fun getExistingPlayer(newName:String): Int
}

//definimos la base de datos como tal
@Database(entities = [Jugador::class], version = 1)
abstract class BaseDeDatos : RoomDatabase() {
    abstract fun jugadorDao(): JugadorDao
}

//para acceder a la base de datos desde cualquier escena
class DatabaseViewModel : ViewModel() {
    lateinit var datab: BaseDeDatos
}