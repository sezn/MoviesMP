package com.szn.domain.usecases

import com.szn.domain.repo.AuthRepositoryImpl
import com.szn.network.model.user.session.AuthResult
import kotlinx.coroutines.flow.Flow

class CreateGuestSessionUseCase(private val authRepository: AuthRepositoryImpl) {

    suspend fun createSession(): Flow<AuthResult> {
        return authRepository.createSession()
    }
}