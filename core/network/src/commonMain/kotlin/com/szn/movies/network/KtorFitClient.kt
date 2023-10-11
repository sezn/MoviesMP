package com.szn.movies.network

import com.szn.movies.BuildConfig
import com.szn.movies.network.serializers.SuspendResponseConverterFactory
import com.szn.network.MoviesAPI
import de.jensklingenberg.ktorfit.ktorfit
import io.ktor.client.HttpClient
import io.ktor.client.engine.cio.CIO
import io.ktor.client.plugins.UserAgent
import io.ktor.client.plugins.auth.Auth
import io.ktor.client.plugins.auth.providers.BearerTokens
import io.ktor.client.plugins.auth.providers.bearer
import io.ktor.client.plugins.contentnegotiation.ContentNegotiation
import io.ktor.client.plugins.defaultRequest
import io.ktor.client.plugins.logging.LogLevel
import io.ktor.client.plugins.logging.Logger
import io.ktor.client.plugins.logging.Logging
import io.ktor.client.request.header
import io.ktor.http.ContentType
import io.ktor.http.HttpHeaders
import io.ktor.serialization.kotlinx.json.json
import kotlinx.serialization.json.Json

val ktorfit = ktorfit {
    var bearer = true
    val token: String = BuildConfig.API_KEY +"testfail"
    println("token: $token")
    println("BuildConfig PLATFORM: ${BuildConfig.PLATFORM}")
    println("BuildConfig URL: ${BuildConfig.MOVIES_BASE_URL}")

    baseUrl(BuildConfig.MOVIES_BASE_URL)
    httpClient(HttpClient(CIO) {

        install(ContentNegotiation) {
            json(Json {
                isLenient = true
                ignoreUnknownKeys = true
                prettyPrint = true
            })
        }

        install(UserAgent) {
            agent = "Ktor"
        }

        install(Logging){
            logger = KtorLogger()
            level = LogLevel.ALL
        }

        if(bearer)
            install(Auth){
                bearer {
                    loadTokens {
                        BearerTokens(token, "")
                    }
                }
            }

        defaultRequest {
            // Set the Content-Type header for all requests
            header(HttpHeaders.ContentType, ContentType.Application.Json)
        }

/*
        HttpResponseValidator {
            validateResponse { response: HttpResponse ->
                val statusCode = response.status.value

                println("HTTP status:: $statusCode")

              *//*  when (statusCode) {
                    in 300..399 -> {
                        throw RedirectResponseException(response)
                    }
                    in 400..499 -> {
                        throw ClientRequestException(response)
                    }
                    in 500..599 -> {
                        throw ServerResponseException(response)
                    }
                }

                if (statusCode >= 600) {
                    throw ResponseException(response)
                }*//*
            }

            handleResponseException { cause: Throwable ->
                throw cause
            }
        }*/

    })
    converterFactories(
        SuspendResponseConverterFactory()
    ).build()
}

val moviesAPI = ktorfit.create<MoviesAPI>()
val authAPI = ktorfit.create<MoviesAuthAPI>()


class KtorLogger: Logger {
    override fun log(message: String) {
        println("KtorLog $message")
    }
}
