package com.szn.domain.repo

import com.szn.movies.network.MoviesAuthAPI
import com.szn.movies.network.model.user.session.AuthResult
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.emptyFlow

class AuthRepositoryImpl(private val networkService: MoviesAuthAPI): AuthRepository {
    override suspend fun authenticate(): Flow<AuthResult> {
        return networkService.authenticate()
    }

    suspend fun auth(){
//        try {
            val authResponse = networkService.auth()
            println("authResponse ${authResponse}")
       /*     when (authResponse) {
                is AuthResponse.Success -> {
                    // Handle the success response
//                    return response.authResult
                    println("authResponse: ${authResponse.authResult}")
                }
                is AuthResponse.Error -> {
                    // Handle the error response
//                    throw response.errorResponse
                    println("authResponse:: ${authResponse.errorResponse}")
                }
            }*/
           /* when (authResponse) {
                is AuthResponse.Success -> {
                    // Handle successful response
                    println("authResponse: ${authResponse.authResult}")
                }
                is AuthResponse.Error -> {
                    // Handle error response
                    if (authResponse.errorResponse.status_code == 7) {
                        // Invalid API key error
                        println("authResponse Invalid API key error")
                    } else {
                        // Other error
                        println("authResponse Other error")
                    }
                }
            }*/


        /*}  catch (e: Exception) {
            // Handle JsonConvertException
            println("authResponse Uncaught error")
            e.printStackTrace()
        }*/
    }

    suspend fun authBis() {
        val authResponse = networkService.authenticate().collect{
            println("authResponse: $it")
        }
        println("authResponse ${authResponse}")
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