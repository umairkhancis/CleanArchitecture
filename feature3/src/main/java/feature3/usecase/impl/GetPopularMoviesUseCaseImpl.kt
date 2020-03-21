package feature3.usecase.impl

import feature3.repository.MoviesRepository
import feature3.usecase.GetPopularMoviesUseCase

class GetPopularMoviesUseCaseImpl(
    private val moviesRepository: MoviesRepository
) : GetPopularMoviesUseCase {

    override fun getPopularMovies() =
        moviesRepository.getPopularMovies()
}