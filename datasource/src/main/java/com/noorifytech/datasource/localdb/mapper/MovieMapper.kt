package com.noorifytech.datasource.localdb.mapper

import com.noorifytech.core.dto.local.movies.MovieDetailLocalDbDto
import com.noorifytech.core.dto.local.movies.MovieLocalDbDto
import com.noorifytech.datasource.localdb.entity.MovieDetailEntity
import com.noorifytech.datasource.localdb.entity.MovieEntity

object MovieMapper {
    fun toMovieLocalDbDto(movieEntity: MovieEntity): MovieLocalDbDto {
        return MovieLocalDbDto(
            movieEntity.id,
            movieEntity.title,
            movieEntity.imageUrl,
            movieEntity.page
        )
    }

    fun toMovieDetailLocalDbDto(movieDetailEntity: MovieDetailEntity): MovieDetailLocalDbDto {
        return MovieDetailLocalDbDto(
            movieDetailEntity.id,
            movieDetailEntity.title,
            movieDetailEntity.imageUrl,
            movieDetailEntity.overview,
            movieDetailEntity.releaseDate,
            movieDetailEntity.voteAverage
        )
    }
}