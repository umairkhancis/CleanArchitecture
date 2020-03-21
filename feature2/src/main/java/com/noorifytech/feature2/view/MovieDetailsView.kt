package com.noorifytech.feature2.view

import com.noorifytech.feature2.repository.vo.MovieDetailVO
import com.noorifytech.shared.base.mvp.BaseLoadableContentView

interface MovieDetailsView : BaseLoadableContentView {

    fun showMovieDetails(movie: MovieDetailVO)

    companion object {
        const val MOVIE_ID_KEY = "movie_id"
    }
}