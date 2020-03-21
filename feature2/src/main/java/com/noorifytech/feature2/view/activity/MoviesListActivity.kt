package com.noorifytech.feature2.view.activity

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.paging.PagedList
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import com.google.android.material.snackbar.Snackbar
import com.noorifytech.cleanarchitecture.Screens
import com.noorifytech.cleanarchitecture.navigateTo
import com.noorifytech.feature2.R
import com.noorifytech.feature2.databinding.ActivityMoviesListBinding
import com.noorifytech.feature2.factory.MoviesFeatureFactory
import com.noorifytech.feature2.presenter.MoviesListPresenter
import com.noorifytech.feature2.repository.vo.MovieVO
import com.noorifytech.feature2.view.MoviesListView
import com.noorifytech.feature2.view.adapter.MoviesPagedListAdapter
import com.noorifytech.feature2.view.callback.MoviesListCellCallback
import com.noorifytech.shared.extensions.hide
import com.noorifytech.shared.extensions.show
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
        binding.moviesListRV.layoutManager = LinearLayoutManager(this)
        binding.moviesListRV.addItemDecoration(
            DividerItemDecoration(
                this,
                DividerItemDecoration.VERTICAL
            )
        )

        moviesListAdapter = MoviesPagedListAdapter(this, this)
        binding.moviesListRV.adapter = moviesListAdapter
    }

    override fun onDestroy() {
        super.onDestroy()

        presenter.onDetach()
    }

    override fun showList(list: PagedList<MovieVO>) =
        moviesListAdapter.submitList(list)

    override fun showMovieDetailsScreen(movieId: Int) =
        navigateTo(Screens.MovieDetailsScreen)

    override fun showLoading() =
        binding.progressBar.show()

    override fun hideLoading() =
        binding.progressBar.hide()

    override fun showNoContent() =
        showSnackBar(getString(R.string.error_no_content_message))

    override fun showNoConnection() =
        showSnackBar(getString(R.string.no_internet))

    override fun showError() =
        showSnackBar(getString(R.string.error_generic_message))

    private fun showSnackBar(message: String) =
        Snackbar.make(binding.root, message, Snackbar.LENGTH_LONG).show()

    override fun onMovieSelected(movieId: Int, position: Int) =
        presenter.onMovieSelected(movieId)

    private val job = Job()

    override val coroutineContext: CoroutineContext
        get() = job + Dispatchers.Main
}