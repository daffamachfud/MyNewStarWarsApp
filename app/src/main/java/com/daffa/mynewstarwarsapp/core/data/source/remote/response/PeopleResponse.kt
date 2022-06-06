package com.daffa.mynewstarwarsapp.core.data.source.remote.response

import com.google.gson.annotations.SerializedName

data class PeopleResponse(

	@field:SerializedName("next")
	val next: String,

	@field:SerializedName("previous")
	val previous: Any,

	@field:SerializedName("count")
	val count: Int,

	@field:SerializedName("results")
	val results: List<ResultPeople>
)

data class ResultPeople(

	@field:SerializedName("films")
	val films: List<String>,

	@field:SerializedName("homeworld")
	val homeworld: String,

	@field:SerializedName("gender")
	val gender: String,

	@field:SerializedName("skin_color")
	val skinColor: String,

	@field:SerializedName("edited")
	val edited: String,

	@field:SerializedName("created")
	val created: String,

	@field:SerializedName("mass")
	val mass: String,

	@field:SerializedName("vehicles")
	val vehicles: List<String>,

	@field:SerializedName("url")
	val url: String,

	@field:SerializedName("hair_color")
	val hairColor: String,

	@field:SerializedName("birth_year")
	val birthYear: String,

	@field:SerializedName("eye_color")
	val eyeColor: String,

	@field:SerializedName("species")
	val species: List<Any>,

	@field:SerializedName("starships")
	val starships: List<String>,

	@field:SerializedName("name")
	val name: String,

	@field:SerializedName("height")
	val height: String
)
