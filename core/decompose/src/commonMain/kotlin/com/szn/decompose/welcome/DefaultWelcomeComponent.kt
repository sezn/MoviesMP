
import com.arkivanov.decompose.ComponentContext
import com.arkivanov.decompose.value.MutableValue
import com.arkivanov.decompose.value.Value
import com.arkivanov.decompose.value.update

class DefaultWelcomeComponent(
    private val componentContext: ComponentContext,
    private val onFinished: () -> Unit,
) : WelcomeComponent, ComponentContext by componentContext {

    // Consider preserving and managing the state via a store
    private val state = MutableValue(WelcomeComponent.Model())
    override val model: Value<WelcomeComponent.Model> = state

    override fun onUpdateGreetingText() {
        state.update { it.copy(greetingText = "Welcome from tt") }
    }

    override fun onBackClicked() {
        onFinished()
    }
}
