package feature3.usecase

import androidx.paging.PagedList
import feature3.repository.vo.MovieVO
import io.reactivex.Observable

interface GetPopularMoviesUseCase {
    fun getPopularMovies(): Observable<PagedList<MovieVO>>
}

