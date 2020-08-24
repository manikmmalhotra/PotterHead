package com.jerry.poterology.activity

import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import com.google.android.material.bottomnavigation.BottomNavigationView
import com.jerry.poterology.Fragments.*
import com.jerry.poterology.R
import com.simform.custombottomnavigation.SSCustomBottomNavigation
import java.util.*

class HomeScreen : AppCompatActivity() {

    var bottomNavigation: SSCustomBottomNavigation? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home_screen)
        bottomNavigation = findViewById(R.id.bottomNavigation)
        bottomNavigation!!.add(
            SSCustomBottomNavigation.Model(
                1,
                R.drawable.ic_baseline_home_24,
                "home"
            )
        )
        bottomNavigation!!.add(
            SSCustomBottomNavigation.Model(
                2,
                R.drawable.ic_baseline_search_24,
                "search"
            )
        )
        bottomNavigation!!.add(
            SSCustomBottomNavigation.Model(
                3,
                R.drawable.ic_baseline_add_circle_24,
                "Create"
            )
        )
        bottomNavigation!!.add(
            SSCustomBottomNavigation.Model(
                4,
                R.drawable.ic_baseline_details_24,
                "Details"
            )
        )
        bottomNavigation!!.add(
            SSCustomBottomNavigation.Model(
                5,
                R.drawable.ic_baseline_account_circle_24,
                "Profile"
            )
        )
        supportFragmentManager.beginTransaction()
            .replace(R.id.fragment_container, HomeFragment()).commit()

        bottomNavigation!!.setOnShowListener { item->
            var selectfragment: Fragment? = null
            when (item.id) {
                1 -> selectfragment = HomeFragment()
                2 -> selectfragment = SearchFragment()
                3 -> selectfragment = CreateFragment()
                4 -> selectfragment = DetailFragment()
                5 -> selectfragment = ProfleFragment()
            }
            supportFragmentManager.beginTransaction()
                .replace(R.id.fragment_container, selectfragment!!).commit()

        }
    }
}

