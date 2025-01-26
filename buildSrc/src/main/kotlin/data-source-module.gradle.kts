import org.gradle.api.JavaVersion

plugins {
    id("com.android.library")
    kotlin("android")
    kotlin("kapt")
}

android {
    compileSdk = AppConfig.COMPILE_SDK

    defaultConfig {
        minSdk = AppConfig.MIN_SDK
        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
    }

    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_19
        targetCompatibility = JavaVersion.VERSION_19
    }

    kotlinOptions {
        jvmTarget = "19"
    }

    buildFeatures {
        buildConfig = true
    }
}

dependencies {
    implementation(vc.kotlinCoroutinesAndroid)
    implementation(vc.bundleRetrofitNetwork)
    implementation(vc.bundleKoin)

    implementation(project(mapOf("path" to ":core:ui")))
}
