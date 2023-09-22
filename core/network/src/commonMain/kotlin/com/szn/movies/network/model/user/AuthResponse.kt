package com.szn.movies.network.model.user

import com.szn.movies.network.model.ErrorResponse
import com.szn.movies.network.model.user.session.AuthResult

sealed class AuthResponse {
    data class Success(val authResult: AuthResult) : AuthResponse()
    data class Error(val errorResponse: ErrorResponse) : AuthResponse()
}