package com.mth.padc.travelappwithpersistencelayer.persistence.daos

import androidx.lifecycle.LiveData
import androidx.room.*
import com.mth.padc.travelappwithpersistencelayer.models.vos.CountryVO

@Dao
interface CountryDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun saveAllTourData(list: MutableList<CountryVO>): LongArray

    @Query("select * from country where name = :name ")
    fun getToursData(name: String): LiveData<CountryVO>

    @Query("select * from country")
    fun getAllData(): LiveData<List<CountryVO>>




}