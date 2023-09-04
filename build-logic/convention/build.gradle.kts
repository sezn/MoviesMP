plugins {
    `kotlin-dsl`
}

gradlePlugin {
    plugins {

        register("Library") {
            id = "multiplatform.library"
            implementationClass = "LibraryConventionPlugin"
        }

        register("MultiplatformConvention") {
            id = "multiplatform.convention"
            implementationClass = "MultiPlatformConventionPlugin"
        }

    }
}