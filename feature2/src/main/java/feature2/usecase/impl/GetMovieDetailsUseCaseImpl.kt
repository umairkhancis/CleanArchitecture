package feature2.usecase.impl

import feature2.repository.MoviesRepository
import feature2.usecase.GetMovieDetailsUseCase

class GetMovieDetailsUseCaseImpl(
    private val moviesRepository: MoviesRepository
) : GetMovieDetailsUseCase {

    override fun getMovieDetails(movieId: Int) =
        moviesRepository.getMovieDetails(movieId)
}