package com.assignment.opensooq.core.di

import android.app.Application
import android.content.Context
import android.content.SharedPreferences
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import io.realm.Realm
import io.realm.RealmConfiguration
import javax.inject.Singleton


@Module
@InstallIn(SingletonComponent::class)
object DataBaseModule {


    private const val realmVersion = 1L

    @Singleton
    @Provides
    fun providesRealmConfig(context: Application): RealmConfiguration {
        Realm.init(context)
        return RealmConfiguration.Builder()
            .schemaVersion(realmVersion)
            .build()

    }


    @Singleton
    @Provides
    fun providesRealm(config: RealmConfiguration): Realm =
        Realm.getInstance(config)


    @Provides
    @Singleton
    fun provideSharedPreferences(context: Application): SharedPreferences {
        return context.getSharedPreferences("OpensooqAppPrefs", Context.MODE_PRIVATE)
    }


}