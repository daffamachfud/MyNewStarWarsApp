package com.daffa.mynewstarwarsapp.core.domain.repository

import com.daffa.mynewstarwarsapp.core.data.Resource
import com.daffa.mynewstarwarsapp.core.domain.model.Favorite
import com.daffa.mynewstarwarsapp.core.domain.model.Film
import com.daffa.mynewstarwarsapp.core.domain.model.People
import com.daffa.mynewstarwarsapp.core.domain.model.Starship
import kotlinx.coroutines.flow.Flow

interface IAppRepository {
    fun getAllFilm(): Flow<Resource<List<Film>>>
    fun getAllPeople(): Flow<Resource<List<People>>>
    fun getAllStarship(): Flow<Resource<List<Starship>>>
    fun getAllFavorite(): Flow<Resource<List<Favorite>>>
}