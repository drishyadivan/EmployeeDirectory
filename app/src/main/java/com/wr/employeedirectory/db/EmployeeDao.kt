package com.wr.employeedirectory.db

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import com.wr.employeedirectory.models.EmployeeItem


@Dao
interface EmployeeDao {

    @Insert
    suspend fun addEmployees(p: List<EmployeeItem>)

    @Query("SELECT * FROM employee")
    suspend fun getEmployees(): List<EmployeeItem>

    @Query("SELECT EXISTS(SELECT * FROM employee)")
    fun isExists(): Boolean

}