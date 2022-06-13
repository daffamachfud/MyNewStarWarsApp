package com.daffa.mynewstarwarsapp.di

import com.daffa.core.domain.usecase.AppInteractor
import com.daffa.core.domain.usecase.AppUseCase
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
abstract class AppModule {
    @Binds
    @Singleton
    abstract fun provideTourismUseCase(appInteractor: AppInteractor): AppUseCase
}