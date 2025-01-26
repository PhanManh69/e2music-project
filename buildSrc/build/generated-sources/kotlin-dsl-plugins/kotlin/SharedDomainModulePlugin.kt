/**
 * Precompiled [shared-domain-module.gradle.kts][Shared_domain_module_gradle] script plugin.
 *
 * @see Shared_domain_module_gradle
 */
public
class SharedDomainModulePlugin : org.gradle.api.Plugin<org.gradle.api.Project> {
    override fun apply(target: org.gradle.api.Project) {
        try {
            Class
                .forName("Shared_domain_module_gradle")
                .getDeclaredConstructor(org.gradle.api.Project::class.java, org.gradle.api.Project::class.java)
                .newInstance(target, target)
        } catch (e: java.lang.reflect.InvocationTargetException) {
            throw e.targetException
        }
    }
}
