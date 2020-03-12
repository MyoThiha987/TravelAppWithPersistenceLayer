package com.mth.padc.travelappwithpersistencelayer.models

import android.annotation.SuppressLint
import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.mth.padc.travelappwithpersistencelayer.models.vos.CountriesAndCountryVO
import com.mth.padc.travelappwithpersistencelayer.models.vos.CountryVO
import com.mth.padc.travelappwithpersistencelayer.network.responses.GetAllCountriesResponse
import com.mth.padc.travelappwithpersistencelayer.network.responses.GetAllToursResponse
import com.mth.padc.travelappwithpersistencelayer.persistence.databases.AppDatabase
import com.mth.padc.travelappwithpersistencelayer.root.ToursApp.Companion.context
import io.reactivex.Observable
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.functions.BiFunction
import io.reactivex.rxkotlin.addTo
import io.reactivex.schedulers.Schedulers


object ToursModelImpl : ToursModel, BaseModel() {

    private val mDataBase: AppDatabase = AppDatabase.getDatabase(context)
   private val countries = mToursApi.getAllCountries().map { it.data }
   private val tours = mToursApi.getAllTours().map { it.data }



    @SuppressLint("CheckResult")
    override fun getAllTours() : Observable<CountriesAndCountryVO>{
        return Observable.zip<List<CountryVO>, List<CountryVO>, CountriesAndCountryVO>(
            countries, tours,
            BiFunction { t1, t2 ->
                t1.forEach {
                    Log.d("Tours", it.toString())
                }
                return@BiFunction CountriesAndCountryVO(t1,t2)
            }

        ).doOnNext {

                val countriesAndToursList = arrayListOf(it.country, it.tours)
                    .flatten()
                mDataBase.dao().saveAllTourData(countriesAndToursList.toMutableList())
            }
            .subscribeOn(Schedulers.io())
    }

    override fun getToursById(name : String): LiveData<CountryVO> {
       return mDataBase.dao().getToursData(name)

    }


//




}