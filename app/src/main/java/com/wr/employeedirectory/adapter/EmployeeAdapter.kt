package com.wr.employeedirectory.adapter

import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.wr.employeedirectory.activities.DetailsActivity
import com.wr.employeedirectory.databinding.AdapterEmployeeBinding
import com.wr.employeedirectory.models.EmployeeItem

class EmployeeAdapter(private val context: Context) :
    RecyclerView.Adapter<EmployeeViewHolder>() {

    private var employeeList = mutableListOf<EmployeeItem>()
    private var nameList = ArrayList<String>()
    val comma = " , "

    fun setEmployee(employee: List<EmployeeItem>) {
        this.employeeList = employee.toMutableList()
        notifyDataSetChanged()
    }


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): EmployeeViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        val binding = AdapterEmployeeBinding.inflate(inflater, parent, false)
        return EmployeeViewHolder(binding)
    }

    override fun onBindViewHolder(holder: EmployeeViewHolder, position: Int) {
        val employee = employeeList[position]
        holder.binding.tvFullName.text = employee.name
        holder.binding.tvCompany.text = employee.company?.name
        Glide.with(holder.itemView.context).load(employee.profile_image).into(holder.binding.ivPic)

        holder.binding.profile.setOnClickListener {
            val address =
                employee.address.street + comma + employee.address.suite + comma + employee.address.city + comma + employee.address.zipcode
            val company =
                (employee.company?.name) + comma + (employee.company?.catchPhrase) + comma + (employee.company?.bs
                        )
            val i = Intent(context, DetailsActivity::class.java)
            i.putExtra("Name", employee.name)
            i.putExtra("ImageUrl", employee.profile_image)
            i.putExtra("Username", employee.username)
            i.putExtra("Email", employee.email)
            i.putExtra("Phone", employee.phone)
            i.putExtra("Website", employee.website)
            i.putExtra("Address", address)
            i.putExtra("Company", company)
            context.startActivity(i)
        }

    }

    override fun getItemCount(): Int {
        return employeeList.size
    }

    fun filterList(names: ArrayList<String>) {
        this.nameList = names
        for (n in names) {
            employeeList.filter { it.equals(names) }
        }
        notifyDataSetChanged()
    }
}

class EmployeeViewHolder(val binding: AdapterEmployeeBinding) :
    RecyclerView.ViewHolder(binding.root) {
}



