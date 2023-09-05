plugins {
    `kotlin-dsl`
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

    }
}