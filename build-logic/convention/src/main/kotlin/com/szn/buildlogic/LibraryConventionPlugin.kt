
import com.android.build.gradle.LibraryExtension
import com.szn.buildlogic.configureKotlin
import org.gradle.api.Plugin
import org.gradle.api.Project
import org.gradle.kotlin.dsl.configure

class LibraryConventionPlugin : Plugin<Project> {
    override fun apply(target: Project) {
        with(target) {
            with(pluginManager) {
                apply("com.android.library")
//                apply("org.jetbrains.kotlin.android")
                apply("kotlinx-serialization")
            }
            extensions.configure<LibraryExtension> {
                configureKotlin(this)
            }

            target.task("hello") {
                doLast {
                    println("Hello from LibraryConventionPlugin")
                }
            }

        }
    }
}