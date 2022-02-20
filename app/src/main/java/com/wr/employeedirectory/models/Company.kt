package com.wr.employeedirectory.models

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "company")
data class Company(
    @PrimaryKey(autoGenerate = true)
    val companyId: Int,
    val bs: String,
    val catchPhrase: String,
    val name: String
)