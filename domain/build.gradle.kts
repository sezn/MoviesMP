plugins {
    kotlin("multiplatform")
    id("com.android.library")
}

kotlin {

    androidTarget()
    jvm()
    listOf(
        iosX64(),
        iosArm64(),
        iosSimulatorArm64()
    ).forEach {
        it.binaries.framework {
            baseName = "domain"
        }
    }

    sourceSets {
        val commonMain by getting {
            dependencies {
                //put your multiplatform dependencies here
//                implementation(project(":core:network"))
            }
        }
    }
}

android {
    namespace = "com.szn.domain"
    compileSdk = 33
    defaultConfig {
        minSdk = 24
    }

    kotlin {
        jvmToolchain(17)
    }
}