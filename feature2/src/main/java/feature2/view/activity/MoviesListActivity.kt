package feature2.view.activity

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.paging.PagedList
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import com.noorifytech.feature2.R
import com.noorifytech.feature2.databinding.ActivityMoviesListBinding
import com.noorifytech.shared.extensions.hide
import com.noorifytech.shared.extensions.show
import com.noorifytech.shared.navigation.navigateTo
import com.noorifytech.shared.ui.utils.showSnackBar
import feature2.factory.MoviesFeatureFactory
import feature2.navigation.MovieDetailsScreen
import feature2.presenter.MoviesListPresenter
import feature2.repository.vo.MovieVO
import feature2.view.MoviesListView
import feature2.view.adapter.MoviesPagedListAdapter
import feature2.view.callback.MoviesListCellCallback
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.Job
import kotlin.coroutines.CoroutineContext

class MoviesListActivity : AppCompatActivity(),
    MoviesListView, MoviesListCellCallback, CoroutineScope {

    private lateinit var moviesListAdapter: MoviesPagedListAdapter
    private lateinit var presenter: MoviesListPresenter
    private lateinit var binding: ActivityMoviesListBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMoviesListBinding.inflate(layoutInflater)
        setContentView(binding.root)

        init()
    }

    private fun init() {
        presenter = MoviesFeatureFactory.createMoviesListPresenter()
        presenter.initView(this)
        presenter.onAttach()

        initRecyclerView()
    }

    private fun initRecyclerView() {
        binding.moviesListRv.layoutManager = LinearLayoutManager(this)
        binding.moviesListRv.addItemDecoration(
            DividerItemDecoration(
                this,
                DividerItemDecoration.VERTICAL
            )
        )

        moviesListAdapter = MoviesPagedListAdapter(this, this)
        binding.moviesListRv.adapter = moviesListAdapter
    }

    override fun onDestroy() {
        super.onDestroy()

        presenter.onDetach()
    }

    override fun showList(list: PagedList<MovieVO>) =
        moviesListAdapter.submitList(list)

    override fun showMovieDetailsScreen(movieId: Int) {
        val movieDetailIntent = Intent().apply { putExtra(MOVIE_ID_KEY, movieId) }
        navigateTo(MovieDetailsScreen, movieDetailIntent)
    }

    override fun showLoading() =
        binding.progressBar.show()

    override fun hideLoading() =
        binding.progressBar.hide()

    override fun showNoContent() =
        showSnackBar(binding.root, getString(R.string.error_no_content_message))

    override fun showNoConnection() =
        showSnackBar(binding.root, getString(R.string.no_internet))

    override fun showError() =
        showSnackBar(binding.root, getString(R.string.error_generic_message))

    override fun onMovieSelected(movieId: Int, position: Int) =
        presenter.onMovieSelected(movieId)

    private val job = Job()

    override val coroutineContext: CoroutineContext
        get() = job + Dispatchers.Main

    companion object {
        const val MOVIE_ID_KEY = "movie_id"
    }
}