package com.szn.movies.network.model.user

import com.szn.movies.network.model.ErrorResponse
import kotlinx.serialization.Serializable

@Serializable
sealed class APIResponse {

    @Serializable
    data class Success(val authResult: AuthResult) : APIResponse()

    @Serializable
    data class Error(val errorResponse: ErrorResponse) : APIResponse()
}