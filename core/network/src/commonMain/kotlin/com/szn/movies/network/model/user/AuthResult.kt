package com.szn.movies.network.model.user

import kotlinx.serialization.Serializable

@Serializable
data class AuthResult(
    val expires_at: String?,
    val request_token: String?,
    val success: Boolean?,
    val session_id: String? = null
)