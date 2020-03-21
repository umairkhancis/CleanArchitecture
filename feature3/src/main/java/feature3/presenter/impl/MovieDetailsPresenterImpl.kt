package feature3.presenter.impl

import com.noorifytech.shared.base.mvp.BasePresenterImpl
import com.noorifytech.shared.logger.LogManager
import feature3.presenter.MovieDetailsPresenter
import feature3.repository.vo.MovieDetailVO
import feature3.usecase.GetMovieDetailsUseCase
import feature3.view.MovieDetailsView
import io.reactivex.observers.DisposableObserver

class MovieDetailsPresenterImpl(private val getMovieDetailsUseCase: GetMovieDetailsUseCase) :
    BasePresenterImpl<MovieDetailsView>(), MovieDetailsPresenter {

    private val tag = this.javaClass.simpleName

    override fun onAttach(movieId: Int) {

        view.showLoading()
        val callback = object : DisposableObserver<MovieDetailVO>() {
            override fun onNext(movie: MovieDetailVO) {
                LogManager.info(tag, "onNext: = $movie")

                view.hideLoading()
                view.showMovieDetails(movie)
            }

            override fun onError(e: Throwable) {
                LogManager.info(tag, "onError: ${e.message}")

                view.hideLoading()
                view.showError()
            }

            override fun onComplete() {
                LogManager.info(tag, "onComplete")
            }

        }

        this.baseProcessor.process(
            business = getMovieDetailsUseCase.getMovieDetails(movieId),
            callback = callback
        )
    }
}
