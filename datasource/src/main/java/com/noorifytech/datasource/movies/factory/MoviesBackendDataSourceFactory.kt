package com.noorifytech.datasource.movies.factory

import com.noorifytech.core.datasource.moviesbackend.MoviesBackendDataSource
import com.noorifytech.datasource.common.factory.RetrofitFactory
import com.noorifytech.datasource.movies.remote.MoviesRemoteBackendDataSource
import com.noorifytech.datasource.movies.remote.retrofit.TmdbService

object MoviesBackendDataSourceFactory {
    fun getMoviesBackendDataSource(): MoviesBackendDataSource {
        val backendTMDBApi = RetrofitFactory
            .getDefaultRetrofit()
            .create(TmdbService::class.java)

        return MoviesRemoteBackendDataSource(backendTMDBApi)
    }
}