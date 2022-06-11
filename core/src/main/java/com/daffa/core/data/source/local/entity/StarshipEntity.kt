package com.daffa.core.data.source.local.entity

import androidx.annotation.NonNull
import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "starship")
data class StarshipEntity(
    @PrimaryKey
    @NonNull
    @ColumnInfo(name = "starshipId")
    var id: String,

    @ColumnInfo(name = "name")
    var name: String,

    @ColumnInfo(name = "imagePath")
    var imagePath: String,
)