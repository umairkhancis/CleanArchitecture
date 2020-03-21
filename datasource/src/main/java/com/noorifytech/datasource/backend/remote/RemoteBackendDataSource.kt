package com.noorifytech.datasource.backend.remote

import com.noorifytech.core.datasource.backend.BackendDataSource
import com.noorifytech.core.dto.backend.Response

class RemoteBackendDataSource : BackendDataSource {
    override suspend fun getData(): Response<String> {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }
}