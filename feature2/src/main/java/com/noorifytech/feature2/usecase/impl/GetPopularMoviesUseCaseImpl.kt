package com.noorifytech.feature2.usecase.impl

import com.noorifytech.feature2.repository.MoviesRepository
import com.noorifytech.feature2.usecase.GetPopularMoviesUseCase

class GetPopularMoviesUseCaseImpl(
    private val moviesRepository: MoviesRepository
) : GetPopularMoviesUseCase {

    override fun getPopularMovies() =
        moviesRepository.getPopularMovies()
}