package com.example.jectpackemployeedetailsnavigation.db

import com.example.jectpackemployeedetailsnavigation.model.DataModel

class LocalDatabaseRepository(private val dao: AppDao) {

    suspend fun insertAll(list: List<DataModel>) = dao.insertAll(list)

    suspend fun getAllData():List<DataModel> = dao.getAllData()

    suspend fun getAllDataCount():Long = dao.getAllDataCount()
}