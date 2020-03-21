package feature2.presenter

import com.noorifytech.shared.base.mvp.BasePresenter
import feature2.view.MoviesListView

interface MoviesListPresenter : BasePresenter<MoviesListView> {
    fun onAttach()

    fun onMovieSelected(movieId: Int)
}