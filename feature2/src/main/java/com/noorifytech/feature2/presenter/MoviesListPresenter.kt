package com.noorifytech.feature2.presenter

import com.noorifytech.feature2.view.MoviesListView
import com.noorifytech.shared.base.mvp.BasePresenter

interface MoviesListPresenter : BasePresenter<MoviesListView> {
    fun onAttach()

    fun onMovieSelected(movieId: Int)
}