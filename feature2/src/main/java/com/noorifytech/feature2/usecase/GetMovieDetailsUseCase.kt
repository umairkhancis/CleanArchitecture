package com.noorifytech.feature2.usecase

import com.noorifytech.feature2.repository.vo.MovieDetailVO
import io.reactivex.Observable

interface GetMovieDetailsUseCase {
    fun getMovieDetails(movieId: Int): Observable<MovieDetailVO>
}