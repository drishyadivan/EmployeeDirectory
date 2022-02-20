package com.wr.employeedirectory.activities

import android.app.SearchManager
import android.content.Context
import android.os.Bundle
import android.util.Log
import android.view.Menu
import android.view.MenuItem
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.SearchView
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.wr.employeedirectory.EmployeeApplication
import com.wr.employeedirectory.R
import com.wr.employeedirectory.adapter.EmployeeAdapter
import com.wr.employeedirectory.databinding.ActivityMainBinding
import com.wr.employeedirectory.models.EmployeeItem
import com.wr.employeedirectory.viewmodel.EmployeeViewModel
import com.wr.employeedirectory.viewmodel.EmployeeViewModelFactory
import java.util.*
import kotlin.collections.ArrayList

class MainActivity : AppCompatActivity() {

    lateinit var employeeViewModel: EmployeeViewModel
    private lateinit var adapter: EmployeeAdapter
    private lateinit var binding: ActivityMainBinding
    private var employeeList = mutableListOf<EmployeeItem>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        adapter = EmployeeAdapter(this)
        val repository = (application as EmployeeApplication).employeeRepository

        employeeViewModel = ViewModelProvider(
            this,
            EmployeeViewModelFactory(repository)
        ).get(EmployeeViewModel::class.java)

        binding.recyclerview.adapter = adapter

        employeeViewModel.employees.observe(this, Observer {
            Log.e("EMPLOYEE", it.toString())
            employeeList = it as MutableList<EmployeeItem>
            adapter.setEmployee(it)
        })

    }

    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        menuInflater.inflate(R.menu.search_view, menu)

        val searchManager = getSystemService(Context.SEARCH_SERVICE) as SearchManager
        val searchView = menu.findItem(R.id.action_search)
            .actionView as SearchView
        searchView.setSearchableInfo(
            searchManager
                .getSearchableInfo(componentName)
        )
        searchView.setMaxWidth(Int.MAX_VALUE)

        searchView.setOnQueryTextListener(object : SearchView.OnQueryTextListener {
            override fun onQueryTextSubmit(query: String?): Boolean {
                return false
            }

            override fun onQueryTextChange(query: String?): Boolean {
                //    filter(query.toString());
                filterWithQuery(query.toString())
                return false
            }
        })

        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {

        val id: Int = item.itemId
        return if (id == R.id.action_search) {
            true
        } else super.onOptionsItemSelected(item)
    }

    private fun onQueryChanged(filterQuery: String): List<EmployeeItem> {
        val filteredList = ArrayList<EmployeeItem>()
        for (emp in employeeList) {
            if (emp.name.toLowerCase(Locale.getDefault()).contains(filterQuery)) {
                filteredList.add(emp)
            }
            if (emp.email.toLowerCase(Locale.getDefault()).contains(filterQuery)) {
                filteredList.add(emp)
            }
        }
        return filteredList
    }

    private fun filterWithQuery(query: String) {
        if (query.isNotEmpty()) {
            val filteredList: List<EmployeeItem> = onQueryChanged(query)
            adapter.setEmployee(filteredList)
        } else if (query.isEmpty()) {
            adapter.setEmployee(employeeList)
        }
    }

}