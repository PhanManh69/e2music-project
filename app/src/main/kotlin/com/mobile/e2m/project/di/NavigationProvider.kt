package com.mobile.e2m.project.di

import com.mobile.e2m.core.ui.navigation.route.DestinationNavigator.APP_NAVIGATOR
import com.mobile.e2m.core.ui.navigation.NavigationService
import com.mobile.e2m.core.ui.navigation.Navigator
import org.koin.core.qualifier.named
import org.koin.dsl.bind
import org.koin.dsl.module

val navigationModule = module {
    single(named(APP_NAVIGATOR)) { Navigator() } bind NavigationService::class
}
