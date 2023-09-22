package com.szn.domain.usecases

import com.szn.domain.repo.AuthRepositoryImpl
import com.szn.movies.network.model.user.session.AuthResult
import kotlinx.coroutines.flow.Flow

class AuthenticateUserUseCase(private val authRepository: AuthRepositoryImpl) {

    suspend fun authenticate(username: String, password: String): Flow<AuthResult> {
        val authResult = authRepository.authenticate()
        // Store the authentication result in a secure location
        return authResult
    }
}