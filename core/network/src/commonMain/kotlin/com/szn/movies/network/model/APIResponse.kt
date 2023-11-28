package com.szn.movies.network.model

import kotlinx.serialization.Serializable

@Serializable
sealed class APIResponse<T> {

    data class Success<T>(val data: T) : APIResponse<T>()
    class Error(val ex:ErrorResponse) : APIResponse<ErrorResponse>()

    companion object {
        fun <T> success(data: T) = Success(data)
        fun error(ex: ErrorResponse) = Error(ex)
    }
}