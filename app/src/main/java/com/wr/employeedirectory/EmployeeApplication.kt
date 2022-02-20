package com.wr.employeedirectory

import android.app.Application
import com.wr.employeedirectory.api.EmployeeService
import com.wr.employeedirectory.api.RetrofitHelper
import com.wr.employeedirectory.db.EmployeeDatabase
import com.wr.employeedirectory.repository.EmployeeRepository

class EmployeeApplication : Application() {

    lateinit var employeeRepository: EmployeeRepository

    override fun onCreate() {
        super.onCreate()
        initialize()
    }

    private fun initialize() {
        val productService = RetrofitHelper.getInstance().create(EmployeeService::class.java)
        val database = EmployeeDatabase.getDatabase(applicationContext)
        employeeRepository = EmployeeRepository(productService, database)
    }
}