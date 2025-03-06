package com.mobile.e2m.project.di

import androidx.room.Room
import com.mobile.e2m.core.datasource.local.fakedata.AlbumsLocalDataSource
import com.mobile.e2m.core.datasource.local.fakedata.AlbumsLocalDataSourceImpl
import com.mobile.e2m.core.datasource.local.fakedata.SongsLocalDataSource
import com.mobile.e2m.core.datasource.local.fakedata.SongsLocalDataSourceImpl
import com.mobile.e2m.core.datasource.local.room.UsersLocalDataSource
import com.mobile.e2m.core.datasource.local.room.UsersLocalDataSourceImpl
import com.mobile.e2m.core.datasource.local.room.dao.UsersDao
import com.mobile.e2m.core.datasource.local.room.database.UsersDatabase
import com.mobile.e2m.core.datasource.remote.firebase.data.SongsFirebaseDataSource
import com.mobile.e2m.core.datasource.remote.firebase.data.SongsFirebaseDataSourceImpl
import org.koin.android.ext.koin.androidContext
import org.koin.dsl.bind
import org.koin.dsl.module

val dataSourceModule = module {
    single {
        Room.databaseBuilder(
            androidContext(),
            UsersDatabase::class.java,
            "users_database"
        ).build()
    }

    single { get<UsersDatabase>().usersDao() } bind UsersDao::class

    single { UsersLocalDataSourceImpl(get()) } bind UsersLocalDataSource::class

    single { SongsLocalDataSourceImpl() } bind SongsLocalDataSource::class

    single { AlbumsLocalDataSourceImpl() } bind AlbumsLocalDataSource::class

    single { SongsFirebaseDataSourceImpl(get()) } bind SongsFirebaseDataSource::class
}
