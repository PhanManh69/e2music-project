plugins {
    id("com.android.library")
    kotlin("android")
    kotlin("kapt")
}

android {
    compileSdk = AppConfig.COMPILE_SDK

    defaultConfig {
        minSdk = AppConfig.MIN_SDK
        vectorDrawables.useSupportLibrary = true
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
        compose = true
    }

    composeOptions {
        kotlinCompilerExtensionVersion = AppConfig.KOTLIN_COMPILER_EXT
    }
}

dependencies {
    implementation(project(mapOf("path" to ":core:common")))

    implementation(vc.bundleAndroidCore)
    implementation(vc.bundleKoin)
    implementation(vc.kotlinxSerializationJson)
    implementation(vc.kotlinxCollectionsImmutable)
    implementation(vc.androidxUiTooling)

    // Compose dependencies
    implementation(platform(vc.composeBom))
    implementation(vc.bundleCompose)
    implementation(vc.androidXMaterial3)
    implementation(vc.bundleCoilKt)

    // Test dependencies
    testImplementation(vc.jUnit)
    androidTestImplementation(vc.androidxJunit)
    androidTestImplementation(platform(vc.composeBom))
}
