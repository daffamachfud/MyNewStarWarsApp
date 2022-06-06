package com.daffa.mynewstarwarsapp.core.data.source.local.room

import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import androidx.room.Update
import com.daffa.mynewstarwarsapp.core.data.source.local.entity.FavoriteEntity
import com.daffa.mynewstarwarsapp.core.data.source.local.entity.FilmEntity
import com.daffa.mynewstarwarsapp.core.data.source.local.entity.PeopleEntity
import com.daffa.mynewstarwarsapp.core.data.source.local.entity.StarshipEntity
import kotlinx.coroutines.flow.Flow

interface AppDao {
    @Query("Select * from film")
    fun getAllFilm(): Flow<List<FilmEntity>>

    @Query("Select * from people")
    fun getAllPeople(): Flow<List<PeopleEntity>>

    @Query("Select * from starship")
    fun getAllStarship(): Flow<List<StarshipEntity>>

    @Query("Select * from favorite")
    fun getAllFavorite(): Flow<List<FavoriteEntity>>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertFilm(film: List<FilmEntity>)

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertPeople(people: List<PeopleEntity>)

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertStarship(favorite: List<StarshipEntity>)

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertFavorite(favorite: List<FavoriteEntity>)

    @Update
    fun updateFavoriteFilm(film: FilmEntity)

    @Update
    fun updateFavoritePeople(people: PeopleEntity)

    @Update
    fun updateFavoriteStarship(starship: StarshipEntity)


}