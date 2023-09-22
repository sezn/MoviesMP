package com.szn.domain.repo

import com.szn.domain.mappers.NetworkUserMapper
import com.szn.domain.model.User
import com.szn.network.MoviesAuthAPI
import com.szn.network.model.user.session.AuthResult
import com.szn.network.model.user.session.UserSession
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.map
import kotlinx.coroutines.flow.emptyFlow

class AuthRepositoryImpl(private val networkService: MoviesAuthAPI): AuthRepository {
    override suspend fun authenticate(): Flow<AuthResult> {
        return networkService.authenticate()
    }

    override suspend fun createSession(): Flow<AuthResult> {
        return networkService.createSession()
    }

/*    suspend fun signIn(session: UserSession): Flow<User> {
        return networkService.signIn(session)
            .map { it.body()!! }
            .map { NetworkUserMapper.toDomainUser(it) }
            .catch { e -> emit(Result.failure(e)) }
    }*/

/*    suspend fun forgot(email: String): Flow<Unit> {
        return networkService.forgot(email)
            .catch { e -> emit(Result.failure(e)) }
    }*/

    suspend fun getSessionId(): Flow<String?> {
        // TODO: Implement this method to get the current session ID from storage.
        return emptyFlow()
    }

    suspend fun logout() {
        // TODO: Implement this method to clear the current session ID from storage.
    }

}