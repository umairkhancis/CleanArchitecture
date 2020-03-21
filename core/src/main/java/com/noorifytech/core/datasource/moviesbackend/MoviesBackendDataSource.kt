package com.noorifytech.core.datasource.moviesbackend

import com.noorifytech.core.dto.moviesbackend.MovieResponse
import com.noorifytech.core.dto.moviesbackend.MoviesListResponse
import io.reactivex.Observable

interface MoviesBackendDataSource {
    fun getPopularMovies(page: Int = 1): Observable<MoviesListResponse>

    fun getMovieDetails(movieId: Int): Observable<MovieResponse>
}