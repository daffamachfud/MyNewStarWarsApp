package com.daffa.core.data

import com.daffa.core.data.source.local.LocalDataSource
import com.daffa.core.data.source.remote.RemoteDataSource
import com.daffa.core.data.source.remote.network.ApiResponse
import com.daffa.core.data.source.remote.response.ResultFilm
import com.daffa.core.data.source.remote.response.ResultPeople
import com.daffa.core.data.source.remote.response.ResultStarship
import com.daffa.core.domain.model.Favorite
import com.daffa.core.domain.model.Film
import com.daffa.core.domain.model.People
import com.daffa.core.domain.model.Starship
import com.daffa.core.domain.repository.IAppRepository
import com.daffa.core.utils.AppExecutors
import com.daffa.core.utils.DataMapper
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map
import javax.inject.Inject

class AppRepository @Inject constructor(
    private val remoteDataSource: RemoteDataSource,
    private val localDataSource: LocalDataSource,
    private val appExecutors: AppExecutors
) : IAppRepository {

    override fun getAllFilm(): Flow<Resource<List<Film>>> =
        object : NetworkBoundResource<List<Film>, List<ResultFilm>>() {
            override fun loadFromDB(): Flow<List<Film>> {
                return localDataSource.getAllFilm().map {
                    DataMapper.mapFilmEntitiesToDomain(it)
                }
            }

            override fun shouldFetch(data: List<Film>?): Boolean =
//                data == null || data.isEmpty()
                true // ganti dengan true jika ingin selalu mengambil data dari internet

            override suspend fun createCall(): Flow<ApiResponse<List<ResultFilm>>> =
                remoteDataSource.getAllFilm()

            override suspend fun saveCallResult(data: List<ResultFilm>) {
                val filmList = DataMapper.mapFilmResponsesToEntities(data)
                localDataSource.insertFilm(filmList)
            }
        }.asFlow()

    override fun insertFilmToFavorite(film: Film) {
        val filmEntity = DataMapper.mapFilmDomainToEntity(film)
        appExecutors.diskIO().execute {
            localDataSource.insertFavorite(
                DataMapper.mapFilmEntityToFavoriteEntity(filmEntity)
            )
        }
    }

    override fun deleteFilmFromFavorite(film: Film) {
        val filmEntity = DataMapper.mapFilmDomainToEntity(film)
        appExecutors.diskIO().execute {
            localDataSource.deleteFromFavorite(
                DataMapper.mapFilmEntityToFavoriteEntity(filmEntity)
            )
        }
    }

    override fun getAllPeople(): Flow<Resource<List<People>>> =
        object : NetworkBoundResource<List<People>, List<ResultPeople>>() {
            override fun loadFromDB(): Flow<List<People>> {
                return localDataSource.getAllPeople().map {
                    DataMapper.mapPeopleEntitiesToDomain(it)
                }
            }

            override fun shouldFetch(data: List<People>?): Boolean =
                data == null || data.isEmpty()

            override suspend fun createCall(): Flow<ApiResponse<List<ResultPeople>>> =
                remoteDataSource.getAllPeople()

            override suspend fun saveCallResult(data: List<ResultPeople>) {
                val peopleList = DataMapper.mapPeopleResponseToEntites(data)
                localDataSource.insertPeople(peopleList)
            }
        }.asFlow()

    override fun insertPeopleToFavorite(people: People) {
        val peopleEntity = DataMapper.mapPeopleDomainToEntity(people)
        appExecutors.diskIO().execute {
            localDataSource.insertFavorite(
                DataMapper.mapPeopleEntityToFavoriteEntity(peopleEntity)
            )
        }
    }

    override fun deletePeopleFromFavorite(people: People) {
        val peopleEntity = DataMapper.mapPeopleDomainToEntity(people)
        appExecutors.diskIO().execute {
            localDataSource.deleteFromFavorite(
                DataMapper.mapPeopleEntityToFavoriteEntity(peopleEntity)
            )
        }
    }

    override fun getAllStarship(): Flow<Resource<List<Starship>>> =
        object : NetworkBoundResource<List<Starship>, List<ResultStarship>>() {
            override fun loadFromDB(): Flow<List<Starship>> {
                return localDataSource.getAllStarship().map {
                    DataMapper.mapStarshipEntitiesToDomain(it)
                }
            }

            override fun shouldFetch(data: List<Starship>?): Boolean =
                data == null || data.isEmpty()

            override suspend fun createCall(): Flow<ApiResponse<List<ResultStarship>>> =
                remoteDataSource.getAllStarship()

            override suspend fun saveCallResult(data: List<ResultStarship>) {
                val starshipList = DataMapper.mapStarshipResponseToEntites(data)
                localDataSource.insertStarship(starshipList)
            }
        }.asFlow()

    override fun insertStarshipToFavorite(starship: Starship) {
        val starshipEntity = DataMapper.mapStarshipDomainToEntity(starship)
        appExecutors.diskIO().execute {
            localDataSource.insertFavorite(
                DataMapper.mapStarshipEntityToFavoriteEntity(starshipEntity)
            )
        }
    }

    override fun deleteStarshipFromFavorite(starship: Starship) {
        val starshipEntity = DataMapper.mapStarshipDomainToEntity(starship)
        appExecutors.diskIO().execute {
            localDataSource.deleteFromFavorite(
                DataMapper.mapStarshipEntityToFavoriteEntity(starshipEntity)
            )
        }
    }

    override fun getAllFavorite(): Flow<List<Favorite>> {
        return localDataSource.getAllFavorite().map {
            DataMapper.mapFavoriteEntityToDomain(it)
        }
    }

    override fun checkExistInFavorite(id: String): Flow<Boolean> {
        return localDataSource.checkExistInFavorite(id)
    }
}