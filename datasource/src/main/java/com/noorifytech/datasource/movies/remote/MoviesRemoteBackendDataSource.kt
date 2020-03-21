package com.noorifytech.datasource.movies.remote

import com.noorifytech.core.datasource.moviesbackend.MoviesBackendDataSource
import com.noorifytech.core.dto.moviesbackend.MovieResponse
import com.noorifytech.core.dto.moviesbackend.MoviesListResponse
import com.noorifytech.datasource.movies.remote.retrofit.TmdbService

class MoviesRemoteBackendDataSource(private val tmdbService: TmdbService): MoviesBackendDataSource {
    override suspend fun getPopularMovies(page: Int): MoviesListResponse =
        tmdbService.getPopularMovies()

    override suspend fun getMovieDetails(movieId: Int): MovieResponse =
        tmdbService.getMovieDetails(movieId)

}