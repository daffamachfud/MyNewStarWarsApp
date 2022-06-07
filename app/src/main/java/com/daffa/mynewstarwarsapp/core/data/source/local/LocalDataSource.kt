package com.daffa.mynewstarwarsapp.core.data.source.local

import com.daffa.mynewstarwarsapp.core.data.source.local.entity.FavoriteEntity
import com.daffa.mynewstarwarsapp.core.data.source.local.entity.FilmEntity
import com.daffa.mynewstarwarsapp.core.data.source.local.entity.PeopleEntity
import com.daffa.mynewstarwarsapp.core.data.source.local.entity.StarshipEntity
import com.daffa.mynewstarwarsapp.core.data.source.local.room.AppDao
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class LocalDataSource @Inject constructor(private val appDao: AppDao) {

    fun getAllFilm(): Flow<List<FilmEntity>> = appDao.getAllFilm()
    fun getAllPeople(): Flow<List<PeopleEntity>> = appDao.getAllPeople()
    fun getAllStarship(): Flow<List<StarshipEntity>> = appDao.getAllStarship()
    fun getAllFavorite(): Flow<List<FavoriteEntity>> = appDao.getAllFavorite()

    suspend fun insertFilm(filmList : List<FilmEntity>) = appDao.insertFilm(filmList)
    suspend fun insertPeople(peopleList : List<PeopleEntity>) = appDao.insertPeople(peopleList)
    suspend fun insertStarship(starshipList : List<StarshipEntity>) = appDao.insertStarship(starshipList)
    suspend fun insertFavorite(favoriteList : List<FavoriteEntity>) = appDao.insertFavorite(favoriteList)

}