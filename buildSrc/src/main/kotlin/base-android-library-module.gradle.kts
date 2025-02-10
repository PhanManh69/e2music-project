plugins {
    id("com.android.library")
//    id("kotlin-parcelize")
    id("org.jetbrains.kotlin.plugin.serialization")
    id("androidx.navigation.safeargs")
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

    packaging {
        resources.excludes.addAll(
            listOf(
                "META-INF/DEPENDENCIES",
                "META-INF/NOTICE",
                "META-INF/LICENSE",
                "META-INF/NOTICE",
                "META-INF/INDEX.LIST",
                "META-INF/AL2.0",
                "META-INF/LGPL2.1",
                "META-INF/ASL2.0",
                "META-INF/licenses/ASM",
                "META-INF/*.kotlin_module",
                "**/kotlin/**",
                "**/*.txt",
                "**/*.xml",
                "**/*.md",
                "**/*.properties",
            )
        )
    }
}

dependencies {
    // Base dependencies
    implementation(vc.bundleAndroidCore)
    implementation(vc.kotlinxSerializationJson)

    // Test dependencies
    testImplementation(vc.jUnit)
    androidTestImplementation(vc.androidxJunit)
}
