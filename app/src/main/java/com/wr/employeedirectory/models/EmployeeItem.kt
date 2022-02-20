package com.wr.employeedirectory.models

import androidx.room.Entity
import androidx.room.PrimaryKey


@Entity(tableName = "employee")
data class EmployeeItem(
    @PrimaryKey(autoGenerate = true)
    val employeeId: Int,
    val address: Address,
    val company: Company?,
    val email: String,
    val id: Int,
    val name: String,
    val phone: String?,
    val profile_image: String?,
    val username: String,
    val website: String?
)