package com.mth.padc.travelappwithpersistencelayer.network.responses

import com.google.gson.annotations.SerializedName
import com.mth.padc.travelappwithpersistencelayer.models.vos.CountryVO

data class GetAllCountriesResponse(
    @SerializedName("code")
    val code : Int = 0,
    @SerializedName("message")
    val message : String = "",
    @SerializedName("data")
    val data : List<CountryVO>
)

data class GetAllToursResponse(
    @SerializedName("code")
    val code : Int = 0,
    @SerializedName("message")
    val message : String = "",
    @SerializedName("data")
    val data : List<CountryVO>
)