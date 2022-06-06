package com.daffa.mynewstarwarsapp.core.domain.model

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class Film(
    val filmId:String,
    val title:String,
    val description: String,
    val imagePath: String
):Parcelable