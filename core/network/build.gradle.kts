plugins {
//    alias(libs.plugins.ksp)
    kotlin("native.cocoapods")
    id("com.android.library")
    id("multiplatform.convention")
    id("multiplatform.library")
}

kotlin {
    androidTarget()
    jvm("desktop")
    listOf(
        iosX64(),
        iosArm64(),
        iosSimulatorArm64()
    )
    cocoapods {
        version = "1.0.0"
    }


    sourceSets {

        sourceSets["commonMain"].dependencies {
            implementation(libs.kotlinx.serialization.json)
            implementation(libs.ktor.serialization)
            implementation(libs.ktor.serialization.json)
        }
    }
}


android {
    namespace = "com.szn.network"
    compileSdk = 34
}
/*
dependencies {
    implementation(libs.kotlinx.serialization.json)
    implementation(libs.ktor.auth)
    implementation(libs.ktor.fit)
    implementation(libs.ktor.logging)
    implementation(libs.ktor.negociation)
    implementation(libs.ktor.okhttp)
    implementation(libs.ktor.serialization)
    implementation(libs.ktor.serialization.json)
//    add("ksp", libs.ktorfit.ksp)
}*/
