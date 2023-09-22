plugins {
    kotlin("multiplatform")
    id("com.android.library")
    alias(libs.plugins.kotlin.serialization)
    alias(libs.plugins.ktorfit)
    alias(libs.plugins.ksp)
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
                implementation(libs.kotlinx.coroutines)
                implementation(libs.kotlinx.serialization.json)
                implementation(libs.ktor.cio)
                implementation(libs.ktor.core)
                implementation(libs.ktor.logging)
                implementation(libs.ktor.negociation)
                implementation(libs.ktor.serialization)
                implementation(libs.ktor.serialization.json)
                implementation(libs.ktorfit)
//                implementation(libs.ktorfit.ksp)
                implementation(libs.logback)
            }
        }
    }

}

android {
    namespace = "com.szn.movies.network"
    compileSdk = 34
}

dependencies {
//    implementation(libs.ktorfit)

    with("de.jensklingenberg.ktorfit:ktorfit-ksp:1.6.0") {
        add("kspCommonMainMetadata", this)
        add("kspJvm", this)
//        add("kspJvmTest", this)
        add("kspAndroid", this)
//        add("kspAndroidTest", this)
        add("kspIosX64", this)
//        add("kspIosX64Test", this)
        add("kspIosArm64", this)
//        add("kspIosArm64Test", this)
        add("kspIosSimulatorArm64", this)
//        add("kspIosSimulatorArm64Test", this)
//        add("kspMacosX64", this)
//        add("kspMacosX64Test", this)
//        add("kspJs", this)
//        add("kspJsTest", this)
    }

}
