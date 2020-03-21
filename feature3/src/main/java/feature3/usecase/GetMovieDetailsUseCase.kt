package feature3.usecase

import feature3.repository.vo.MovieDetailVO
import io.reactivex.Observable

interface GetMovieDetailsUseCase {
    fun getMovieDetails(movieId: Int): Observable<MovieDetailVO>
}