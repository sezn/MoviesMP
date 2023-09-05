package com.szn.buildlogic

import com.android.build.api.dsl.CommonExtension
import org.gradle.api.Project
import org.gradle.api.artifacts.VersionCatalogsExtension
import org.gradle.kotlin.dsl.dependencies
import org.gradle.kotlin.dsl.getByType

internal fun Project.configureKotlin(commonExtension: CommonExtension<*, *, *, *, *>,) {

    val libs = extensions.getByType<VersionCatalogsExtension>().named("libs")

    dependencies {
//        add("implementation", "org.jetbrains.kotlin:kotlin-stdlib-jdk8")
        "api"(libs.findLibrary("koin.core").get())
    }
}