package com.mth.padc.travelappwithpersistencelayer.root

import android.app.Application
import android.content.Context

class ToursApp : Application(){

    companion object{
        lateinit var context: Context
    }

    override fun onCreate() {
        super.onCreate()
        context = applicationContext
    }

}