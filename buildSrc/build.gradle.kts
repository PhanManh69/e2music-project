plugins {
    `kotlin-dsl`
    `kotlin-dsl-precompiled-script-plugins`
}

repositories {
    gradlePluginPortal()
    google()
    mavenCentral()
}

dependencies {
    implementation(libs.build.gradle)
    implementation(libs.kotlin.gradle.plugin)
    implementation(libs.kotlin.plugin.serialization)
    implementation(libs.navigation.safe.args.gradle.plugin)
    implementation(libs.ktlint.gradle)
    implementation(libs.google.services)
}
