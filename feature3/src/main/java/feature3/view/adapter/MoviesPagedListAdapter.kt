package feature3.view.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.paging.PagedListAdapter
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.noorifytech.feature2.R
import com.noorifytech.feature2.databinding.ActivityMoviesListItemBinding
import feature3.repository.vo.MovieVO
import feature3.view.callback.MoviesListCellCallback

class MoviesPagedListAdapter(
    private val context: Context,
    private val callback: MoviesListCellCallback
) : PagedListAdapter<MovieVO, MoviesPagedListAdapter.MoviesViewHolder>(MOVIE_COMPARATOR) {

    override fun onBindViewHolder(holder: MoviesViewHolder, position: Int) {
        val movie = getItem(position)
        if (movie != null) {
            holder.bind(context, movie)
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MoviesViewHolder {
        val binding = ActivityMoviesListItemBinding.inflate(LayoutInflater.from(context))
        return MoviesViewHolder(binding.root, callback)
    }

    class MoviesViewHolder(
        private val viewItem: View,
        private val callback: MoviesListCellCallback
    ) : RecyclerView.ViewHolder(viewItem) {

        fun bind(context: Context, movie: MovieVO) {
            val itemBinding = ActivityMoviesListItemBinding.bind(viewItem)
            itemBinding.movieNameTv.text = movie.name

            Glide.with(context)
                .asBitmap()
                .load(movie.imageUrl)
                .placeholder(R.mipmap.ic_launcher)
                .into(itemBinding.movieImageIv)

            itemBinding.movieListItemRoot.setOnClickListener {
                callback.onMovieSelected(movie.id, adapterPosition)
            }
        }

    }

    companion object {
        val MOVIE_COMPARATOR = object : DiffUtil.ItemCallback<MovieVO>() {
            override fun areItemsTheSame(oldItem: MovieVO, newItem: MovieVO) =
                oldItem.id == newItem.id

            override fun areContentsTheSame(oldItem: MovieVO, newItem: MovieVO) =
                oldItem == newItem
        }
    }
}