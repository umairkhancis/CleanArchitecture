package com.noorifytech.datasource.movies.remote

import com.noorifytech.core.datasource.moviesbackend.MoviesBackendDataSource
import com.noorifytech.core.dto.moviesbackend.MovieResponse
import com.noorifytech.core.dto.moviesbackend.MoviesListResponse
import com.noorifytech.datasource.movies.remote.retrofit.TmdbService
import io.reactivex.Observable

class MoviesRemoteBackendDataSource(private val tmdbService: TmdbService): MoviesBackendDataSource {
    override fun getPopularMovies(page: Int): Observable<MoviesListResponse> =
        tmdbService.getPopularMovies(page = "$page")

    override fun getMovieDetails(movieId: Int): Observable<MovieResponse> =
        tmdbService.getMovieDetails(movieId)

}