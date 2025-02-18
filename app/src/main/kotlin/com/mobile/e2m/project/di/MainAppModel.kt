package com.mobile.e2m.project.di

import com.mobile.e2m.account.router.AccountRouter
import com.mobile.e2m.dashboard.router.DashboardRouter
import com.mobile.e2m.project.router.AccountRouterImpl
import com.mobile.e2m.project.router.AppRouter
import com.mobile.e2m.project.router.AppRouterImpl
import com.mobile.e2m.project.router.DashboardRouterImpl
import org.koin.dsl.bind
import org.koin.dsl.module

val mainAppModel = module {
    single { AppRouterImpl() } bind AppRouter::class
    factory { AccountRouterImpl(get()) } bind AccountRouter::class
    factory { DashboardRouterImpl(get()) } bind DashboardRouter::class
}
