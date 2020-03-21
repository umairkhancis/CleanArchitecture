package com.noorifytech.feature2.usecase.impl

import com.noorifytech.feature2.repository.MoviesRepository
import com.noorifytech.feature2.usecase.GetMovieDetailsUseCase

class GetMovieDetailsUseCaseImpl(
    private val moviesRepository: MoviesRepository
) : GetMovieDetailsUseCase {

    override fun getMovieDetails(movieId: Int) =
        moviesRepository.getMovieDetails(movieId)
}