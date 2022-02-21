package com.wr.employeedirectory.activities

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.bumptech.glide.Glide
import com.wr.employeedirectory.R
import com.wr.employeedirectory.databinding.ActivityDetailsBinding
import com.wr.employeedirectory.models.EmployeeItem

class DetailsActivity : AppCompatActivity() {

    private val comma = " , "
    private lateinit var binding: ActivityDetailsBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_details)

        binding = ActivityDetailsBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val employee: EmployeeItem? = intent.getParcelableExtra("details")

        binding.name.text = employee?.name
        binding.username.text = "Username: "+ "\n" + employee?.username
        binding.email.text = "Email: "+ "\n" + employee?.email
        Glide.with(this).load(employee?.profile_image).into(binding.employeeImage)
        binding.phone.text = "Phone: " + "\n"+ employee?.phone
        binding.website.text = "Website: " + "\n"+ employee?.website
        binding.address.text = "Address: " + "\n" +  employee?.address?.street + comma + employee?.address?.suite + comma + employee?.address?.city + comma + employee?.address?.zipcode
        binding.company.text = "Company: " + "\n" + employee?.company?.name + comma + employee?.company?.catchPhrase + comma + (employee?.company?.bs)
    }
}