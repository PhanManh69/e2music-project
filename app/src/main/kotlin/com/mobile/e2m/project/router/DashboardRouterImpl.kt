package com.mobile.e2m.project.router

import android.content.SharedPreferences
import androidx.navigation.navOptions
import com.mobile.e2m.core.ui.navigation.route.AppNavigationRoute
import com.mobile.e2m.dashboard.router.DashboardRouter

class DashboardRouterImpl(
    private val appRouter: AppRouterImpl,
    private val preferences: SharedPreferences,
) : DashboardRouter {

    override fun onDashboard() {
        preferences.edit().remove("IS_LOGGED_IN").apply()

        appRouter.getNavController()?.run {
            navigate(
                route = AppNavigationRoute.Account,
                navOptions = navOptions {
                    popUpTo(graph.id) {
                        inclusive = false
                        saveState = false
                    }
                    launchSingleTop = true
                    restoreState = false
                },
            )
        }
    }

    override fun onTheme() {
        appRouter.getNavController()?.run {
            navigate(
                route = AppNavigationRoute.Daily.Menu.Theme
            )
        }
    }

    override fun onTimer() {
        appRouter.getNavController()?.run {
            navigate(
                route = AppNavigationRoute.Daily.Menu.Timer
            )
        }
    }

    override fun onEqualizer() {
        appRouter.getNavController()?.run {
            navigate(
                route = AppNavigationRoute.Daily.Menu.Equalizer
            )
        }
    }

    override fun onMemory() {
        appRouter.getNavController()?.run {
            navigate(
                route = AppNavigationRoute.Daily.Menu.Memory
            )
        }
    }

    override fun onLocalFile() {
        appRouter.getNavController()?.run {
            navigate(
                route = AppNavigationRoute.Daily.Menu.LocalFile
            )
        }
    }

    override fun onDriveMode() {
        appRouter.getNavController()?.run {
            navigate(
                route = AppNavigationRoute.Daily.Menu.DriveMode
            )
        }
    }

    override fun onAudioQuality() {
        appRouter.getNavController()?.run {
            navigate(
                route = AppNavigationRoute.Daily.Menu.AudioQuality
            )
        }
    }

    override fun onPrivacySocial() {
        appRouter.getNavController()?.run {
            navigate(
                route = AppNavigationRoute.Daily.Menu.PrivacySocial
            )
        }
    }
}
