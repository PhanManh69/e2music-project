package com.mobile.e2m.project.presentation

import androidx.compose.animation.AnimatedContentTransitionScope
import androidx.compose.animation.core.tween
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.rememberNavController
import com.mobile.e2m.core.ui.navigation.route.DestinationNavigator.APP_NAVIGATOR
import com.mobile.e2m.core.ui.navigation.Navigator
import com.mobile.e2m.core.ui.navigation.route.DestinationRoute
import com.mobile.e2m.main.navigation.mainDestination
import kotlinx.coroutines.flow.collectLatest
import org.koin.compose.koinInject
import org.koin.core.qualifier.named

@Composable
fun RootNavScreen(
    navController: NavHostController = rememberNavController(),
    navigator: Navigator = koinInject(named(APP_NAVIGATOR)),
) {
    LaunchedEffect(Unit) {
        navigator.actions.collectLatest { action ->
            when (action) {
                Navigator.Action.Back -> navController.popBackStack()
                is Navigator.Action.Navigate -> navController.navigate(
                    route = action.destination,
                    builder = action.navOptions
                )
            }
        }
    }

    NavHost(
        navController = navController,
        startDestination = DestinationRoute.MainRoute.ROOT,
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
        mainDestination()
    }
}
