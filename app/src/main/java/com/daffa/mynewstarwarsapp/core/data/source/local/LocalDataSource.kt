package com.daffa.mynewstarwarsapp.core.data.source.local

import com.daffa.mynewstarwarsapp.core.data.source.local.entity.FavoriteEntity
import com.daffa.mynewstarwarsapp.core.data.source.local.entity.FilmEntity
import com.daffa.mynewstarwarsapp.core.data.source.local.entity.PeopleEntity
import com.daffa.mynewstarwarsapp.core.data.source.local.entity.StarshipEntity
import com.daffa.mynewstarwarsapp.core.data.source.local.room.AppDao
import kotlinx.coroutines.flow.Flow

class LocalDataSource private constructor(private val appDao: AppDao) {
    companion object{
        private var instance: LocalDataSource? = null

        fun getInstance(appDao: AppDao): LocalDataSource =
            instance ?: synchronized(this){
                instance ?: LocalDataSource(appDao)
            }
    }

    fun getAllFilm(): Flow<List<FilmEntity>> = appDao.getAllFilm()
    fun getAllPeople(): Flow<List<PeopleEntity>> = appDao.getAllPeople()
    fun getAllStarship(): Flow<List<StarshipEntity>> = appDao.getAllStarship()
    fun getAllFavorite(): Flow<List<FavoriteEntity>> = appDao.getAllFavorite()

    suspend fun insertFilm(filmList : List<FilmEntity>) = appDao.insertFilm(filmList)
    suspend fun insertPeople(peopleList : List<PeopleEntity>) = appDao.insertPeople(peopleList)
    suspend fun insertStarship(starshipList : List<StarshipEntity>) = appDao.insertStarship(starshipList)
    suspend fun insertFavorite(favoriteList : List<FavoriteEntity>) = appDao.insertFavorite(favoriteList)

}