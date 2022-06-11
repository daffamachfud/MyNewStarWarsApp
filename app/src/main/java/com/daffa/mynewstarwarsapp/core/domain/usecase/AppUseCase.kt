package com.daffa.mynewstarwarsapp.core.domain.usecase

import com.daffa.mynewstarwarsapp.core.data.Resource
import com.daffa.mynewstarwarsapp.core.domain.model.Favorite
import com.daffa.mynewstarwarsapp.core.domain.model.Film
import com.daffa.mynewstarwarsapp.core.domain.model.People
import com.daffa.mynewstarwarsapp.core.domain.model.Starship
import kotlinx.coroutines.flow.Flow

interface AppUseCase {
    fun getAllFilm(): Flow<Resource<List<Film>>>
    fun setFilmToFavorite(film: Film)
    fun deleteFilmFromFavorite(film: Film)

    fun getAllPeople(): Flow<Resource<List<People>>>
    fun getAllStarship(): Flow<Resource<List<Starship>>>
    fun getAllFavorite(): Flow<Resource<List<Favorite>>>

    fun checkExistInFavorite(id:String): Flow<Boolean>

}