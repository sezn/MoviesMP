package com.szn.network

import com.szn.movies.network.MoviesAuthAPI
import de.jensklingenberg.ktorfit.converter.builtin.CallConverterFactory
import de.jensklingenberg.ktorfit.converter.builtin.FlowConverterFactory
import de.jensklingenberg.ktorfit.ktorfit
import io.ktor.client.HttpClient
import io.ktor.client.plugins.contentnegotiation.ContentNegotiation
import io.ktor.client.plugins.logging.LogLevel
import io.ktor.client.plugins.logging.Logger
import io.ktor.client.plugins.logging.Logging
import io.ktor.serialization.kotlinx.json.json
import kotlinx.serialization.json.Json


val ktorfit = ktorfit {
    baseUrl(MoviesAPI.baseUrl)
    httpClient(HttpClient {
        install(ContentNegotiation) {
            json(Json { isLenient = true; ignoreUnknownKeys = true })
        }

        install(Logging){
            logger = KtorLogger()
            level = LogLevel.ALL
        }

    })
    converterFactories(
        FlowConverterFactory(),
        CallConverterFactory()
    )
}

val moviesAPI = ktorfit.create<MoviesAPI>()
val authAPI = ktorfit.create<MoviesAuthAPI>()


class KtorLogger: Logger {
    override fun log(message: String) {
        println("KtorLog $message")
    }
}