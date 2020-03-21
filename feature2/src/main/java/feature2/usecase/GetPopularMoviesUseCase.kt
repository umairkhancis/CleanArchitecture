package feature2.usecase

import androidx.paging.PagedList
import feature2.repository.vo.MovieVO
import io.reactivex.Observable

interface GetPopularMoviesUseCase {
    fun getPopularMovies(): Observable<PagedList<MovieVO>>
}

