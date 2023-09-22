package com.szn.movies.network.model

import kotlinx.serialization.Serializable

@Serializable
data class ErrorResponse(
    val status_code: Int,
    val status_message: String,
    val success: Boolean
): Throwable()