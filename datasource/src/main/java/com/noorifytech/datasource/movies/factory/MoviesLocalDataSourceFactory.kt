package com.noorifytech.datasource.movies.factory

import android.content.Context
import com.noorifytech.datasource.localdb.impl.room.MoviesDBDao
import com.noorifytech.datasource.localdb.impl.room.RoomDB

object MoviesLocalDataSourceFactory {
    fun getMoviesLocalDataSource(context: Context): MoviesDBDao {
        val db = RoomDB.getInstance(context)
        return db.moviesDao()
    }
}