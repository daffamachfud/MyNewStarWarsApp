package com.daffa.mynewstarwarsapp.core.domain.model

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class Favorite(
    val id: String,
    val name: String,
    val type: String,
    val imagePath: String
) : Parcelable