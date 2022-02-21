package com.wr.employeedirectory.models

import android.os.Parcelable
import androidx.room.Entity
import androidx.room.PrimaryKey
import kotlinx.parcelize.Parcelize
import kotlinx.parcelize.RawValue

@Parcelize
@Entity(tableName = "address")
data class Address(
    @PrimaryKey(autoGenerate = true)
    val addressId: Int,
    val city: String,
    val geo: @RawValue Geo,
    val street: String,
    val suite: String,
    val zipcode: String
) : Parcelable