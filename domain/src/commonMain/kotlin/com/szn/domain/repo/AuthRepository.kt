package com.szn.domain.repo

import com.szn.movies.network.model.user.session.AuthResult
import kotlinx.coroutines.flow.Flow

interface AuthRepository {
    suspend fun authenticate(): Flow<AuthResult>
    suspend fun createSession(): Flow<AuthResult>
}