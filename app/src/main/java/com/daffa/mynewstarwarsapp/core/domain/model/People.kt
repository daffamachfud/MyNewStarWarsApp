package com.daffa.mynewstarwarsapp.core.domain.model

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class People(
    val peopleId: String,
    val name: String,
    val imagePath: String
) : Parcelable