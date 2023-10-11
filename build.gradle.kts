buildscript {
    val MOVIES_TOKEN by extra("eyJhbGciOiJIUzI1NiJ9.eyJhdWQiOiJjODgxYjIwZGU0YjUyNTU0ZTNmZjBiMjRmZWNjMTA0OSIsInN1YiI6IjVkZDU2ZTMwMjYzNDYyMDAxMmI3YjA5ZiIsInNjb3BlcyI6WyJhcGlfcmVhZCJdLCJ2ZXJzaW9uIjoxfQ.uvcJnoxHVUiUi-8JztFEMRpkm3BlndwoTKRl1n_n5L0")
    val STUDIO_TOKEN by extra("studio_token_test")
}
plugins {
    // this is necessary to avoid the plugins to be loaded multiple times
    // in each subproject's classloader
    kotlin("multiplatform").apply(false)
    id("com.android.application").apply(false)
    id("com.android.library").apply(false)
    id("org.jetbrains.compose").apply(false)
    alias(libs.plugins.kotlin.dsl) apply false
    alias(libs.plugins.kotlin.serialization) apply false
    alias(libs.plugins.kotlin.parcelize).apply(false)
    alias(libs.plugins.ksp) apply false
}
val STUDIO_TOKEN by extra("studio_token_test_project")

subprojects {
    afterEvaluate {
        extensions.findByType<org.jetbrains.kotlin.gradle.dsl.KotlinProjectExtension>()?.apply {
            jvmToolchain(17)
        }
    }
}