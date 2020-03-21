package feature3.presenter.impl

import androidx.paging.PagedList
import com.noorifytech.shared.base.mvp.BasePresenterImpl
import com.noorifytech.shared.logger.LogManager
import feature3.presenter.MoviesListPresenter
import feature3.repository.vo.MovieVO
import feature3.usecase.GetPopularMoviesUseCase
import feature3.view.MoviesListView
import io.reactivex.observers.DisposableObserver

class MoviesListPresenterImpl(private val getPopularMoviesUseCase: GetPopularMoviesUseCase) :
    BasePresenterImpl<MoviesListView>(), MoviesListPresenter {

    private val tag = this.javaClass.simpleName

    override fun onAttach() {
        view.showLoading()

        val callback = object : DisposableObserver<PagedList<MovieVO>>() {
            override fun onNext(pagedList: PagedList<MovieVO>) {
                LogManager.info(tag, "onNext: pagedList.size = ${pagedList.size}")

                view.hideLoading()
                view.showList(pagedList)
            }

            override fun onError(e: Throwable) {
                LogManager.error(tag, "onError: ${e.message}")

                view.hideLoading()
                view.showError()
            }

            override fun onComplete() {
                LogManager.info(tag, "onComplete")

                view.showError()
            }

        }

        this.baseProcessor.process(
            business = getPopularMoviesUseCase.getPopularMovies(),
            callback = callback
        )
    }

    override fun onMovieSelected(movieId: Int) {
        view.showMovieDetailsScreen(movieId)
    }
}
