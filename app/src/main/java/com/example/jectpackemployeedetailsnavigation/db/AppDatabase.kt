package com.example.jectpackemployeedetailsnavigation.db

import androidx.room.Database
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import com.example.jectpackemployeedetailsnavigation.db.converter.AddressConverter
import com.example.jectpackemployeedetailsnavigation.db.converter.CompanyConverter
import com.example.jectpackemployeedetailsnavigation.model.DataModel

@Database(entities = [DataModel::class], version = 1, exportSchema = false)
@TypeConverters(AddressConverter::class, CompanyConverter::class)
abstract class AppDatabase : RoomDatabase() {
    abstract fun appDao():AppDao
}