package com.mth.padc.travelappwithpersistencelayer.models

import androidx.lifecycle.LiveData
import com.mth.padc.travelappwithpersistencelayer.models.vos.CountriesAndCountryVO
import com.mth.padc.travelappwithpersistencelayer.models.vos.CountryVO
import io.reactivex.Observable

interface ToursModel  {

    fun getAllTours(): Observable<CountriesAndCountryVO>

    fun getToursById(name : String) : LiveData<CountryVO>







}