package com.noorifytech.core.datasource.localdb

interface LocalDbDataSource {
    suspend fun getData(): String
}