plugins {
    kotlin("multiplatform")
    id("com.android.library")
    id("library.compose")

    id("multiplatform.convention")
    id("multiplatform.library")
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
//                implementation(compose.runtime)
//                implementation(compose.foundation)
                implementation(compose.material3)
            }
        }

        val androidMain by getting {
            dependencies {
                implementation(libs.androidx.compose.ui.tooling.preview)
            }
        }
    }
}

android {
    namespace = "com.szn.design"
    compileSdk = 34
}

dependencies {
    debugImplementation(libs.androidx.compose.ui.tooling)
}
