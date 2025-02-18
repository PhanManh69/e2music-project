package com.mobile.e2m.project.di

import com.mobile.e2m.account.router.AccountRouter
import com.mobile.e2m.project.router.AccountRouterImpl
import com.mobile.e2m.project.router.AppRouter
import com.mobile.e2m.project.router.AppRouterImpl
import org.koin.dsl.bind
import org.koin.dsl.module

val mainAppModel = module {
    single { AppRouterImpl() } bind AppRouter::class
    factory { AccountRouterImpl(get()) } bind AccountRouter::class
}
