package com.szn.network.model.user.session

data class UserSession(
    val username: String?,
    val password: String?,
    val request_token: String
)