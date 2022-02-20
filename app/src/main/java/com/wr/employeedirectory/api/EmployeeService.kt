package com.wr.employeedirectory.api

import com.wr.employeedirectory.models.EmployeeItem
import retrofit2.Response
import retrofit2.http.GET

interface EmployeeService {

    @GET("v2/5d565297300000680030a986")
    suspend fun getAllEmployees(): Response<List<EmployeeItem>>
}