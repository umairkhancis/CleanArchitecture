package feature2.usecase.impl

import feature2.repository.MoviesRepository
import feature2.usecase.GetPopularMoviesUseCase

class GetPopularMoviesUseCaseImpl(
    private val moviesRepository: MoviesRepository
) : GetPopularMoviesUseCase {

    override fun getPopularMovies() =
        moviesRepository.getPopularMovies()
}