package com.noorifytech.datasource.movies.remote.retrofit

import com.noorifytech.core.dto.moviesbackend.MovieResponse
import com.noorifytech.core.dto.moviesbackend.MoviesListResponse
import com.noorifytech.datasource.common.API_KEY
import io.reactivex.Observable
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface TmdbService {
    @GET("movie/popular?api_key=$API_KEY")
    fun getPopularMovies(
        @Query("language") language: String = "en-US",
        @Query("page") page: String = "1"
    ): Observable<MoviesListResponse>

    @GET("movie/{movie_id}?api_key=$API_KEY")
    fun getMovieDetails(
        @Path("movie_id") movieId: Int,
        @Query("language") language: String = "en-US"
    ): Observable<MovieResponse>
}