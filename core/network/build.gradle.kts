plugins {
    alias(libs.plugins.ksp)
    alias(libs.plugins.ktorfit)
    alias(libs.plugins.kotlin.serialization)
    kotlin("multiplatform")
    id("com.android.library")
}

kotlin {
    androidTarget()
    jvm("desktop")
    listOf(
        iosX64(),
        iosArm64(),
        iosSimulatorArm64()
    )

    sourceSets {

        sourceSets["commonMain"].dependencies {
            implementation(libs.kotlinx.serialization.json)
            implementation(libs.ktor.negociation)
            implementation(libs.ktor.serialization)
            implementation(libs.ktor.serialization.json)
            implementation(libs.ktorfit)
        }
    }
}


android {
    namespace = "com.szn.network"
    compileSdk = 34
}