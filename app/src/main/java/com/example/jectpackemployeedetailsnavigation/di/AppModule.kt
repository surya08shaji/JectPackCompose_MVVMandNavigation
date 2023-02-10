package com.example.jectpackemployeedetailsnavigation.di

import android.content.Context
import com.example.jectpackemployeedetailsnavigation.data.ApiInterface
import com.example.jectpackemployeedetailsnavigation.db.AppDao
import com.example.jectpackemployeedetailsnavigation.db.AppRepository
import com.example.jectpackemployeedetailsnavigation.db.LocalDatabaseRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton


@Module
@InstallIn(SingletonComponent::class)
object AppModule {

    @Provides
    fun provideContext(@ApplicationContext context: Context): Context {
        return  context
    }

    @Singleton
    @Provides
    fun providesRepository(apiInterface: ApiInterface) = AppRepository(apiInterface)

    @Singleton
    @Provides
    fun providesLocalRepository(dao: AppDao) = LocalDatabaseRepository(dao)

}