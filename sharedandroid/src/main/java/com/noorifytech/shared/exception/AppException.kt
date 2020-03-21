package com.noorifytech.shared.exception

open class AppException(val code: Int, val msg: String) : Exception(msg)