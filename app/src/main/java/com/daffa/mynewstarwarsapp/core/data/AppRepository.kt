package com.daffa.mynewstarwarsapp.core.data

import com.daffa.mynewstarwarsapp.core.data.source.local.LocalDataSource
import com.daffa.mynewstarwarsapp.core.data.source.remote.RemoteDataSource
import com.daffa.mynewstarwarsapp.core.data.source.remote.network.ApiResponse
import com.daffa.mynewstarwarsapp.core.data.source.remote.response.ResultFilm
import com.daffa.mynewstarwarsapp.core.domain.model.Favorite
import com.daffa.mynewstarwarsapp.core.domain.model.Film
import com.daffa.mynewstarwarsapp.core.domain.model.People
import com.daffa.mynewstarwarsapp.core.domain.model.Starship
import com.daffa.mynewstarwarsapp.core.domain.repository.IAppRepository
import com.daffa.mynewstarwarsapp.core.utils.AppExecutors
import com.daffa.mynewstarwarsapp.core.utils.DataMapper
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

    override fun getAllPeople(): Flow<Resource<List<People>>> {
        TODO("Not yet implemented")
    }

    override fun getAllStarship(): Flow<Resource<List<Starship>>> {
        TODO("Not yet implemented")
    }

    override fun getAllFavorite(): Flow<Resource<List<Favorite>>> {
        TODO("Not yet implemented")
    }
}