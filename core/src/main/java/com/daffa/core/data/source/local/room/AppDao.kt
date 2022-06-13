@file:Suppress("unused", "unused", "unused")

package com.daffa.core.data.source.local.room

import androidx.room.*
import com.daffa.core.data.source.local.entity.FavoriteEntity
import com.daffa.core.data.source.local.entity.FilmEntity
import com.daffa.core.data.source.local.entity.PeopleEntity
import com.daffa.core.data.source.local.entity.StarshipEntity
import kotlinx.coroutines.flow.Flow

@Dao
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
    fun insertFavorite(favoriteEntity: FavoriteEntity)

    @Query("SELECT EXISTS(SELECT * FROM favorite WHERE id = :id)")
    fun checkFavoriteIsExist(id: String): Flow<Boolean>

    @Delete
    fun deleteFavorite(favoriteEntity: FavoriteEntity)


}