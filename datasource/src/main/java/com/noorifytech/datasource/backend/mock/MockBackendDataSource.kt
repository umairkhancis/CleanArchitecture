package com.noorifytech.datasource.backend.mock

import com.noorifytech.core.datasource.backend.BackendDataSource
import com.noorifytech.core.dto.backend.Response

class MockBackendDataSource : BackendDataSource {
    private val data = arrayOf(
        "This is data from memory 1".reversed(),
        "This is data from memory 2".reversed(),
        "This is data from memory 3".reversed(),
        "This is data from memory 4".reversed(),
        "This is data from memory 5".reversed()
    )

    override suspend fun getData(): Response<String> {
        Thread.sleep(5000) // simulate network delay
        return Response(
            data = data[count++ % 4],
            statusCode = 200
        )
    }

    companion object {
        var count = 0
    }
}