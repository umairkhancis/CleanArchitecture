package feature2.view

import com.noorifytech.shared.base.mvp.BaseLoadableContentView
import feature2.repository.vo.MovieDetailVO

interface MovieDetailsView : BaseLoadableContentView {

    fun showMovieDetails(movie: MovieDetailVO)
}