package com.noorifytech.feature2.repository.factory

import com.noorifytech.datasource.common.factory.RetrofitFactory
import com.noorifytech.datasource.movies.remote.MoviesRemoteBackendDataSource
import com.noorifytech.datasource.movies.remote.retrofit.TmdbService
import com.noorifytech.feature2.mapper.MovieMapper
import com.noorifytech.datasource.localdb.room.RoomDB
import com.noorifytech.feature2.repository.MoviesRepository
import com.noorifytech.feature2.repository.impl.MoviesRepositoryImpl
import com.noorifytech.shared.base.application.BaseApplication


object MoviesRepositoryFactory {

    fun getMoviesRepository(): MoviesRepository {
        val db = RoomDB.getInstance(BaseApplication.appContext)

        val backendTMDBApi = RetrofitFactory
            .getDefaultRetrofit()
            .create(TmdbService::class.java)

        val moviesBackendDataSource = MoviesRemoteBackendDataSource(backendTMDBApi)

        return MoviesRepositoryImpl(
            db.moviesDao(),
            moviesBackendDataSource,
            MovieMapper
        )
    }
}