package com.mth.padc.travelappwithpersistencelayer.adapters

import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.mth.padc.travelappwithpersistencelayer.viewholders.BaseViewHolder

abstract class BaseAdapter<T: BaseViewHolder<W>,W> : RecyclerView.Adapter<T>(){

    var mData : MutableList<W> = mutableListOf()


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): T {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.

    }

    override fun onBindViewHolder(holder: T, position: Int) {
        holder.bindData(mData[position])
        //holder.bindData(mPopularTourData[position])
    }

    override fun getItemCount(): Int {
        return mData.count()
    }


    fun setData(data: MutableList<W>){
        mData = data
        notifyDataSetChanged()
    }

    fun appendData(data : List<W>){
        mData.addAll(data.toMutableList())
        notifyDataSetChanged()
    }

}