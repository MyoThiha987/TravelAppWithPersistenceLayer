package com.mth.padc.travelappwithpersistencelayer.persistence.databases

import androidx.room.TypeConverter
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import com.mth.padc.travelappwithpersistencelayer.models.vos.ScoresAndReviewsVO

class ToursConverter {
    @TypeConverter
    fun fromList(list: List<ScoresAndReviewsVO>?): String? {
        if (list == null) {
            return null
        }
        val gson = Gson()
        val type = object : TypeToken<List<ScoresAndReviewsVO>>() {

        }.type
        return gson.toJson(list, type)
    }

    @TypeConverter
    fun toList(data: String?): List<ScoresAndReviewsVO>? {
        if (data == null) {
            return null
        }
        val gson = Gson()
        val type = object : TypeToken<List<ScoresAndReviewsVO>>() {

        }.type
        return gson.fromJson<List<ScoresAndReviewsVO>>(data, type)

    }
}