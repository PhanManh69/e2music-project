import org.gradle.api.Project
import org.gradle.api.artifacts.ExternalModuleDependencyBundle
import org.gradle.api.artifacts.MinimalExternalModuleDependency
import org.gradle.api.artifacts.VersionCatalog
import org.gradle.api.artifacts.VersionCatalogsExtension
import org.gradle.api.provider.Provider
import org.gradle.kotlin.dsl.getByType

val Project.vc: VersionCatalog
    get() = extensions
        .getByType<VersionCatalogsExtension>()
        .named("libs")

private fun VersionCatalog.findLibraryOrThrow(name: String) =
    findLibrary(name)
        .orElseThrow { NoSuchElementException("Library $name not found in version catalog") }

private fun VersionCatalog.findBundleOrThrow(name: String) =
    findBundle(name)
        .orElseThrow { NoSuchElementException("Bundle $name not found in version catalog") }

val VersionCatalog.kotlinxSerializationJson: Provider<MinimalExternalModuleDependency>
    get() = findLibraryOrThrow("kotlinx-serialization-json")

val VersionCatalog.kotlinxCollectionsImmutable: Provider<MinimalExternalModuleDependency>
    get() = findLibraryOrThrow("kotlinx-collections-immutable")

val VersionCatalog.jUnit: Provider<MinimalExternalModuleDependency>
    get() = findLibraryOrThrow("junit")

val VersionCatalog.androidxJunit: Provider<MinimalExternalModuleDependency>
    get() = findLibraryOrThrow("androidx-junit")

val VersionCatalog.androidXNavigationCompose: Provider<MinimalExternalModuleDependency>
    get() = findLibraryOrThrow("androidx-navigation-compose")

val VersionCatalog.androidXConstraintLayoutCompose: Provider<MinimalExternalModuleDependency>
    get() = findLibraryOrThrow("androidx-constraintlayout-compose")

val VersionCatalog.androidXAppCompat: Provider<MinimalExternalModuleDependency>
    get() = findLibraryOrThrow("androidx-appcompat")

val VersionCatalog.androidXCoreKtx: Provider<MinimalExternalModuleDependency>
    get() = findLibraryOrThrow("androidx-core-ktx")

val VersionCatalog.androidXAppCompatResource: Provider<MinimalExternalModuleDependency>
    get() = findLibraryOrThrow("androidx-appcompat-resources")

val VersionCatalog.androidXConstraintLayout: Provider<MinimalExternalModuleDependency>
    get() = findLibraryOrThrow("androidx-constraintLayout")

val VersionCatalog.androidXNavigationFragment: Provider<MinimalExternalModuleDependency>
    get() = findLibraryOrThrow("androidx-navigation-fragment")

val VersionCatalog.androidXFragment: Provider<MinimalExternalModuleDependency>
    get() = findLibraryOrThrow("androidx-fragment")

val VersionCatalog.androidXNavigationUi: Provider<MinimalExternalModuleDependency>
    get() = findLibraryOrThrow("androidx-navigation-ui")

val VersionCatalog.androidXMaterial3: Provider<MinimalExternalModuleDependency>
    get() = findLibraryOrThrow("androidx-material3")

val VersionCatalog.composeBom: Provider<MinimalExternalModuleDependency>
    get() = findLibraryOrThrow("androidx-compose-bom")

val VersionCatalog.kotlinCoroutinesAndroid: Provider<MinimalExternalModuleDependency>
    get() = findLibraryOrThrow("kotlinx-coroutines-android")

val VersionCatalog.androidxUiTooling: Provider<MinimalExternalModuleDependency>
    get() = findLibraryOrThrow("androidx-ui-tooling")

// Bundle
val VersionCatalog.bundleAndroidCore: Provider<ExternalModuleDependencyBundle>
    get() = findBundleOrThrow("android-core")

val VersionCatalog.bundleCompose: Provider<ExternalModuleDependencyBundle>
    get() = findBundleOrThrow("compose")

val VersionCatalog.bundleKoin: Provider<ExternalModuleDependencyBundle>
    get() = findBundleOrThrow("koin")

val VersionCatalog.bundleRetrofitNetwork: Provider<ExternalModuleDependencyBundle>
    get() = findBundleOrThrow("retrofit-network")

val VersionCatalog.bundleCoilKt: Provider<ExternalModuleDependencyBundle>
    get() = findBundleOrThrow("coil-kt")

val VersionCatalog.bundleMoshi: Provider<ExternalModuleDependencyBundle>
    get() = findBundleOrThrow("moshi-bundle")
