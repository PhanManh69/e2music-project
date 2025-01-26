/**
 * Precompiled [shared-data-module.gradle.kts][Shared_data_module_gradle] script plugin.
 *
 * @see Shared_data_module_gradle
 */
public
class SharedDataModulePlugin : org.gradle.api.Plugin<org.gradle.api.Project> {
    override fun apply(target: org.gradle.api.Project) {
        try {
            Class
                .forName("Shared_data_module_gradle")
                .getDeclaredConstructor(org.gradle.api.Project::class.java, org.gradle.api.Project::class.java)
                .newInstance(target, target)
        } catch (e: java.lang.reflect.InvocationTargetException) {
            throw e.targetException
        }
    }
}
