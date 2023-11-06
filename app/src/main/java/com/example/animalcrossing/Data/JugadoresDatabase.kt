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
    val lastScore: Int = 0,
    val maxScore: Int = 0,
    val playerActive: Boolean
)


//definimos el objeto que nos permite realizar operaciones con la base de datos y las definimos las mismas
@Dao
interface JugadorDao {
    @Insert
     fun insertJugador(jugador: Jugador)


     /////////////////GETTERS

    @Query("SELECT * FROM jugadores")
    fun getAllJugadores(): List<Jugador>

    @Query("SELECT count(nombre) FROM jugadores ")
    fun getNumPlayers(): Int
    @Query("SELECT count(playerActive) FROM jugadores WHERE playerActive = 1")
    fun getNumActivePlayer(): Int

    @Query("SELECT nombre FROM jugadores WHERE playerActive = 1")
    fun getActivePlayer(): String

    @Query("SELECT count(nombre) FROM jugadores WHERE nombre = :newName")
    fun getExistingPlayer(newName:String): Int

    @Query("SELECT * FROM jugadores WHERE maxScore != 0 ORDER BY maxScore Desc")
    fun getRanking(): List<Jugador>


    ///////////////SETTERS

    @Query("SELECT * FROM jugadores WHERE playerActive = 1")
    fun getActivePlayerData(): Jugador

    @Query("UPDATE jugadores SET playerActive = :state WHERE nombre = :newName")
    fun setPlayerActiveState(newName: String, state:Boolean)

    @Query("UPDATE jugadores SET playerActive = :state")
    fun setAllPlayerActiveState(state:Boolean)

    @Query("UPDATE jugadores SET lastScore = :num WHERE nombre = :name")
    fun setPlayerLastScore(num:Int, name: String)

    @Query("UPDATE jugadores SET maxScore = :num WHERE nombre = :name")
    fun setPlayerMaxScore(num:Int, name: String)


    @Query("DELETE FROM jugadores WHERE playerActive = 1")
    fun deleteActivePlayer();
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