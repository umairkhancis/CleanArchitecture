package com.noorifytech.core.datasource.backend

import com.noorifytech.core.dto.Response

interface BackendDataSource {
    suspend fun getData(): Response<String>
}