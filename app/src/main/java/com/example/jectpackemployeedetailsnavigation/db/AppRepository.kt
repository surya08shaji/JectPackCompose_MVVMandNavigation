package com.example.jectpackemployeedetailsnavigation.db

import com.example.jectpackemployeedetailsnavigation.data.ApiInterface

class AppRepository(private val apiInterface: ApiInterface) {

    suspend fun fetchUserDetails() = apiInterface.fetchUserDetails()
}