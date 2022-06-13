package com.daffa.core.di

import android.content.Context
import androidx.room.Room
import com.daffa.core.data.source.local.room.AppDao
import com.daffa.core.data.source.local.room.AppDatabase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import net.sqlcipher.database.SQLiteDatabase
import net.sqlcipher.database.SupportFactory
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
class DatabaseModule {

    private val passPhrase: ByteArray = SQLiteDatabase.getBytes("starwars".toCharArray())
    private val factory = SupportFactory(passPhrase)

    @Singleton
    @Provides
    fun provideDatabase(@ApplicationContext context: Context): AppDatabase = Room.databaseBuilder(
        context,
        AppDatabase::class.java, "starwars.db"
    ).fallbackToDestructiveMigration()
        .openHelperFactory(factory)
        .build()

    @Provides
    fun provideTourismDao(database: AppDatabase): AppDao = database.appDao()
}