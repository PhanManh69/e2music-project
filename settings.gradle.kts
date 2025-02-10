@file:Suppress("UnstableApiUsage")

include(":dashboard-domain:home")


include(":dashboard-domain:dashboard")



pluginManagement {
    repositories {
        google {
            content {
                includeGroupByRegex("com\\.android.*")
                includeGroupByRegex("com\\.google.*")
                includeGroupByRegex("androidx.*")
            }
        }
        mavenCentral()
        gradlePluginPortal()
    }
}
dependencyResolutionManagement {
    repositoriesMode.set(RepositoriesMode.FAIL_ON_PROJECT_REPOS)
    repositories {
        google()
        mavenCentral()
        maven { setUrl("https://jitpack.io") }
    }
}

rootProject.name = "E2Music"
include(":app")
include(":core:ui")
include(":core:datasource")
include(":main")
include(":account")
include(":dashboard-domain:dashboard")
include(":dashboard-domain:home")
