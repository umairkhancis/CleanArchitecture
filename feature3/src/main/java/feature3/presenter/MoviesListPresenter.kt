package feature3.presenter

import com.noorifytech.shared.base.mvp.BasePresenter
import feature3.view.MoviesListView

interface MoviesListPresenter : BasePresenter<MoviesListView> {
    fun onAttach()

    fun onMovieSelected(movieId: Int)
}