package com.mth.padc.travelappwithpersistencelayer.models.vos

data class CountriesAndCountryVO(
    var country:List<CountryVO> = listOf(),
    var tours:List<CountryVO> = listOf()

)