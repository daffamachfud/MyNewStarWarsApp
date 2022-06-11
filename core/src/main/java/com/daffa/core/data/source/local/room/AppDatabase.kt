package com.daffa.core.data.source.local.room

import androidx.room.Database
import androidx.room.RoomDatabase
import com.daffa.core.data.source.local.entity.FavoriteEntity
import com.daffa.core.data.source.local.entity.FilmEntity
import com.daffa.core.data.source.local.entity.PeopleEntity
import com.daffa.core.data.source.local.entity.StarshipEntity


@Database(
    entities = [FilmEntity::class, StarshipEntity::class, PeopleEntity::class, FavoriteEntity::class],
    version = 1,
    exportSchema = false
)
abstract class AppDatabase : RoomDatabase() {

    abstract fun appDao(): AppDao

}