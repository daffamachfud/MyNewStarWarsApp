package com.daffa.mynewstarwarsapp.core.data.source.remote.network

import com.daffa.mynewstarwarsapp.core.data.source.remote.response.FilmResponse
import com.daffa.mynewstarwarsapp.core.data.source.remote.response.PeopleResponse
import com.daffa.mynewstarwarsapp.core.data.source.remote.response.StarshipResponse
import retrofit2.http.GET

interface ApiService {
    @GET("films")
    suspend fun getListFilm(): FilmResponse

    @GET("people")
    suspend fun getListPeople(): PeopleResponse

    @GET("vehicles")
    suspend fun getListStarship(): StarshipResponse
}
