package com.mth.padc.travelappwithpersistencelayer.fragments


import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.FragmentActivity
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.LinearLayoutManager
import com.mth.padc.travelappwithpersistencelayer.adapters.CountryAdapter
import com.mth.padc.travelappwithpersistencelayer.adapters.PopularToursAdapter
import com.mth.padc.travelappwithpersistencelayer.delegate.ToursItemDelegate
import com.mth.padc.travelappwithpersistencelayer.models.ToursModel
import com.mth.padc.travelappwithpersistencelayer.models.ToursModelImpl
import com.mth.padc.travelappwithpersistencelayer.R
import com.mth.padc.travelappwithpersistencelayer.models.vos.CountryVO
import com.mth.padc.travelappwithpersistencelayer.persistence.databases.AppDatabase
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.rxkotlin.addTo
import kotlinx.android.synthetic.main.fragment_home.*

/**
 * A simple [Fragment] subclass.
 */
class HomeFragment : Fragment(),ToursItemDelegate {

    private var compositeDisposable : CompositeDisposable= CompositeDisposable()
    private val mToursModel : ToursModel = ToursModelImpl
    private lateinit var mCountryAdapter : CountryAdapter
   private lateinit var mPopularToursAdapter: PopularToursAdapter
    private lateinit var mDatabase : AppDatabase

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view =LayoutInflater.from(context).inflate(R.layout.fragment_home, container, false)

        //requestToursData()
        return view
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        mDatabase = AppDatabase.getDatabase(this.requireContext())
        setUpCountryRecycler()
        setPopularToursUpRecycler()
        requestToursData()



    }
    private fun requestToursData(){
        mToursModel.getAllTours()
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe {
                mCountryAdapter.setData(it.country.toMutableList())
                mPopularToursAdapter.setData(it.tours.toMutableList())

            }
            .addTo(compositeDisposable)

        mDatabase.dao().getAllData().observe(this, Observer {
//
            mCountryAdapter.setData(it.toMutableList())
            mPopularToursAdapter.setData(it.toMutableList())
      })


    }

    private fun setUpCountryRecycler(){

         mCountryAdapter = CountryAdapter(this)
        val layoutManager = LinearLayoutManager(context,LinearLayoutManager.HORIZONTAL,false)
        rvCountry.layoutManager = layoutManager
        rvCountry.adapter = mCountryAdapter
    }

    private fun setPopularToursUpRecycler(){
        mPopularToursAdapter = PopularToursAdapter(this)
        val layoutManager = LinearLayoutManager(context,LinearLayoutManager.VERTICAL,false)
        rvPopularTour.layoutManager = layoutManager
        rvPopularTour.adapter = mPopularToursAdapter
    }




    override fun TourItemClick(name: String) {
        val tourDetails = FavouriteFragment.newInstance(name)
        fragmentManager!!.beginTransaction()
            .replace(R.id.frame,tourDetails)
            .addToBackStack(null)
            .commit()
    }


    override fun onDestroy() {
        super.onDestroy()
        compositeDisposable.dispose()
    }
}
