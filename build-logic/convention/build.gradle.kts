plugins {
    `kotlin-dsl`

    id("java-gradle-plugin")
    id("org.jetbrains.kotlin.jvm").version("1.6.21")
}


dependencies {
    compileOnly(libs.android.gradlePlugin)
    compileOnly(libs.kotlin.gradlePlugin)
    compileOnly(libs.ksp.gradlePlugin)
}

gradlePlugin {
    plugins {

        register("Library") {
            id = "multiplatform.library"
            implementationClass = "LibraryConventionPlugin"
        }

        register("MultiplatformConvention") {
            id = "multiplatform.convention"
            implementationClass = "MultiPlatformConventionPlugin"
        }

        register("LibraryCompose") {
            id = "library.compose"
            implementationClass = "LibraryComposeConventionPlugin"
        }

    }
}
