package com.mth.padc.travelappwithpersistencelayer.persistence.databases

import android.content.Context
import androidx.room.*
import com.mth.padc.travelappwithpersistencelayer.models.vos.CountryVO
import com.mth.padc.travelappwithpersistencelayer.persistence.daos.CountryDao

@Database(entities = [CountryVO::class],version = 5,exportSchema = false)
@TypeConverters(ToursConverter::class,PhotoConverters::class)
abstract class AppDatabase : RoomDatabase(){
    abstract fun dao (): CountryDao
    companion object{
        private const val DB_NAME = "COUNTRY.DB"
        private var INSTANCE : AppDatabase ?= null

        fun getDatabase(context: Context) : AppDatabase{
            INSTANCE = Room.databaseBuilder(context,AppDatabase::class.java, DB_NAME)
                .fallbackToDestructiveMigration()
                .allowMainThreadQueries()
                .build()
            return INSTANCE as AppDatabase
        }
    }
}