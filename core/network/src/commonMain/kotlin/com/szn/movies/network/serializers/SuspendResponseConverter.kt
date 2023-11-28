package com.szn.movies.network.serializers

import com.szn.movies.network.model.APIResponse
import com.szn.movies.network.model.ErrorResponse
import de.jensklingenberg.ktorfit.Ktorfit
import de.jensklingenberg.ktorfit.converter.Converter
import de.jensklingenberg.ktorfit.internal.TypeData
import io.ktor.client.call.body
import io.ktor.client.statement.HttpResponse

class SuspendResponseConverterFactory: Converter.Factory {

    private var should = true

    override fun suspendResponseConverter(
        typeData: TypeData,
        ktorfit: Ktorfit
    ): Converter.SuspendResponseConverter<HttpResponse, *>? {
        if(typeData.typeInfo.type == APIResponse::class) {

            return object : Converter.SuspendResponseConverter<HttpResponse, Any> {

                override suspend fun convert(response: HttpResponse): Any {
                    println("Converter: ${typeData.typeInfo.type}")

                    if (should && response.status.value == 401) {
                        println("Converter Error: 401")
                        // Handle the 401 Unauthorized error case here.
                        return APIResponse.error(response.body(typeData.typeArgs.first().typeInfo))

                        // Parse the response body and return an ErrorResponse object.
//                        val errorResponse = ktorfit.jsonConverter.fromJson<ErrorResponse>(response.body())
//                        return APIResponse.error(errorResponse)
                    }

                    return try {
                        APIResponse.success(response.body(typeData.typeArgs.first().typeInfo))
                    } catch (ex: Throwable) {
                        println("Catch Error: $ex")
                        ex.printStackTrace()
                        APIResponse.error(ex as ErrorResponse)
                    }
                }
            }
        }
        return null
    }
}