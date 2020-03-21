package feature3.factory

import feature3.presenter.MovieDetailsPresenter
import feature3.presenter.MoviesListPresenter
import feature3.presenter.impl.MovieDetailsPresenterImpl
import feature3.presenter.impl.MoviesListPresenterImpl
import feature3.repository.factory.MoviesRepositoryFactory
import feature3.usecase.impl.GetMovieDetailsUseCaseImpl
import feature3.usecase.impl.GetPopularMoviesUseCaseImpl


object MoviesFeatureFactory {

    fun createMoviesListPresenter(): MoviesListPresenter {
        val getPopularMoviesUseCase =
            GetPopularMoviesUseCaseImpl(MoviesRepositoryFactory.getMoviesRepository())

        return MoviesListPresenterImpl(getPopularMoviesUseCase)
    }

    fun createMovieDetailsPresenter(): MovieDetailsPresenter {
        val getMovieDetailsUseCase =
            GetMovieDetailsUseCaseImpl(MoviesRepositoryFactory.getMoviesRepository())

        return MovieDetailsPresenterImpl(getMovieDetailsUseCase)
    }
}