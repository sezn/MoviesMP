package com.szn.movies.network.model.user.session

import kotlinx.serialization.Serializable

@Serializable
data class UserSession(
    val username: String?,
    val password: String?,
    val request_token: String
)