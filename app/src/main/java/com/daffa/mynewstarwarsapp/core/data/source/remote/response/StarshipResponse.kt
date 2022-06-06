package com.daffa.mynewstarwarsapp.core.data.source.remote.response

import com.google.gson.annotations.SerializedName

data class StarshipResponse(

	@field:SerializedName("next")
	val next: String,

	@field:SerializedName("previous")
	val previous: Any,

	@field:SerializedName("count")
	val count: Int,

	@field:SerializedName("results")
	val results: List<ResultStarship>
)

data class ResultStarship(

	@field:SerializedName("max_atmosphering_speed")
	val maxAtmospheringSpeed: String,

	@field:SerializedName("cargo_capacity")
	val cargoCapacity: String,

	@field:SerializedName("films")
	val films: List<String>,

	@field:SerializedName("passengers")
	val passengers: String,

	@field:SerializedName("pilots")
	val pilots: List<Any>,

	@field:SerializedName("edited")
	val edited: String,

	@field:SerializedName("consumables")
	val consumables: String,

	@field:SerializedName("created")
	val created: String,

	@field:SerializedName("length")
	val length: String,

	@field:SerializedName("url")
	val url: String,

	@field:SerializedName("manufacturer")
	val manufacturer: String,

	@field:SerializedName("crew")
	val crew: String,

	@field:SerializedName("vehicle_class")
	val vehicleClass: String,

	@field:SerializedName("cost_in_credits")
	val costInCredits: String,

	@field:SerializedName("name")
	val name: String,

	@field:SerializedName("model")
	val model: String
)
