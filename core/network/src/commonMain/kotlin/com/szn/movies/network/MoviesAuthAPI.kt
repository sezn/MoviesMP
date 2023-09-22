package com.szn.network

import com.szn.network.model.user.Account
import com.szn.network.model.user.session.AuthResult
import de.jensklingenberg.ktorfit.Response
import de.jensklingenberg.ktorfit.http.Body
import de.jensklingenberg.ktorfit.http.DELETE
import de.jensklingenberg.ktorfit.http.GET
import de.jensklingenberg.ktorfit.http.Headers
import de.jensklingenberg.ktorfit.http.POST
import de.jensklingenberg.ktorfit.http.Query
import kotlinx.coroutines.flow.Flow

interface MoviesAuthAPI {
    @GET("3/authentication/token/new")
    suspend fun authenticate(): Flow<AuthResult>

    @GET("3/authentication/token/new")
    suspend fun auth(): AuthResult

    /**
     * This method will let you create a new guest session.
     * Guest sessions are a type of session that will let a user rate movies
     * and TV shows but not require them to have a TMDB user account
     */
    @POST("3/authentication/guest_session/new")
    suspend fun createSession(): Flow<AuthResult>

 /*   @POST("3/authentication/session/new")
    @Headers("content-type: application/json")
    suspend fun getSessionId(@Body params: RequestBody): AuthResult

    *//**
     * This method allows an application to validate a request token by entering a username and password.
     * @param username
     * @param password
     * @param request_token
     *//*
    @POST("3/authentication/token/validate_with_login")
    @Headers("content-type: application/json")
    suspend fun signIn(@Body params: RequestBody): Flow<Response<AuthResult>>*/

    @GET("3/account")
    suspend fun getAccount(@Query("session_id") sessId: String): Account

    @DELETE("3/authentication/session")
    suspend fun logout(@Query("session_id") sessId: String): Response<AuthResult>
}