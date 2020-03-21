package com.noorifytech.datasource.localdb.room

import androidx.paging.DataSource
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.noorifytech.core.dto.local.movies.MovieDetailEntity
import com.noorifytech.core.dto.local.movies.MovieEntity
import io.reactivex.Single

/**
 * Interface for database access for User related operations.
 */
@Dao
interface MoviesDBDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insert(movies: List<MovieEntity>)

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insert(movieDetailEntity: MovieDetailEntity)

    @Query("SELECT * FROM Movies ORDER BY page ASC")
    fun getPopularMovies(): DataSource.Factory<Int, MovieEntity>

    @Query("SELECT * FROM MoviesDetails WHERE id = :movieId")
    fun getMovieDetails(movieId: Int): Single<MovieDetailEntity>
}