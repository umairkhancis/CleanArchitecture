package feature3.view

import com.noorifytech.shared.base.mvp.BaseLoadableContentView
import feature3.repository.vo.MovieDetailVO

interface MovieDetailsView : BaseLoadableContentView {

    fun showMovieDetails(movie: MovieDetailVO)
}