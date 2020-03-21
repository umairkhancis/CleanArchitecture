package com.noorifytech.feature2.view

import androidx.paging.PagedList
import com.noorifytech.feature2.repository.vo.MovieVO
import com.noorifytech.shared.base.mvp.BaseLoadableContentView

interface MoviesListView : BaseLoadableContentView {
    fun showList(list: PagedList<MovieVO>)
    fun showMovieDetailsScreen(movieId: Int)
}