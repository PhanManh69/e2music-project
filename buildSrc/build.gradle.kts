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
    implementation(libs.navigation.safe.args.gradle.plugin)
}
