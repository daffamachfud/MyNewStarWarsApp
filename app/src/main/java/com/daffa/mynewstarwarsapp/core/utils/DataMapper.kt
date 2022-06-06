package com.daffa.mynewstarwarsapp.core.utils

import com.daffa.mynewstarwarsapp.core.data.source.local.entity.FilmEntity
import com.daffa.mynewstarwarsapp.core.data.source.remote.response.ResultFilm
import com.daffa.mynewstarwarsapp.core.domain.model.Film

object DataMapper {
    fun mapFilmResponsesToEntities(input: List<ResultFilm>): List<FilmEntity> {
        val filmList = ArrayList<FilmEntity>()
        input.map {
            val film = FilmEntity(
                id = it.episodeId.toString(),
                title = it.title,
                description = it.openingCrawl,
                imagePath = Utils.generateImagePathFilm(it.title)
            )
            filmList.add(film)
        }
        return filmList
    }

    fun mapFilmEntitiesToDomain(input: List<FilmEntity>): List<Film> =
        input.map {
            Film(
                filmId = it.id,
                title = it.title,
                description = it.description,
                imagePath = it.imagePath
            )
        }

    fun mapFilmDomainToEntity(input: Film) = FilmEntity(
        id = input.filmId,
        title = input.title,
        description = input.description,
        imagePath = input.imagePath
    )
}