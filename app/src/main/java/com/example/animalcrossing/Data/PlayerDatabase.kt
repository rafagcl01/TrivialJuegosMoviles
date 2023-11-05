package com.example.animalcrossing.Data

import android.content.Context
import androidx.compose.ui.platform.LocalContext
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase

@Database(entities = [Player::class], version = 1, exportSchema = false)
abstract class PlayerDatabase : RoomDatabase() {

    abstract fun playerDao(): PlayerDao

    /* //esto lo tengo que revisar porq no entiendo aun bien lo que hace
    companion object {

        @Volatile
        private var Instance: PlayerDatabase? = null

        fun getDatabase(context: Context): PlayerDatabase {
            return Instance ?: synchronized(this) {
                Room.databaseBuilder(context, PlayerDatabase::class.java, "player_database")
                    .build()
                    .also {
                        Instance = it
                    }
            }
        }
    }*/
}

