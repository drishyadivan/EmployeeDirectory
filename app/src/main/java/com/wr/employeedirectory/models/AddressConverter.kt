package com.wr.employeedirectory.models

import androidx.room.TypeConverter
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken

class AddressConverter {

    @TypeConverter
    fun fromAddressToJson(value: Address): String {
        return Gson().toJson(value)
    }


    @TypeConverter
    fun fromJsonToAddress(jsonAddress: String): Address {
        val type = object : TypeToken<Address>() {}.type
        return Gson().fromJson<Address>(jsonAddress, type)
    }

}