package com.daffa.core.utils

import com.daffa.core.data.source.local.entity.FavoriteEntity
import com.daffa.core.data.source.local.entity.FilmEntity
import com.daffa.core.data.source.local.entity.PeopleEntity
import com.daffa.core.data.source.local.entity.StarshipEntity
import com.daffa.core.data.source.remote.response.ResultFilm
import com.daffa.core.data.source.remote.response.ResultPeople
import com.daffa.core.data.source.remote.response.ResultStarship
import com.daffa.core.domain.model.Favorite
import com.daffa.core.domain.model.Film
import com.daffa.core.domain.model.People
import com.daffa.core.domain.model.Starship

object DataMapper {

    fun mapFavoriteEntityToDomain(input: List<FavoriteEntity>): List<Favorite> =
        input.map {
            Favorite(
                it.id,
                it.name,
                it.type,
                it.imagePath
            )
        }

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

    fun mapFilmEntityToFavoriteEntity(input: FilmEntity) = FavoriteEntity(
        id = input.id,
        name = input.title,
        type = "film",
        imagePath = input.imagePath
    )

    fun mapPeopleResponseToEntites(input: List<ResultPeople>): List<PeopleEntity> {
        val peopleList = ArrayList<PeopleEntity>()
        input.map {
            val people = PeopleEntity(
                id = it.birthYear,
                name = it.name,
                imagePath = Utils.generateImagePathPeople(it.name)
            )
            peopleList.add(people)
        }
        return peopleList
    }

    fun mapPeopleEntitiesToDomain(input: List<PeopleEntity>): List<People> =
        input.map {
            People(
                peopleId = it.id,
                name = it.name,
                imagePath = it.imagePath
            )
        }

    fun mapPeopleDomainToEntity(input: People) = PeopleEntity(
        id = input.peopleId,
        name = input.name,
        imagePath = input.imagePath
    )

    fun mapPeopleEntityToFavoriteEntity(input: PeopleEntity) = FavoriteEntity(
        id = input.id,
        name = input.name,
        type = "people",
        imagePath = input.imagePath
    )

    fun mapStarshipResponseToEntites(input: List<ResultStarship>): List<StarshipEntity> {
        val starshipList = ArrayList<StarshipEntity>()
        input.map {
            val starship = StarshipEntity(
                id = it.model,
                name = it.name,
                imagePath = Utils.generateImagePathStarship(it.name)
            )
            starshipList.add(starship)
        }
        return starshipList
    }

    fun mapStarshipEntitiesToDomain(input: List<StarshipEntity>): List<Starship> =
        input.map {
            Starship(
                starshipId = it.id,
                name = it.name,
                imagePath = it.imagePath
            )
        }

    fun mapStarshipDomainToEntity(input: Starship) = StarshipEntity(
        id = input.starshipId,
        name = input.name,
        imagePath = input.imagePath
    )

    fun mapStarshipEntityToFavoriteEntity(input: StarshipEntity) = FavoriteEntity(
        id = input.id,
        name = input.name,
        type = "starship",
        imagePath = input.imagePath
    )
}