package com.noorifytech.datasource.localdb.impl

import com.noorifytech.core.datasource.localdb.LocalDbDataSource
import com.noorifytech.core.dto.local.movies.MovieDetailLocalDbDto
import com.noorifytech.core.dto.local.movies.MovieLocalDbDto
import com.noorifytech.datasource.localdb.impl.room.MoviesDBDao
import com.noorifytech.datasource.localdb.mapper.MovieMapper

class LocalDbDataSourceImpl(
    private val moviesDBDao: MoviesDBDao,
    private val mapper: MovieMapper
) : LocalDbDataSource {
    override suspend fun getData(): String {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun getPopularMovies(page: Int): List<MovieLocalDbDto> {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun getMovieDetails(movieId: Int): MovieDetailLocalDbDto {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

}