package com.daffa.core.data.source.local

import com.daffa.core.data.source.local.entity.FavoriteEntity
import com.daffa.core.data.source.local.entity.FilmEntity
import com.daffa.core.data.source.local.entity.PeopleEntity
import com.daffa.core.data.source.local.entity.StarshipEntity
import com.daffa.core.data.source.local.room.AppDao
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class LocalDataSource @Inject constructor(private val appDao: AppDao) {

    fun getAllFilm(): Flow<List<FilmEntity>> = appDao.getAllFilm()
    fun getAllPeople(): Flow<List<PeopleEntity>> = appDao.getAllPeople()
    fun getAllStarship(): Flow<List<StarshipEntity>> = appDao.getAllStarship()
    fun getAllFavorite(): Flow<List<FavoriteEntity>> = appDao.getAllFavorite()

    fun checkExistInFavorite(id: String): Flow<Boolean> = appDao.checkFavoriteIsExist(id)

    suspend fun insertFilm(filmList: List<FilmEntity>) = appDao.insertFilm(filmList)
    suspend fun insertPeople(peopleList: List<PeopleEntity>) = appDao.insertPeople(peopleList)
    suspend fun insertStarship(starshipList: List<StarshipEntity>) =
        appDao.insertStarship(starshipList)

    fun insertFavorite(favoriteEntity: FavoriteEntity) = appDao.insertFavorite(favoriteEntity)

    fun deleteFromFavorite(favoriteEntity: FavoriteEntity) = appDao.deleteFavorite(favoriteEntity)

}