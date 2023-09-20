plugins {
    kotlin("multiplatform")
    id("com.android.library")
    id("library.compose")

    id("multiplatform.convention")
    id("multiplatform.library")
    alias(libs.plugins.ksp)
    alias(libs.plugins.kotlin.parcelize)
}


kotlin {
    targetHierarchy.default()

    androidTarget()
    jvm()
    ios()
    iosX64()
    iosArm64()
    iosSimulatorArm64()

    sourceSets {
        val commonMain by getting {
            dependencies {
                implementation(compose.runtime)
                implementation(compose.foundation)
                implementation(libs.decompose)
                implementation(libs.decompose.jetbrains)
            }
        }
    }
}

android {
    namespace = "com.szn.decompose"
    compileSdk = 34
}
