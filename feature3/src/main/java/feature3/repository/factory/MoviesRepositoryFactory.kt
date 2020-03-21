package feature3.repository.factory

import com.noorifytech.datasource.movies.factory.MoviesBackendDataSourceFactory
import com.noorifytech.datasource.movies.factory.MoviesLocalDataSourceFactory
import com.noorifytech.shared.base.application.BaseApplication
import feature3.mapper.MovieMapper
import feature3.repository.MoviesRepository
import feature3.repository.impl.MoviesRepositoryImpl


object MoviesRepositoryFactory {

    fun getMoviesRepository(): MoviesRepository {

        val localDataSource = MoviesLocalDataSourceFactory
            .getMoviesLocalDataSource(BaseApplication.appContext)

        val moviesBackendDataSource = MoviesBackendDataSourceFactory.getMoviesBackendDataSource()

        return MoviesRepositoryImpl(localDataSource, moviesBackendDataSource, MovieMapper)
    }
}