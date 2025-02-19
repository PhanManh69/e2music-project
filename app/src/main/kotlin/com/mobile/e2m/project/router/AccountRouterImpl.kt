package com.mobile.e2m.project.router

import android.content.SharedPreferences
import androidx.navigation.navOptions
import com.mobile.e2m.account.router.AccountRouter
import com.mobile.e2m.core.ui.navigation.route.AppNavigationRoute

class AccountRouterImpl(
    private val appRouter: AppRouterImpl,
    private val preferences: SharedPreferences,
) : AccountRouter {

    override fun onAccount() {
        preferences.edit().putBoolean("IS_LOGGED_IN", true).apply()

        appRouter.getNavController()?.run {
            navigate(
                route = AppNavigationRoute.Dashboard,
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
}
