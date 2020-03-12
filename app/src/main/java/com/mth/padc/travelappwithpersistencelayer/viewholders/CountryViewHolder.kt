package com.mth.padc.travelappwithpersistencelayer.viewholders

import android.view.View
import com.bumptech.glide.Glide
import com.mth.padc.travelappwithpersistencelayer.delegate.ToursItemDelegate
import com.mth.padc.travelappwithpersistencelayer.models.vos.CountryVO
import kotlinx.android.synthetic.main.list_item_country.view.*

class CountryViewHolder(itemView : View, private val delegate : ToursItemDelegate) : BaseViewHolder<CountryVO>(itemView){

    override fun bindData(data: CountryVO) {
        mData = data
        itemView.tvCountryName.text = data.location
        Glide.with(itemView.context)
            .load(data.photos[0])
            .into(itemView.ivCountryImage)
        itemView.tvRate.text = data.averagerating.toString()
       val review= data.scoresandreviews[0].total_reviews.toString()
        itemView.tvTourCount.text ="$review Tours "

        itemView.setOnClickListener {
            mData?.let {
                delegate.TourItemClick(it.name)
            }
       }
    }

}