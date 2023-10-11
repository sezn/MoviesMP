package com.szn.movies.network.serializers

import com.szn.movies.network.model.APIResponse
import de.jensklingenberg.ktorfit.Ktorfit
import de.jensklingenberg.ktorfit.converter.Converter
import de.jensklingenberg.ktorfit.internal.TypeData
import io.ktor.client.call.body
import io.ktor.client.statement.HttpResponse

class SuspendResponseConverterFactory: Converter.Factory {

    override fun suspendResponseConverter(
        typeData: TypeData,
        ktorfit: Ktorfit
    ): Converter.SuspendResponseConverter<HttpResponse, *>? {
        if(typeData.typeInfo.type == APIResponse::class) {

            return object : Converter.SuspendResponseConverter<HttpResponse, Any> {

                override suspend fun convert(response: HttpResponse): Any {
                    return try {
                        APIResponse.success(response.body(typeData.typeArgs.first().typeInfo))
                    } catch (ex: Throwable) {
                        println("Catch Error: $ex")
                        ex.printStackTrace()
                        APIResponse.error(ex)
                    }
                }
            }
        }
        return null
    }
}