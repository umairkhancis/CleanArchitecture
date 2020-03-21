package feature3.repository

import androidx.paging.PagedList
import feature3.repository.vo.MovieDetailVO
import feature3.repository.vo.MovieVO
import io.reactivex.Observable

interface MoviesRepository {
    fun getPopularMovies(): Observable<PagedList<MovieVO>>
    fun getMovieDetails(movieId: Int): Observable<MovieDetailVO>
}