package com.example.animalcrossing.Data

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import androidx.room.Update
import kotlinx.coroutines.flow.Flow


@Dao
interface PlayerDao {

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    fun insert(player: Player)

    @Update
    fun update(player:Player)

    @Delete
    fun delete(player:Player)

    @Query("SELECT * from players where id = :id")
    fun getPlayer(id:Int): Flow<Player>

    @Query("SELECT * from players ORDER BY name ASC")
    fun getAllPlayers(): Flow<List<Player>>
}