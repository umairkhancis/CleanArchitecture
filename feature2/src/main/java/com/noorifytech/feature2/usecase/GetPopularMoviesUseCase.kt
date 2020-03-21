package com.noorifytech.feature2.usecase

import androidx.paging.PagedList
import com.noorifytech.feature2.repository.MoviesRepository
import com.noorifytech.feature2.repository.vo.MovieVO
import io.reactivex.Observable

interface GetPopularMoviesUseCase {
    fun getPopularMovies(): Observable<PagedList<MovieVO>>
}

