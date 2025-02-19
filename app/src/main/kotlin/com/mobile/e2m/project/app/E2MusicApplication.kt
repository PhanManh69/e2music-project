package com.mobile.e2m.project.app

import android.app.Application
import com.mobile.e2m.account.di.accountModule
import com.mobile.e2m.project.di.dataSourceModule
import com.mobile.e2m.project.di.mainAppModule
import com.mobile.e2m.project.di.navigationModule
import org.koin.android.ext.koin.androidContext
import org.koin.core.context.startKoin

class E2MusicApplication : Application() {
    override fun onCreate() {
        super.onCreate()
        startKoin {
            androidContext(this@E2MusicApplication)
            modules(
                listOf(
                    navigationModule,
                    dataSourceModule,
                    mainAppModule,
                    accountModule,
                )
            )
        }
    }
}
