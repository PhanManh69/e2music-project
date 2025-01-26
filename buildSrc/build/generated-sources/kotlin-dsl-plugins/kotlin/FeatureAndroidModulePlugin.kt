/**
 * Precompiled [feature-android-module.gradle.kts][Feature_android_module_gradle] script plugin.
 *
 * @see Feature_android_module_gradle
 */
public
class FeatureAndroidModulePlugin : org.gradle.api.Plugin<org.gradle.api.Project> {
    override fun apply(target: org.gradle.api.Project) {
        try {
            Class
                .forName("Feature_android_module_gradle")
                .getDeclaredConstructor(org.gradle.api.Project::class.java, org.gradle.api.Project::class.java)
                .newInstance(target, target)
        } catch (e: java.lang.reflect.InvocationTargetException) {
            throw e.targetException
        }
    }
}
