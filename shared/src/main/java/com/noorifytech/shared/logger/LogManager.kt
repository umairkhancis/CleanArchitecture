package com.noorifytech.shared.logger

import android.util.Log

object LogManager {
    fun info(tag: String, message: String) =
        Log.i(tag, message)

    fun error(tag: String, message: String = "", throwable: Throwable? = null) =
        Log.e(tag, message, throwable)

    fun warning(tag: String, message: String = "", throwable: Throwable? = null) =
        Log.w(tag, message, throwable)

    fun debug(tag: String, message: String = "", throwable: Throwable? = null) =
        Log.d(tag, message, throwable)
}