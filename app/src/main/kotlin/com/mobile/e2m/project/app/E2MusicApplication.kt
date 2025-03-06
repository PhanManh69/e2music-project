package com.mobile.e2m.project.app

import android.app.Application
import com.google.firebase.FirebaseApp
import com.mobile.e2m.account.di.accountModule
import com.mobile.e2m.core.datasource.remote.firebase.di.firebaseModule
import com.mobile.e2m.dashboard.di.dashboardModule
import com.mobile.e2m.home.di.homeModule
import com.mobile.e2m.playmusic.di.playmusicModule
import com.mobile.e2m.project.di.dataSourceModule
import com.mobile.e2m.project.di.mainAppModule
import com.mobile.e2m.project.di.navigationModule
import com.mobile.e2m.service.di.serviceModule
import org.koin.android.ext.koin.androidContext
import org.koin.core.context.startKoin

class E2MusicApplication : Application() {
    override fun onCreate() {
        super.onCreate()
        FirebaseApp.initializeApp(this)
        startKoin {
            androidContext(this@E2MusicApplication)
            modules(
                listOf(
                    navigationModule,
                    dataSourceModule,
                    mainAppModule,
                    accountModule,
                    dashboardModule,
                    homeModule,
                    serviceModule,
                    firebaseModule,
                    playmusicModule,
                )
            )
        }
    }
}
