package feature2.presenter

import com.noorifytech.shared.base.mvp.BasePresenter
import feature2.view.MovieDetailsView

interface MovieDetailsPresenter : BasePresenter<MovieDetailsView> {

    fun onAttach(movieId: Int)
}