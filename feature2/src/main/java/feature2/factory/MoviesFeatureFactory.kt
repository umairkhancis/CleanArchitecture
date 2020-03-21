package feature2.factory

import feature2.presenter.MovieDetailsPresenter
import feature2.presenter.MoviesListPresenter
import feature2.presenter.impl.MovieDetailsPresenterImpl
import feature2.presenter.impl.MoviesListPresenterImpl
import feature2.repository.factory.MoviesRepositoryFactory
import feature2.usecase.impl.GetMovieDetailsUseCaseImpl
import feature2.usecase.impl.GetPopularMoviesUseCaseImpl


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