plugins {
    id("base-android-library-module")
}

android {
    buildFeatures {
        compose = true
        buildConfig = true
    }

    composeOptions {
        kotlinCompilerExtensionVersion = AppConfig.KOTLIN_COMPILER_EXT
    }

}

dependencies {
    implementation(project(mapOf("path" to ":core:ui")))
    implementation(project(mapOf("path" to ":core:datasource")))

    // Compose dependencies
    implementation(platform(vc.composeBom))
    implementation(vc.bundleCompose)
    implementation(vc.androidXMaterial3)
    implementation(vc.bundleCoilKt)
    implementation(vc.bundleMoshi)
    implementation(vc.bundleKoin)

    // Test dependencies
    testImplementation(vc.jUnit)
    androidTestImplementation(vc.androidxJunit)
    androidTestImplementation(platform(vc.composeBom))

    // Send mail
    implementation(vc.bundleSumMail)
}
