package com.noorifytech.feature2.mapper

import android.annotation.SuppressLint
import com.noorifytech.core.dto.moviesbackend.MovieResponse
import com.noorifytech.core.dto.moviesbackend.MoviesListResponse
import com.noorifytech.core.dto.local.movies.MovieDetailEntity
import com.noorifytech.core.dto.local.movies.MovieEntity
import com.noorifytech.feature2.repository.vo.MovieDetailVO
import com.noorifytech.feature2.repository.vo.MovieVO
import java.text.SimpleDateFormat

object MovieMapper {
    fun toMovies(moviesResponse: MoviesListResponse): List<MovieEntity> {
        val movies = moviesResponse.results

        return movies.map {
            MovieEntity(
                it.id,
                it.title,
                it.getPosterFullPath(),
                moviesResponse.page
            )
        }
    }

    fun toMovieVO(movieEntity: MovieEntity): MovieVO {
        return MovieVO(
            movieEntity.id,
            movieEntity.title,
            movieEntity.imageUrl,
            movieEntity.page
        )
    }

    private fun toMovieEntity(movieResponse: MovieResponse): MovieEntity {
        return MovieEntity(
            movieResponse.id,
            movieResponse.title,
            movieResponse.getPosterFullPath(),
            movieResponse.page
        )
    }

    fun toMovieDetailEntity(movieResponse: MovieResponse): MovieDetailEntity {
        return MovieDetailEntity(
            movieResponse.id,
            movieResponse.title,
            movieResponse.getPosterFullPath(),
            movieResponse.overview,
            toTimeStamp(movieResponse.releaseDate),
            movieResponse.voteAverage
        )
    }

    fun toMovieDetailVO(movieDetailEntity: MovieDetailEntity): MovieDetailVO {
        return MovieDetailVO(
            movieDetailEntity.id,
            movieDetailEntity.title,
            movieDetailEntity.imageUrl,
            movieDetailEntity.overview,
            movieDetailEntity.releaseDate,
            movieDetailEntity.voteAverage
        )
    }

    @SuppressLint("SimpleDateFormat")
    fun toTimeStamp(dateStr: String): Long {
        val formatter = SimpleDateFormat("yyyy-MM-dd")
        val d = formatter.parse(dateStr)

        return d.time
    }
}