package com.mobile.e2m.project.router

import com.mobile.e2m.core.ui.navigation.route.AppNavigationRoute
import com.mobile.e2m.dashboard.router.DashboardRouter

class DashboardRouterImpl(
    private val appRouter: AppRouterImpl
) : DashboardRouter {

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
