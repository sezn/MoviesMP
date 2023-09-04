
import kotlinx.serialization.Serializable

@Serializable
data class Response(
    val success: Boolean,
    val status_code: Int,
    val status_message: String
)