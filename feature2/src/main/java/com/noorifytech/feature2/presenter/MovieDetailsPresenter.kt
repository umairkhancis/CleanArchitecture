package com.noorifytech.feature2.presenter

import com.noorifytech.feature2.view.MovieDetailsView
import com.noorifytech.shared.base.mvp.BasePresenter

interface MovieDetailsPresenter : BasePresenter<MovieDetailsView> {

    fun onAttach(movieId: Int)
}