package com.wr.employeedirectory.repository

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.wr.employeedirectory.api.EmployeeService
import com.wr.employeedirectory.db.EmployeeDatabase
import com.wr.employeedirectory.models.EmployeeItem

class EmployeeRepository(
    private val employeeService: EmployeeService,
    private val employeeDatabase: EmployeeDatabase

) {

    private val employeeLiveData = MutableLiveData<List<EmployeeItem>>()

    val employees: LiveData<List<EmployeeItem>>
        get() = employeeLiveData


    suspend fun getEmployees() {

        val dataExists = employeeDatabase.employeeDao().isExists()
        if (!dataExists) {
            val result = employeeService.getAllEmployees()
            if (result?.body() != null) {
                employeeDatabase.employeeDao().addEmployees(result.body()!!)
            }
        }
        val employees = employeeDatabase.employeeDao().getEmployees();
        employeeLiveData.postValue(employees)

    }
}