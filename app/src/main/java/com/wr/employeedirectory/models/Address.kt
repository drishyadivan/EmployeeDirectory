package com.wr.employeedirectory.models

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "address")
data class Address(
    @PrimaryKey(autoGenerate = true)
    val addressId: Int,
    val city: String,
    val geo: Geo,
    val street: String,
    val suite: String,
    val zipcode: String
)