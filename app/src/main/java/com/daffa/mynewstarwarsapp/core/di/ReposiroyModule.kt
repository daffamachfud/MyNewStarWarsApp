package com.daffa.mynewstarwarsapp.core.di

import com.daffa.mynewstarwarsapp.core.data.AppRepository
import com.daffa.mynewstarwarsapp.core.domain.repository.IAppRepository
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module(includes = [NetworkModule::class, DatabaseModule::class])
@InstallIn(SingletonComponent::class)
abstract class RepositoryModule {

    @Binds
    abstract fun provideRepository(appRepository: AppRepository): IAppRepository

}