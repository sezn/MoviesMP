package com.szn.network.model.user

import kotlinx.serialization.Serializable

@Serializable
data class Account(
    val avatar: Avatar? = null,
    val id: Int,
    val include_adult: Boolean = false,
    val iso_3166_1: String? = null,
    val iso_639_1: String? = null,
    val name: String?,
    val username: String?
) {
//    constructor() : this(null, 0, true, null, null, null, null)

/*    fun getGravatar(): String {
        return BuildConfig.GRAVATAR_URL + avatar?.gravatar
    }*/
}