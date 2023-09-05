package com.szn.network

import de.jensklingenberg.ktorfit.converter.builtin.CallConverterFactory
import de.jensklingenberg.ktorfit.converter.builtin.FlowConverterFactory
import de.jensklingenberg.ktorfit.ktorfit
import io.ktor.client.HttpClient
import io.ktor.client.plugins.contentnegotiation.ContentNegotiation
import io.ktor.serialization.kotlinx.json.json
import kotlinx.serialization.json.Json

val ktorfit = ktorfit {
    baseUrl(MoviesAPI.baseUrl)
    httpClient(HttpClient {
        install(ContentNegotiation) {
            json(Json { isLenient = true; ignoreUnknownKeys = true })
        }
    })
    converterFactories(
        FlowConverterFactory(),
        CallConverterFactory()
    )
}

val moviesAPI = ktorfit.create<MoviesAPI>()