plugins {
    id("com.android.application")
    id("kotlin-android")
    id("org.jetbrains.kotlin.plugin.serialization")
    id("androidx.navigation.safeargs")
    id("kotlin-parcelize")
    id("com.google.gms.google-services")
    kotlin("kapt")
}

android {
    namespace = "com.mobile.e2m.project"
    compileSdk = 35

    defaultConfig {
        applicationId = AppConfig.APP_ID
        minSdk = AppConfig.MIN_SDK
        targetSdk = AppConfig.TARGET_SDK
        versionCode = 1
        versionName = "1.0"

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
        vectorDrawables {
            useSupportLibrary = true
        }
    }

    buildTypes {
        release {
            isMinifyEnabled = false
            proguardFiles(
                getDefaultProguardFile("proguard-android-optimize.txt"),
                "proguard-rules.pro"
            )
        }
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

    packaging {
        resources.excludes.addAll(
            listOf(
                "META-INF/gradle/incremental.annotation.processors",
                "META-INF/core_release.kotlin_module",
                "META-INF/AL2.0",
                "META-INF/LGPL2.1",
                "META-INF/LICENSE.md",
                "META-INF/LICENSE-notice.md",
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
    implementation(libs.bundles.android.core)
    implementation(libs.material)
    implementation(libs.bundles.koin)
    implementation(libs.kotlinx.serialization.json)
    implementation(libs.kotlinx.collections.immutable)
    implementation(libs.com.github.bumptech.glide)

    // Compose dependencies
    implementation(platform(libs.androidx.compose.bom))
    implementation(libs.bundles.compose)
    implementation(libs.androidx.material3)
    implementation(libs.bundles.exo.player)
    implementation(platform(libs.firebase.bom))
    implementation(libs.firebase.firestore.ktx)
    implementation(libs.firebase.analytics.ktx)
    implementation(libs.androidx.concurrent.futures.ktx)

    // Test dependencies
    testImplementation(libs.junit)
    androidTestImplementation(libs.androidx.junit)
    androidTestImplementation(libs.androidx.ui.test.junit4)
    androidTestImplementation(libs.androidx.espresso.core)
    androidTestImplementation(platform(libs.androidx.compose.bom))

    // Preview
    debugImplementation(libs.androidx.ui.tooling)
    debugImplementation(libs.androidx.ui.test.manifest)

    // Room
    implementation(libs.room.ktx)
    kapt(libs.room.compiler)

    // Shared dependencies
    implementation(project(mapOf("path" to ":core:ui")))
    implementation(project(mapOf("path" to ":core:datasource")))
    implementation(project(mapOf("path" to ":core:service")))

    // Feature dependencies
    implementation(project(mapOf("path" to ":main")))
    implementation(project(mapOf("path" to ":account")))
    implementation(project(mapOf("path" to ":dashboard-domain:dashboard")))
    implementation(project(mapOf("path" to ":dashboard-domain:home")))
    implementation(project(mapOf("path" to ":dashboard-domain:music")))
    implementation(project(mapOf("path" to ":dashboard-domain:profile")))
    implementation(project(mapOf("path" to ":daily:playmusic")))
    implementation(project(mapOf("path" to ":daily:menu")))
}
