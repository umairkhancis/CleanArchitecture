package com.noorifytech.shared.extensions

import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext


suspend fun <T> background(block: suspend CoroutineScope.() -> T): T =
    withContext(Dispatchers.IO) { block() }