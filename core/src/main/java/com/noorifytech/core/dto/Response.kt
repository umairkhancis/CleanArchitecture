package com.noorifytech.core.dto

import com.google.gson.annotations.SerializedName

data class Response<T>(
    @SerializedName("data")
    val data: T,

    @SerializedName("code")
    val statusCode: Int,

    @SerializedName("errorCode")
    val errorCode: Int? = null,

    @SerializedName("message")
    val message: String? = null
)