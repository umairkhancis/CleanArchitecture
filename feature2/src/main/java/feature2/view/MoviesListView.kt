package feature2.view

import androidx.paging.PagedList
import com.noorifytech.shared.base.mvp.BaseLoadableContentView
import feature2.repository.vo.MovieVO

interface MoviesListView : BaseLoadableContentView {
    fun showList(list: PagedList<MovieVO>)
    fun showMovieDetailsScreen(movieId: Int)
}