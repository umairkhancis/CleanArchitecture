package feature2.repository

import androidx.paging.PagedList
import feature2.repository.vo.MovieDetailVO
import feature2.repository.vo.MovieVO
import io.reactivex.Observable

interface MoviesRepository {
    fun getPopularMovies(): Observable<PagedList<MovieVO>>
    fun getMovieDetails(movieId: Int): Observable<MovieDetailVO>
}