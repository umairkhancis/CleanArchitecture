package com.noorifytech.core.datasource.localdb

import com.noorifytech.core.dto.local.movies.MovieDetailEntity
import com.noorifytech.core.dto.local.movies.MovieEntity

interface LocalDbDataSource {
    suspend fun getData(): String

    fun getPopularMovies(page: Int = 1): List<MovieEntity>

    fun getMovieDetails(movieId: Int): MovieDetailEntity
}