package feature2.usecase

import feature2.repository.vo.MovieDetailVO
import io.reactivex.Observable

interface GetMovieDetailsUseCase {
    fun getMovieDetails(movieId: Int): Observable<MovieDetailVO>
}