package com.szn.movies.network.model.user

import kotlinx.serialization.Serializable

@Serializable
data class AuthResult(
    val expires_at: String? = null,
    val request_token: String? = null,
    val success: Boolean?,
    val session_id: String? = null
)