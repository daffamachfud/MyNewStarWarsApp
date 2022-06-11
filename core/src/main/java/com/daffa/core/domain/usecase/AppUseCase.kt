package com.daffa.core.domain.usecase

import com.daffa.core.data.Resource
import com.daffa.core.domain.model.Favorite
import com.daffa.core.domain.model.Film
import com.daffa.core.domain.model.People
import com.daffa.core.domain.model.Starship
import kotlinx.coroutines.flow.Flow

interface AppUseCase {
    fun getAllFilm(): Flow<Resource<List<Film>>>
    fun setFilmToFavorite(film: Film)
    fun deleteFilmFromFavorite(film: Film)

    fun getAllPeople(): Flow<Resource<List<People>>>
    fun setPeopleToFavorite(people: People)
    fun deletePeopleFromFavorite(people: People)

    fun getAllStarship(): Flow<Resource<List<Starship>>>
    fun setStarshipToFavorite(starship: Starship)
    fun deleteStarshipFromFavorite(starship: Starship)

    fun getAllFavorite(): Flow<List<Favorite>>

    fun checkExistInFavorite(id: String): Flow<Boolean>

}