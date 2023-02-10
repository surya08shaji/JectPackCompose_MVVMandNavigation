package com.example.jectpackemployeedetailsnavigation.data

import com.example.jectpackemployeedetailsnavigation.model.DataModel
import retrofit2.Response
import retrofit2.http.GET

interface ApiInterface {

    @GET("v2/5d565297300000680030a986")
    suspend fun fetchUserDetails(): Response<List<DataModel>>
}