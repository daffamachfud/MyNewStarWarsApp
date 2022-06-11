package com.daffa.core.domain.usecase

import com.daffa.core.data.Resource
import com.daffa.core.domain.model.Favorite
import com.daffa.core.domain.model.Film
import com.daffa.core.domain.model.People
import com.daffa.core.domain.model.Starship
import com.daffa.core.domain.repository.IAppRepository
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

    override fun setPeopleToFavorite(people: People) {
        appRepository.insertPeopleToFavorite(people)
    }

    override fun deletePeopleFromFavorite(people: People) {
        appRepository.deletePeopleFromFavorite(people)
    }

    override fun getAllStarship(): Flow<Resource<List<Starship>>> = appRepository.getAllStarship()
    override fun setStarshipToFavorite(starship: Starship) {
        appRepository.insertStarshipToFavorite(starship)
    }

    override fun deleteStarshipFromFavorite(starship: Starship) {
        appRepository.deleteStarshipFromFavorite(starship)
    }

    override fun getAllFavorite(): Flow<List<Favorite>> = appRepository.getAllFavorite()

    override fun checkExistInFavorite(id: String): Flow<Boolean> =
        appRepository.checkExistInFavorite(id)
}