package feature2.mapper

import android.annotation.SuppressLint
import com.noorifytech.core.dto.local.movies.MovieDetailLocalDbDto
import com.noorifytech.core.dto.local.movies.MovieLocalDbDto
import com.noorifytech.core.dto.moviesbackend.MovieResponse
import com.noorifytech.core.dto.moviesbackend.MoviesListResponse
import com.noorifytech.datasource.localdb.entity.MovieDetailEntity
import com.noorifytech.datasource.localdb.entity.MovieEntity
import feature2.repository.vo.MovieDetailVO
import feature2.repository.vo.MovieVO
import java.text.SimpleDateFormat

object MovieMapper {
    fun toMovies(moviesResponse: MoviesListResponse): List<MovieEntity> {
        val movies = moviesResponse.results

        return movies.map {
            MovieEntity(
                it.id,
                it.title,
                it.getPosterFullPath(),
                moviesResponse.page
            )
        }
    }

    private fun toMovieEntity(movieResponse: MovieResponse): MovieEntity {
        return MovieEntity(
            movieResponse.id,
            movieResponse.title,
            movieResponse.getPosterFullPath(),
            movieResponse.page
        )
    }

    fun toMovieDetailEntity(movieResponse: MovieResponse): MovieDetailEntity {
        return MovieDetailEntity(
            movieResponse.id,
            movieResponse.title,
            movieResponse.getPosterFullPath(),
            movieResponse.overview,
            toTimeStamp(movieResponse.releaseDate),
            movieResponse.voteAverage
        )
    }

    fun toMovieLocalDbDto(movieEntity: MovieEntity): MovieLocalDbDto {
        return MovieLocalDbDto(
            movieEntity.id,
            movieEntity.title,
            movieEntity.imageUrl,
            movieEntity.page
        )
    }

    fun toMovieDetailLocalDbDto(movieDetailEntity: MovieDetailEntity): MovieDetailLocalDbDto {
        return MovieDetailLocalDbDto(
            movieDetailEntity.id,
            movieDetailEntity.title,
            movieDetailEntity.imageUrl,
            movieDetailEntity.overview,
            movieDetailEntity.releaseDate,
            movieDetailEntity.voteAverage
        )
    }

    fun toMovieVO(movieLocalDbDto: MovieLocalDbDto): MovieVO {
        return MovieVO(
            movieLocalDbDto.id,
            movieLocalDbDto.title,
            movieLocalDbDto.imageUrl,
            movieLocalDbDto.page
        )
    }

    fun toMovieDetailVO(movieDetailLocalDbDto: MovieDetailLocalDbDto): MovieDetailVO {
        return MovieDetailVO(
            movieDetailLocalDbDto.id,
            movieDetailLocalDbDto.title,
            movieDetailLocalDbDto.imageUrl,
            movieDetailLocalDbDto.overview,
            movieDetailLocalDbDto.releaseDate,
            movieDetailLocalDbDto.voteAverage
        )
    }

    @SuppressLint("SimpleDateFormat")
    fun toTimeStamp(dateStr: String): Long {
        val formatter = SimpleDateFormat("yyyy-MM-dd")
        val d = formatter.parse(dateStr)

        return d.time
    }
}