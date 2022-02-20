package com.wr.employeedirectory.activities

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.bumptech.glide.Glide
import com.wr.employeedirectory.R
import com.wr.employeedirectory.databinding.ActivityDetailsBinding

class DetailsActivity : AppCompatActivity() {

    private lateinit var binding: ActivityDetailsBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_details)

        binding = ActivityDetailsBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val i = intent
        val name = i.extras!!.getString("Name")
        val username = i.extras!!.getString("Username")
        val imageUrl = i.extras!!.getString("ImageUrl")
        val email = i.extras!!.getString("Email")
        val phone = i.extras!!.getString("Phone")
        val website = i.extras!!.getString("Website")
        val address = i.extras!!.getString("Address")
        val company = i.extras!!.getString("company")

        binding.name.text = name
        binding.username.text = "Usernmae: " + username
        binding.email.text = "Email: " + email
        Glide.with(this).load(imageUrl).into(binding.employeeImage)
        binding.phone.text = "Phone: " + phone
        binding.website.text = "Website: " + website
        binding.address.text = "Address: " + "\n" + address
        binding.company.text = "Company: " + "\n" + company
    }
}