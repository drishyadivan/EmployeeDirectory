package com.wr.employeedirectory.models

import android.os.Parcelable
import androidx.room.Entity
import androidx.room.PrimaryKey
import kotlinx.parcelize.Parcelize

@Parcelize
@Entity(tableName = "company")
data class Company(
    @PrimaryKey(autoGenerate = true)
    val companyId: Int,
    val bs: String,
    val catchPhrase: String,
    val name: String
) : Parcelable