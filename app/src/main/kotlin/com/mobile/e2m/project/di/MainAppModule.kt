package com.mobile.e2m.project.di

import android.content.Context
import android.content.SharedPreferences
import com.mobile.e2m.account.router.AccountRouter
import com.mobile.e2m.dashboard.router.DashboardRouter
import com.mobile.e2m.project.router.AccountRouterImpl
import com.mobile.e2m.project.router.AppRouter
import com.mobile.e2m.project.router.AppRouterImpl
import com.mobile.e2m.project.router.DashboardRouterImpl
import org.koin.dsl.bind
import org.koin.dsl.module

val mainAppModule = module {
    single { AppRouterImpl() } bind AppRouter::class
    single<SharedPreferences> {
        get<Context>().getSharedPreferences("app_prefs", Context.MODE_PRIVATE)
    }
    factory { AccountRouterImpl(get(), get()) } bind AccountRouter::class
    factory { DashboardRouterImpl(get(), get()) } bind DashboardRouter::class
}
