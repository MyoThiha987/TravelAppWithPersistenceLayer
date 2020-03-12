package com.mth.padc.travelappwithpersistencelayer.network

import com.mth.padc.travelappwithpersistencelayer.network.responses.GetAllCountriesResponse
import com.mth.padc.travelappwithpersistencelayer.network.responses.GetAllToursResponse
import com.mth.padc.travelappwithpersistencelayer.utility.GET_ALL_COUNTRIES
import com.mth.padc.travelappwithpersistencelayer.utility.GET_ALL_TOURS
import io.reactivex.Observable
import retrofit2.http.GET

interface ToursApi {

    @GET(GET_ALL_COUNTRIES)
    fun getAllCountries() : Observable<GetAllCountriesResponse>

    @GET(GET_ALL_TOURS)
    fun getAllTours() : Observable<GetAllToursResponse>
}