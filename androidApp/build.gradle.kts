plugins {
    id("com.android.application")
    id("multiplatform.convention")
}

kotlin {
    androidTarget()
    sourceSets {
        val androidMain by getting {
            dependencies {
                implementation(project(":domain"))
                implementation(project(":shared"))
                implementation(project(":core:decompose"))
                implementation(libs.koin.android)
                implementation(libs.koin.core)

                implementation(project(":core:buildconfig"))
            }
        }
    }
}

android {
    compileSdk = (findProperty("android.compileSdk") as String).toInt()
    namespace = "com.szn.movies.android"

    sourceSets["main"].manifest.srcFile("src/androidMain/AndroidManifest.xml")
//    sourceSets["main"].manifest.srcFile("src/debug/AndroidManifest.xml")
//    sourceSets["main"].res.srcDirs("src/debug/res")
    android.buildFeatures.buildConfig=true
    defaultConfig {
        applicationId = "com.szn.movies.android"
        minSdk = (findProperty("android.minSdk") as String).toInt()
        targetSdk = (findProperty("android.targetSdk") as String).toInt()
        versionCode = 1
        versionName = "1.0"
    }

    buildTypes {
        val release by getting {
            isDebuggable = false
            isMinifyEnabled = true
        }
        getByName("debug") {
            isDebuggable = true
            applicationIdSuffix = ".dev"
//            sourceSets["main"].manifest.srcFile("src/debug/AndroidManifest.xml")
//            sourceSets["main"].res.srcDirs("src/debug/res")
        }
    }
    packaging {
        exclude("META-INF/INDEX.LIST")
    }
}
