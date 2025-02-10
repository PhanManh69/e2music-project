package com.mobile.e2m.project.di

import androidx.room.Room
import com.mobile.e2m.core.datasource.local.room.UsersLocalDataSource
import com.mobile.e2m.core.datasource.local.room.UsersLocalDataSourceImpl
import com.mobile.e2m.core.datasource.local.room.dao.UsersDao
import com.mobile.e2m.core.datasource.local.room.database.UsersDatabase
import org.koin.android.ext.koin.androidContext
import org.koin.dsl.bind
import org.koin.dsl.module

val dataSourceModel = module {
    single {
        Room.databaseBuilder(
            androidContext(),
            UsersDatabase::class.java,
            "users_database"
        ).build()
    }
    single { get<UsersDatabase>().usersDao() } bind UsersDao::class
    single { UsersLocalDataSourceImpl(get()) } bind UsersLocalDataSource::class
}
