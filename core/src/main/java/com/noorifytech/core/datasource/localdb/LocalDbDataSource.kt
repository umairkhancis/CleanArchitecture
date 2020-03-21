package com.noorifytech.core.datasource.localdb

import com.noorifytech.core.dto.local.movies.MovieDetailLocalDbDto
import com.noorifytech.core.dto.local.movies.MovieLocalDbDto

interface LocalDbDataSource {
    suspend fun getData(): String

    fun getPopularMovies(page: Int = 1): List<MovieLocalDbDto>

    fun getMovieDetails(movieId: Int): MovieDetailLocalDbDto
}