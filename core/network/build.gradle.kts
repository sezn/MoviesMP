plugins {
    alias(libs.plugins.ksp)
    id("org.jetbrains.kotlin.plugin.serialization")
    id("multiplatform.library")
}


android {
    namespace = "com.szn.network"

    defaultConfig {
        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
        compileSdk = 34
        buildFeatures {
            buildConfig = true
        }
//        buildConfigField("String", "MOVIES_BASE_URL", "\"https://api.themoviedb.org/\"")
//        buildConfigField("String", "IMAGE_BASE", "\"https://image.tmdb.org/t/p/w500\"")
//        buildConfigField("String", "API_KEY", getApiKey())
//        buildConfigField("String", "GRAVATAR_URL", "\"https://gravatar.com/avatar/\"")
    }
}

dependencies {
    implementation(libs.kotlinx.serialization.json)

}