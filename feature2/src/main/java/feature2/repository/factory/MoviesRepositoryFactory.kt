package feature2.repository.factory

import com.noorifytech.datasource.movies.factory.MoviesBackendDataSourceFactory
import com.noorifytech.datasource.movies.factory.MoviesLocalDataSourceFactory
import com.noorifytech.shared.base.application.BaseApplication
import feature2.mapper.MovieMapper
import feature2.repository.MoviesRepository
import feature2.repository.impl.MoviesRepositoryImpl


object MoviesRepositoryFactory {

    fun getMoviesRepository(): MoviesRepository {

        val localDataSource = MoviesLocalDataSourceFactory
            .getMoviesLocalDataSource(BaseApplication.appContext)

        val moviesBackendDataSource = MoviesBackendDataSourceFactory.getMoviesBackendDataSource()

        return MoviesRepositoryImpl(localDataSource, moviesBackendDataSource, MovieMapper)
    }
}