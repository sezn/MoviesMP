plugins {
    kotlin("multiplatform")
    id("com.android.library")
    alias(libs.plugins.ksp)
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
                implementation(libs.koin.core)
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
