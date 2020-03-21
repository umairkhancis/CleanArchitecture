package feature3.usecase.impl

import feature3.repository.MoviesRepository
import feature3.usecase.GetMovieDetailsUseCase

class GetMovieDetailsUseCaseImpl(
    private val moviesRepository: MoviesRepository
) : GetMovieDetailsUseCase {

    override fun getMovieDetails(movieId: Int) =
        moviesRepository.getMovieDetails(movieId)
}