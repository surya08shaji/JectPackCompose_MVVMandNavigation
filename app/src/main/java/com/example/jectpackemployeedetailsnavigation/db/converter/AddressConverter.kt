package com.example.jectpackemployeedetailsnavigation.db.converter

import androidx.room.TypeConverter
import com.example.jectpackemployeedetailsnavigation.model.Address
import com.google.gson.Gson

class AddressConverter {

    @TypeConverter
    fun fromAddressToString(address: Address?):String{
        return Gson().toJson(address)
    }

    @TypeConverter
    fun fromStringToAddress(address: String):Address?{
        return Gson().fromJson(address,Address::class.java)
    }
}