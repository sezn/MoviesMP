
import org.gradle.api.Plugin
import org.gradle.api.Project

class MultiPlatformConventionPlugin : Plugin<Project> {
    override fun apply(target: Project) {
        with(target) {
            with(pluginManager) {
                apply("kotlin-multiplatform")
                apply("org.jetbrains.compose")
            }
        }
    }
}