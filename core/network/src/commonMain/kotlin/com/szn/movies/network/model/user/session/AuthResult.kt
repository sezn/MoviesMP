package com.szn.movies.network.model.user.session

import com.szn.movies.network.model.ErrorResponse
import kotlinx.serialization.Serializable

@Serializable
data class AuthResult(
    val expires_at: String?,
    val request_token: String?,
    val success: Boolean?,
    val session_id: String? = null,
    val error: ErrorResponse? = null
)