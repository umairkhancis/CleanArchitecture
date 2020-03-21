package com.noorifytech.core.dto.local.movies

data class MovieLocalDbDto(
    val id: Int,
    val title: String,
    val imageUrl: String,
    val page: Int
)