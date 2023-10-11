import com.github.gmazzo.gradle.plugins.BuildConfigSourceSet
import org.jetbrains.kotlin.gradle.plugin.extraProperties
import java.lang.System

plugins {
    kotlin("multiplatform")
    id("com.android.library")
    alias(libs.plugins.ksp)
    id("com.github.gmazzo.buildconfig").version("4.1.2")
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
//                implementation("com.github.holgerbrandl:kotlin-config:3.0.0")
            }
        }
    }

}

android {
    namespace = "com.szn.movies"
    compileSdk = 34
}


buildConfig {
    packageName("com.szn.movies")
    buildConfigField("String", "MOVIES_BASE_URL", "\"https://api.themoviedb.org/\"")
    buildConfigField("String", "PLATFORM", "\"common\"")
    val token = System.getenv("MOVIES_TOKEN") ?: "\"fail\""
    buildConfigField("String", "MOVIES_TOKEN", token)
    buildConfigField("long", "BUILD_TIME", "${System.currentTimeMillis()}L")
    buildConfigField("String", "API_KEY",  "\"${getApiKey()}\"")

    println("SourcesSets: ${sourceSets.names}")

    sourceSets.named<BuildConfigSourceSet>("androidMain") {
        buildConfigField("String", "PLATFORM", "\"android\"")
        buildConfigField("String", "MOVIES_BASE_URL", "\"https://api.themoviedb.org/\"")
    }
    sourceSets.named<BuildConfigSourceSet>("jvmMain") {
        buildConfigField("String", "PLATFORM", "\"jvm\"")
        buildConfigField("String", "MOVIES_BASE_URL", "\"http://api.themoviedb.org/\"")
    }

    sourceSets.named<BuildConfigSourceSet>("iosMain") {
        buildConfigField("String", "PLATFORM", "\"ios\"")
        buildConfigField("String", "MOVIES_BASE_URL", "\"http://api.themoviedb.org/\"")
    }
    useKotlinOutput { topLevelConstants = true }
    useKotlinOutput { internalVisibility = false }   // remove `internal` modifier to all declarations

//    writeEnvironmentVariablesToBuildConfig(project)

/*    for ((key, value) in System.getenv()) {
        println("Found env var $key $value")
        if (!key.contains('.')) {
            buildConfigField("String", "$key", "\"$value\"")
        } else
            println("cant add env var $key $value")
    }*/
}

fun getApiKey(): String {
    println("MOVIES_TOKEN: ${System.getenv("MOVIES_TOKEN")}")
    // Check if the API key is defined in the environment
    val key = System.getProperty("MOVIES_TOKEN") ?: System.getenv("MOVIES_TOKEN")
    if (key != null) {
        return key
    }

    // Check if the API key is defined in the file
    val FILE_NAME = "API.properties"
    val file = rootProject.file(FILE_NAME)
    if (file.exists()) {
        println("Found token in $FILE_NAME")
        val properties = file.readLines().map { it.split("=") }
        return properties.associate { it[0] to it[1] }["token"] ?: throw IllegalArgumentException("api_key not found in $FILE_NAME")
    }

    // If the API key is not defined in either the environment or the file, throw an exception
    throw IllegalArgumentException("API_KEY not found in system properties, environment variables, or API.properties file")
}

/*
fun writeEnvironmentVariablesToBuildConfig(project: Project) {
    val buildConfigFields = mutableMapOf<String, String>()
    for ((key, value) in System.getenv()) {
        println("Found env var $key $value")
//        buildConfigFields["$key.toUpperCase()"] = value
        buildConfigFields["$key.toUpperCase()"] = value
        project.buildConfig.buildConfigFields.add(buildConfigField(key.toUpperCase(), value))
    }
//    project.buildConfig.buildConfigFields.addAll(buildConfigFieldObjects)
//    project.extensions.getByType<com.android.build.gradle.BaseExtension>().buildConfigField("FIELDS", buildConfigFields)
}*/
