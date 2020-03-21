package feature2.view.activity

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.bumptech.glide.Glide
import com.noorifytech.feature2.R
import com.noorifytech.feature2.databinding.ActivityMovieDetailsBinding
import com.noorifytech.shared.extensions.hide
import com.noorifytech.shared.extensions.show
import com.noorifytech.shared.ui.utils.showSnackBar
import feature2.factory.MoviesFeatureFactory
import feature2.presenter.MovieDetailsPresenter
import feature2.repository.vo.MovieDetailVO
import feature2.view.MovieDetailsView

class MovieDetailsActivity : AppCompatActivity(), MovieDetailsView {

    private lateinit var presenter: MovieDetailsPresenter
    private lateinit var binding: ActivityMovieDetailsBinding
    private val movieId: Int by lazy { intent.getIntExtra(MOVIE_ID_KEY, 0) }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMovieDetailsBinding.inflate(layoutInflater)
        setContentView(binding.root)

        init()
    }

    private fun init() {
        presenter = MoviesFeatureFactory.createMovieDetailsPresenter()
        presenter.initView(this)
        presenter.onAttach(movieId)
    }

    override fun onDestroy() {
        super.onDestroy()

        presenter.onDetach()
    }

    override fun showMovieDetails(movie: MovieDetailVO) {
        binding.movieNameTv.text = movie.title
        binding.movieOverviewTv.text = movie.overview
        binding.movieReleaseDateTv.text = movie.getReleaseDate()

        Glide.with(this)
            .asBitmap()
            .load(movie.imageUrl)
            .placeholder(R.mipmap.ic_launcher)
            .into(binding.movieImageIv)
    }

    override fun showLoading() =
        binding.progressBar.show()

    override fun hideLoading() =
        binding.progressBar.hide()

    override fun showNoContent() =
        showSnackBar(binding.root, getString(R.string.error_no_content_message))

    override fun showNoConnection() {
        showSnackBar(binding.root, getString(R.string.no_internet))
    }

    override fun showError() =
        showSnackBar(binding.root, getString(R.string.error_generic_message))

    companion object {
        const val MOVIE_ID_KEY = "movie_id"
    }
}