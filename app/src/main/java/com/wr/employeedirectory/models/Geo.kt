package com.wr.employeedirectory.models

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "geo")
data class Geo(
    @PrimaryKey(autoGenerate = true)
    val geoId: Int,
    val lat: String,
    val lng: String
)