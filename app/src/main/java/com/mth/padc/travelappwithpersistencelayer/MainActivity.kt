package com.mth.padc.travelappwithpersistencelayer

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.fragment.app.Fragment
import com.mth.padc.travelappwithpersistencelayer.fragments.*
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        setUpBottomNavigationView()
    }
    private fun setUpBottomNavigationView() {

        changeFragment(HomeFragment())

        bottomNav.setOnNavigationItemSelectedListener { item ->

            when (item.itemId) {
                R.id.home -> {
                    changeFragment(HomeFragment())
                }

                R.id.star -> {
                    changeFragment(StarFragment())
                }
                R.id.favourite -> {
                    changeFragment(FavouriteFragment())
                }
                R.id.cost -> {
                    changeFragment(CostFragment())
                }
                R.id.search -> {
                    changeFragment(SearchFragment())
                }
            }
            true

        }
    }

    private fun changeFragment(fragment: Fragment){
        supportFragmentManager.beginTransaction()
            .replace(R.id.frame,fragment)
            .commit()
    }
}
