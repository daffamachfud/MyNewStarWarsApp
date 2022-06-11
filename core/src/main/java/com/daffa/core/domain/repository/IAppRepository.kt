package com.daffa.core.domain.repository

import com.daffa.core.data.Resource
import com.daffa.core.domain.model.Favorite
import com.daffa.core.domain.model.Film
import com.daffa.core.domain.model.People
import com.daffa.core.domain.model.Starship
import kotlinx.coroutines.flow.Flow

interface IAppRepository {
    fun getAllFilm(): Flow<Resource<List<Film>>>
    fun insertFilmToFavorite(film: Film)
    fun deleteFilmFromFavorite(film: Film)

    fun getAllPeople(): Flow<Resource<List<People>>>
    fun insertPeopleToFavorite(people: People)
    fun deletePeopleFromFavorite(people: People)

    fun getAllStarship(): Flow<Resource<List<Starship>>>
    fun insertStarshipToFavorite(starship: Starship)
    fun deleteStarshipFromFavorite(starship: Starship)

    fun getAllFavorite(): Flow<List<Favorite>>

    fun checkExistInFavorite(id: String): Flow<Boolean>

}