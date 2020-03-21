package feature3.presenter

import com.noorifytech.shared.base.mvp.BasePresenter
import feature3.view.MovieDetailsView

interface MovieDetailsPresenter : BasePresenter<MovieDetailsView> {

    fun onAttach(movieId: Int)
}