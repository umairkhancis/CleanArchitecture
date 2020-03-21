package com.noorifytech.core.dto.local.movies

data class MovieDetailLocalDbDto(
    val id: Int,
    val title: String,
    val imageUrl: String,
    val overview: String,
    val releaseDate: Long,
    val voteAverage: Float
)