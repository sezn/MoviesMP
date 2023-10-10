package com.szn.movies.network.model

import kotlinx.serialization.Serializable

@Serializable
sealed class APIResponse<T> {

//    @Serializable
    data class Success<T>(val data: T) : APIResponse<T>()

//    @Serializable
    data class Error(val error: ErrorResponse) : APIResponse<Nothing>()

}