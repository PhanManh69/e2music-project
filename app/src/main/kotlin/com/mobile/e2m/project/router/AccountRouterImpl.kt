package com.mobile.e2m.project.router

import androidx.navigation.navOptions
import com.mobile.e2m.account.router.AccountRouter
import com.mobile.e2m.core.ui.navigation.route.AppNavigationRoute

class AccountRouterImpl(
    private val appRouter: AppRouterImpl
) : AccountRouter {

    override fun onAccount() {
        appRouter.getNavController()?.run {
            navigate(
                route = AppNavigationRoute.Main,
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
