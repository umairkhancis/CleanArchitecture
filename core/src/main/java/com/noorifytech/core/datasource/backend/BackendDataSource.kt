package com.noorifytech.core.datasource.backend

import com.noorifytech.core.dto.backend.Response

interface BackendDataSource {
    suspend fun getData(): Response<String>
}