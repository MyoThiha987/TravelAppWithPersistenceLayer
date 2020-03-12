package com.mth.padc.travelappwithpersistencelayer.viewholders

import android.view.View
import com.bumptech.glide.Glide
import com.mth.padc.travelappwithpersistencelayer.delegate.ToursItemDelegate
import com.mth.padc.travelappwithpersistencelayer.models.vos.CountryVO
import kotlinx.android.synthetic.main.list_item_popular_tours.view.*
import kotlinx.android.synthetic.main.list_item_popular_tours.view.ivCountryImage
import kotlinx.android.synthetic.main.list_item_popular_tours.view.tvCountryName

class PopularToursViewHolder (itemView : View, private val delegate: ToursItemDelegate ) : BaseViewHolder<CountryVO>(itemView){
    override fun bindData(data: CountryVO) {
       mData = data
        itemView.tvCountryName.text = data.name
        itemView.tvRates.text = data.averagerating.toString()
        Glide.with(itemView.context)
            .load(data.photos[0])
            .into(itemView.ivCountryImage)

        itemView.setOnClickListener {
            mData?.let {
                delegate.TourItemClick(it.name)
            }
        }
    }



}