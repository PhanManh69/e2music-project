package com.mobile.e2m.project.presentation

import androidx.compose.animation.AnimatedContentTransitionScope
import androidx.compose.animation.core.tween
import androidx.compose.runtime.Composable
import androidx.compose.runtime.DisposableEffect
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.rememberNavController
import com.mobile.e2m.account.navigation.accountDestination
import com.mobile.e2m.core.ui.navigation.route.AppNavigationRoute
import com.mobile.e2m.dashboard.navigation.dashboardDestination
import com.mobile.e2m.main.navigation.mainDestination
import com.mobile.e2m.menu.navigation.menuRootNavGraph
import com.mobile.e2m.project.router.AppRouter
import org.koin.compose.koinInject

@Composable
fun RootNavScreen(
    navController: NavHostController = rememberNavController(),
    appRouter: AppRouter = koinInject(),
) {
    DisposableEffect(navController) {
        appRouter.bind(navController)
        onDispose {
            appRouter.unbind()
        }
    }

    NavHost(
        navController = navController,
        startDestination = AppNavigationRoute.Dashboard,
        enterTransition = {
            slideIntoContainer(
                AnimatedContentTransitionScope.SlideDirection.Start, tween(600),
            )
        },
        exitTransition = {
            slideOutOfContainer(
                AnimatedContentTransitionScope.SlideDirection.Start, tween(700),
            )
        },
        popExitTransition = {
            slideOutOfContainer(
                AnimatedContentTransitionScope.SlideDirection.End, tween(700),
            )
        },
        popEnterTransition = {
            slideIntoContainer(
                AnimatedContentTransitionScope.SlideDirection.End, tween(600),
            )
        },
    ) {
        accountDestination()
        mainDestination()
        dashboardDestination()
        menuRootNavGraph(
            navController = navController
        )
    }
}
