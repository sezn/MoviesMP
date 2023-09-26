package com.szn.movies.network.serializers

/*


class JsonConverterFactory : Converter.Factory {

    override fun responseConverter(
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
    }
}*/
