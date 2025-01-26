dependencyResolutionManagement {
    versionCatalogs {
        create("libs") {
            from(files("../gradle/libs.versions.toml"))
        }
    }
}

gradle.settingsEvaluated {
    if (JavaVersion.current() < JavaVersion.VERSION_19) {
        throw GradleException("This build requires JDK 19. It's currently ${JavaVersion.current()}.")
    }
}