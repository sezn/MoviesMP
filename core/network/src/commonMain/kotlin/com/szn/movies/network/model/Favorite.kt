package com.szn.movies.network.model

import kotlinx.serialization.Serializable

@Serializable
data class Favorite(
    val favorite: Boolean,
    val media_id: Int,
    val media_type: String
)