package com.noorifytech.feature2.repository.impl

import androidx.paging.PagedList
import com.noorifytech.core.datasource.moviesbackend.MoviesBackendDataSource
import com.noorifytech.core.dto.moviesbackend.MoviesListResponse
import com.noorifytech.datasource.localdb.room.MoviesDBDao
import com.noorifytech.feature2.mapper.MovieMapper
import com.noorifytech.feature2.repository.vo.MovieVO
import com.noorifytech.shared.logger.LogManager
import io.reactivex.Observer
import io.reactivex.disposables.Disposable
import io.reactivex.schedulers.Schedulers

class PopularMoviesBoundaryCallback(
    private val moviesDBDao: MoviesDBDao,
    private val moviesApiDao: MoviesBackendDataSource,
    private val movieMapper: MovieMapper
) : PagedList.BoundaryCallback<MovieVO>() {

    private val tag = this.javaClass.simpleName

    @Volatile
    private var isInProgress: Boolean = false

    override fun onZeroItemsLoaded() {
        queryAndSave()
    }

    override fun onItemAtEndLoaded(itemAtEnd: MovieVO) {
        queryAndSave(itemAtEnd)
    }

    private fun queryAndSave(itemAtEnd: MovieVO? = null) {
        val nextPage = itemAtEnd?.page?.plus(1) ?: 1

        if (isInProgress) return

        isInProgress = true

        LogManager.info(tag, "nextPage = $nextPage")
        moviesApiDao.getPopularMovies(nextPage)
            .subscribeOn(Schedulers.io())
            .subscribe(object : Observer<MoviesListResponse> {

                override fun onNext(response: MoviesListResponse) {
                    LogManager.info(tag, "onNext: page = ${response.page}")

                    val movieEntities = movieMapper.toMovies(response)
                    moviesDBDao.insert(movieEntities)
                }

                override fun onError(e: Throwable) {
                    LogManager.info(tag, "onError")
                    // TODO set observable for the view
                }

                override fun onComplete() {
                    LogManager.info(tag, "onComplete")
                }

                override fun onSubscribe(d: Disposable) {
                    LogManager.info(tag, "onSubscribe")
                }
            })

        isInProgress = false
    }
}