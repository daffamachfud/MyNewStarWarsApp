package com.daffa.mynewstarwarsapp.core.domain.usecase

import com.daffa.mynewstarwarsapp.core.data.Resource
import com.daffa.mynewstarwarsapp.core.domain.model.Favorite
import com.daffa.mynewstarwarsapp.core.domain.model.Film
import com.daffa.mynewstarwarsapp.core.domain.model.People
import com.daffa.mynewstarwarsapp.core.domain.model.Starship
import com.daffa.mynewstarwarsapp.core.domain.repository.IAppRepository
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class AppInteractor @Inject constructor(private val appRepository: IAppRepository) : AppUseCase {
    override fun getAllFilm(): Flow<Resource<List<Film>>> = appRepository.getAllFilm()

    override fun setFilmToFavorite(film: Film) {
        appRepository.insertFilmToFavorite(film)
    }

    override fun deleteFilmFromFavorite(film: Film) {
        appRepository.deleteFilmFromFavorite(film)
    }

    override fun getAllPeople(): Flow<Resource<List<People>>> = appRepository.getAllPeople()

    override fun getAllStarship(): Flow<Resource<List<Starship>>> = appRepository.getAllStarship()

    override fun getAllFavorite(): Flow<Resource<List<Favorite>>> = appRepository.getAllFavorite()

    override fun checkExistInFavorite(id: String): Flow<Boolean> = appRepository.checkExistInFavorite(id)
}