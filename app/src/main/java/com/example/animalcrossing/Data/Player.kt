package com.example.animalcrossing.Data
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "players")
data class Player (
    @PrimaryKey(autoGenerate = true)
    val id : Int = 0,
    val name: String,
    val maxScore: Int
)

