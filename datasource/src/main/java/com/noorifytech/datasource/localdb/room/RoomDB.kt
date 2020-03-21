package com.noorifytech.datasource.localdb.room

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.noorifytech.core.dto.local.movies.MovieDetailEntity
import com.noorifytech.core.dto.local.movies.MovieEntity

/**
 * Movies database description.
 */
@Database(
    entities = [MovieEntity::class, MovieDetailEntity::class],
    version = 1,
    exportSchema = false
)
abstract class RoomDB : RoomDatabase() {
    abstract fun moviesDao(): MoviesDBDao

    companion object {

        // For Singleton instantiation
        @Volatile private var instance: RoomDB? = null

        fun getInstance(context: Context): RoomDB {
            return instance ?: synchronized(this) {
                instance ?: buildDatabase(context).also { instance = it }
            }
        }

        private fun buildDatabase(context: Context): RoomDB {
            return Room.databaseBuilder(context, RoomDB::class.java, DATABASE_NAME)
                .build()
        }

        private const val DATABASE_NAME = "movies_app"
    }
}