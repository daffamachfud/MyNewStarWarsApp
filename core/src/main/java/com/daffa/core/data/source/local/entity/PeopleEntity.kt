package com.daffa.core.data.source.local.entity

import androidx.annotation.NonNull
import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "people")
data class PeopleEntity(
    @PrimaryKey
    @NonNull
    @ColumnInfo(name = "peopleId")
    var id: String,

    @ColumnInfo(name = "name")
    var name: String,

    @ColumnInfo(name = "imagePath")
    var imagePath: String,
)