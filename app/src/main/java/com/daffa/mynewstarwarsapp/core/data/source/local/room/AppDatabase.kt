package com.daffa.mynewstarwarsapp.core.data.source.local.room

import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.daffa.mynewstarwarsapp.core.data.source.local.entity.FavoriteEntity
import com.daffa.mynewstarwarsapp.core.data.source.local.entity.FilmEntity
import com.daffa.mynewstarwarsapp.core.data.source.local.entity.PeopleEntity
import com.daffa.mynewstarwarsapp.core.data.source.local.entity.StarshipEntity

@Database(
    entities = [FilmEntity::class, StarshipEntity::class, PeopleEntity::class, FavoriteEntity::class],
    version = 1,
    exportSchema = false
)
abstract class AppDatabase : RoomDatabase() {

    abstract fun appDao(): AppDao

}