package com.wr.employeedirectory.models

import android.os.Parcelable
import androidx.room.Entity
import androidx.room.PrimaryKey
import kotlinx.parcelize.Parcelize

@Parcelize
@Entity(tableName = "geo")
data class Geo(
    @PrimaryKey(autoGenerate = true)
    val geoId: Int,
    val lat: String,
    val lng: String
) : Parcelable