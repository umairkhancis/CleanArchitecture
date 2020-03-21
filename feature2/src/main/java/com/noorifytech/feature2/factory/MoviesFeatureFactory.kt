package com.noorifytech.feature2.factory

import com.noorifytech.feature2.repository.factory.MoviesRepositoryFactory
import com.noorifytech.feature2.presenter.MovieDetailsPresenter
import com.noorifytech.feature2.presenter.MoviesListPresenter
import com.noorifytech.feature2.presenter.impl.MovieDetailsPresenterImpl
import com.noorifytech.feature2.presenter.impl.MoviesListPresenterImpl
import com.noorifytech.feature2.usecase.GetMovieDetailsUseCaseImpl
import com.noorifytech.feature2.usecase.GetPopularMoviesUseCaseImpl


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