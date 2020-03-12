package com.mth.padc.travelappwithpersistencelayer.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import com.mth.padc.travelappwithpersistencelayer.R
import com.mth.padc.travelappwithpersistencelayer.delegate.ToursItemDelegate
import com.mth.padc.travelappwithpersistencelayer.viewholders.BaseViewHolder
import com.mth.padc.travelappwithpersistencelayer.viewholders.PopularToursViewHolder
import com.mth.padc.travelappwithpersistencelayer.models.vos.CountryVO

class PopularToursAdapter(val delegate: ToursItemDelegate) : BaseAdapter<BaseViewHolder<CountryVO>,CountryVO>(){


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): BaseViewHolder<CountryVO> {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.list_item_popular_tours,parent,false)
        return PopularToursViewHolder(view,delegate)
    }

}