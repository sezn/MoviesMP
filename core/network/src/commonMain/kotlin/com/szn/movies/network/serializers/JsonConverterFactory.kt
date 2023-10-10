package com.szn.movies.network.serializers

import com.szn.movies.network.model.ErrorResponse
import com.szn.movies.network.model.user.APIResponse
import com.szn.movies.network.model.user.AuthResult
import de.jensklingenberg.ktorfit.Ktorfit
import de.jensklingenberg.ktorfit.converter.Converter
import de.jensklingenberg.ktorfit.internal.TypeData
import io.ktor.client.call.body
import io.ktor.client.statement.HttpResponse


class JsonConverterFactory : Converter.Factory {

    override fun suspendResponseConverter(
        typeData: TypeData,
        ktorfit: Ktorfit
    ): Converter.SuspendResponseConverter<HttpResponse, *>? {

        if(typeData.typeInfo.type == AuthResult::class) {

            return object : Converter.SuspendResponseConverter<HttpResponse, Any> {
                override suspend fun convert(response: HttpResponse): Any {
                    return try {
                        APIResponse.Success(response.body())
                    } catch (ex: Throwable) {
//                        APIResponse.Error(ex)
                        throw ex
                    }
                }
            }
        }
        else if(typeData.typeInfo.type == ErrorResponse::class) {
            return object : Converter.SuspendResponseConverter<HttpResponse, Any> {
                override suspend fun convert(response: HttpResponse): Any {
                    return try {
                        APIResponse.Error(response.body(typeData.typeArgs.first().typeInfo))
                    } catch (ex: Throwable) {
//                        APIResponse.Error(ex)
                        throw ex
                    }
                }
            }
        }

        return super.suspendResponseConverter(typeData, ktorfit)
    }

/*    override fun responseConverter(
        typeData: TypeData,
        ktorfit: Ktorfit
    ): Converter.ResponseConverter<HttpResponse, *>? {
        return when (typeData.typeInfo.type) {
            AuthResponse::class -> {

                object : Converter.ResponseConverter<HttpResponse, AuthResponse> {

                    override fun convert(response: HttpResponse): AuthResponse {
                        when (val statusCode = response.status) {

                            HttpStatusCode.OK -> {
                                // Success case
                                val json = value.content.readText()
                                val authResult = ktorfit.moshi.adapter(AuthResult::class.java).fromJson(json)
                                AuthResponse.Success(authResult)
                            }
                            else -> {
                                // Error case
                                val json = value.content.readText()
                                val errorResponse = ktorfit.moshi.adapter(ErrorResponse::class.java).fromJson(json)
                                AuthResponse.Error(errorResponse)
                            }

                        }

                    }

                    override fun convert(response: suspend () -> HttpResponse): AuthResponse {
                        when (val statusCode = response.status) {

                            HttpStatusCode.OK -> {
                                // Success case
                                val json = value.content.readText()
                                val authResult = ktorfit.moshi.adapter(AuthResult::class.java).fromJson(json)
                                AuthResponse.Success(authResult)
                            }
                            else -> {
                                // Error case
                                val json = value.content.readText()
                                val errorResponse = ktorfit.moshi.adapter(ErrorResponse::class.java).fromJson(json)
                                AuthResponse.Error(errorResponse)
                            }

                        }
                    }
                }

            }
            else -> null
        }
    }*/
}
