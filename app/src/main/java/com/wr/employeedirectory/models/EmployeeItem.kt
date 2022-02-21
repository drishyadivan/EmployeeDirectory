package com.wr.employeedirectory.models

import android.os.Parcelable
import androidx.room.Entity
import androidx.room.PrimaryKey
import kotlinx.parcelize.Parcelize
import kotlinx.parcelize.RawValue

@Parcelize
@Entity(tableName = "employee")
data class EmployeeItem(
    @PrimaryKey(autoGenerate = true)
    val employeeId: Int,
    val address: @RawValue Address,
    val company: @RawValue Company?,
    val email: String,
    val id: Int,
    val name: String,
    val phone: String?,
    val profile_image: String?,
    val username: String,
    val website: String?
): Parcelable