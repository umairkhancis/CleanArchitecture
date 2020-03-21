package feature2.presenter.impl

import com.noorifytech.shared.base.mvp.BasePresenterImpl
import com.noorifytech.shared.logger.LogManager
import feature2.presenter.MovieDetailsPresenter
import feature2.repository.vo.MovieDetailVO
import feature2.usecase.GetMovieDetailsUseCase
import feature2.view.MovieDetailsView
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
