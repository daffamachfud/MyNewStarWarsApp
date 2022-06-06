package com.daffa.mynewstarwarsapp.core.data.source.remote

import android.util.Log
import com.daffa.mynewstarwarsapp.core.data.source.remote.network.ApiResponse
import com.daffa.mynewstarwarsapp.core.data.source.remote.network.ApiService
import com.daffa.mynewstarwarsapp.core.data.source.remote.response.PeopleResponse
import com.daffa.mynewstarwarsapp.core.data.source.remote.response.ResultFilm
import com.daffa.mynewstarwarsapp.core.data.source.remote.response.ResultPeople
import com.daffa.mynewstarwarsapp.core.data.source.remote.response.ResultStarship
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.flowOn


class RemoteDataSource private constructor(private val apiService: ApiService)  {

    companion object {
        @Volatile
        private var instance: RemoteDataSource? = null

        fun getInstance(service: ApiService): RemoteDataSource =
            instance ?: synchronized(this) {
                instance ?: RemoteDataSource(service)
            }
    }

    suspend fun getAllFilm(): Flow<ApiResponse<List<ResultFilm>>> {
        //get data from remote api
        return flow {
            try {
                val response = apiService.getListFilm()
                val dataArray = response.results
                if (dataArray.isNotEmpty()){
                    emit(ApiResponse.Success(response.results))
                } else {
                    emit(ApiResponse.Empty)
                }
            } catch (e : Exception){
                emit(ApiResponse.Error(e.toString()))
                Log.e("RemoteDataSource", e.toString())
            }
        }.flowOn(Dispatchers.IO)
    }

    suspend fun getAllPeople(): Flow<ApiResponse<List<ResultPeople>>> {
        //get data from remote api
        return flow {
            try {
                val response = apiService.getListPeople()
                val dataArray = response.results
                if (dataArray.isNotEmpty()){
                    emit(ApiResponse.Success(response.results))
                } else {
                    emit(ApiResponse.Empty)
                }
            } catch (e : Exception){
                emit(ApiResponse.Error(e.toString()))
                Log.e("RemoteDataSource", e.toString())
            }
        }.flowOn(Dispatchers.IO)
    }

    suspend fun getAllStarship(): Flow<ApiResponse<List<ResultStarship>>> {
        return flow {
            try {
                val response = apiService.getListStarship()
                val dataArray = response.results
                if (dataArray.isNotEmpty()){
                    emit(ApiResponse.Success(response.results))
                } else {
                    emit(ApiResponse.Empty)
                }
            } catch (e : Exception){
                emit(ApiResponse.Error(e.toString()))
                Log.e("RemoteDataSource", e.toString())
            }
        }
    }
}