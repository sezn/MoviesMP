plugins {
    kotlin("multiplatform")
    id("com.android.library")
    alias(libs.plugins.ksp)
    alias(libs.plugins.kotlin.serialization)
}

kotlin {

    androidTarget()
    jvm()
    iosX64()
    iosArm64()
    iosSimulatorArm64()

    sourceSets {
        val commonMain by getting {
            dependencies {
                implementation(libs.kotlinx.coroutines)
                implementation(libs.kotlinx.serialization.json)
                implementation(libs.koin.core)
                implementation(libs.ktor.serialization)
                implementation(libs.ktor.serialization.json)
                api(project(":core:network"))
            }
        }
    }
}

android {
    namespace = "com.szn.domain"
    compileSdk = 34
}

dependencies {
    //put your multiplatform dependencies here
//    implementation(project(":core:network"))
}
