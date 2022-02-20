package com.wr.employeedirectory.models

import androidx.room.TypeConverter
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken

class CompanyConverter {

    @TypeConverter
    fun fromCompanyToJson(value: Company?): String {
        return Gson().toJson(value)
    }


    @TypeConverter
    fun fromJsonToCompany(jsonCompany: String?): Company? {
        val type = object : TypeToken<Company?>() {}.type
        return Gson()?.fromJson<Company?>(jsonCompany, type)
    }

}