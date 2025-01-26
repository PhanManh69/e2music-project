/**
 * Precompiled [core-backbase-module.gradle.kts][Core_backbase_module_gradle] script plugin.
 *
 * @see Core_backbase_module_gradle
 */
public
class CoreBackbaseModulePlugin : org.gradle.api.Plugin<org.gradle.api.Project> {
    override fun apply(target: org.gradle.api.Project) {
        try {
            Class
                .forName("Core_backbase_module_gradle")
                .getDeclaredConstructor(org.gradle.api.Project::class.java, org.gradle.api.Project::class.java)
                .newInstance(target, target)
        } catch (e: java.lang.reflect.InvocationTargetException) {
            throw e.targetException
        }
    }
}
