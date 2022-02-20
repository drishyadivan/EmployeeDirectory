package com.wr.employeedirectory.viewmodel

import androidx.lifecycle.*
import com.wr.employeedirectory.models.EmployeeItem
import com.wr.employeedirectory.repository.EmployeeRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class EmployeeViewModel
    (private val repository: EmployeeRepository) : ViewModel() {

    init {
        viewModelScope.launch(Dispatchers.IO) {
            repository.getEmployees()
        }
    }

    val employees: LiveData<List<EmployeeItem>>
        get() = repository.employees

}