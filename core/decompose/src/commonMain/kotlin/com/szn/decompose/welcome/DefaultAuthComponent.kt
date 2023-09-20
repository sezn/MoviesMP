
import com.arkivanov.decompose.ComponentContext
import com.arkivanov.decompose.value.MutableValue
import com.arkivanov.decompose.value.Value
import com.arkivanov.decompose.value.update

class DefaultAuthComponent(
    private val componentContext: ComponentContext,
    private val onFinished: () -> Unit,
) : AuthComponent, ComponentContext by componentContext {

    // Consider preserving and managing the state via a store
    private val state = MutableValue(AuthComponent.Model())
    override val model: Value<AuthComponent.Model> = state
    override fun onLogin(name: String, pwd: String) {
        println("Login: $name / $pwd")
        TODO("Not yet implemented $name")
    }

    override fun onForgot(name: String) {
        TODO("Not yet implemented")
    }

/*    override fun onUpdateGreetingText() {
        state.update { it.copy(greetingText = "Welcome from tt") }
    }*/

    override fun onBackClicked() {
        onFinished()
    }
}
