package com.jerry.poterology.activity

import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import com.google.android.material.bottomnavigation.BottomNavigationView
import com.jerry.poterology.Fragments.*
import com.jerry.poterology.R
import java.util.*

class HomeScreen : AppCompatActivity() {

    var bottomNavigationView: BottomNavigationView? = null
    var fm: FragmentManager? = null


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home_screen)
        inite()


    }


    private fun inite()
    {
        bottomNavigationView = findViewById<BottomNavigationView>(R.id.homescreenbottom)
        fm = supportFragmentManager
        fm?.beginTransaction()?.replace(R.id.homescreenfragment, HomeFragment())
            ?.addToBackStack("Home")?.commit()
        setBottomNavigationView()
    }

private fun setBottomNavigationView() {
    bottomNavigationView?.setOnNavigationItemSelectedListener(BottomNavigationView.OnNavigationItemSelectedListener { item ->
        var fragment: Fragment? = null
        val fragmentId: String
        when (item.itemId) {
            R.id.menu_home -> {
                fragment = HomeFragment()
                fragmentId = "Home"
            }
            R.id.menu_search -> {
                fragment = SearchFragment()
                fragmentId = "search"
            }
            R.id.menu_Profile -> {
                fragment = ProfleFragment()
                fragmentId = "profile"
            }
            R.id.menu_Detail -> {
                fragment = DetailFragment()
                fragmentId = "Detail"
            }
            R.id.menu_Create -> {
                fragment = CreateFragment()
                fragmentId = "Create"
            }
            else -> {
                fragment = HomeFragment()
                fragmentId = "Home"
            }
        }
        if (fm?.getBackStackEntryCount()?.minus(1)?.let {
                fm?.getBackStackEntryAt(it)
                    ?.getName()
            } != fragmentId
        ) fm?.beginTransaction()?.replace(R.id.homescreenfragment, fragment, fragmentId)
            ?.addToBackStack(fragmentId)?.commit() else fm?.beginTransaction()
            ?.replace(R.id.homescreenfragment, fragment, fragmentId)?.commit()
        true
    })
}

override fun onBackPressed() {
    if (fm?.getBackStackEntryCount()!! > 1) {
        if (fm?.getBackStackEntryAt(fm?.getBackStackEntryCount()!! - 1)?.getName() == "Home") {
            finish()
        } else {
            fm?.popBackStackImmediate()
            Log.d("LastFrag", fm?.getBackStackEntryCount().toString() + "")
            for (i in 0 until fm?.getBackStackEntryCount()!!) {
                fm?.getBackStackEntryAt(i)?.getName()?.let { Log.d("LastFrag", it) }
            }
            println(fm?.getBackStackEntryCount()!!)
            when (Objects.requireNonNull<String>(
                fm?.getBackStackEntryAt(fm?.getBackStackEntryCount()!! - 1)?.getName()
            )) {
                "Search" -> bottomNavigationView?.setSelectedItemId(R.id.menu_search)
                "profile" -> bottomNavigationView?.setSelectedItemId(R.id.menu_Profile)
                "Create" -> bottomNavigationView?.setSelectedItemId(R.id.menu_Create)
                "Detail" -> bottomNavigationView?.setSelectedItemId(R.id.menu_Detail)
                else -> bottomNavigationView?.setSelectedItemId(R.id.menu_home)
            }
        }
    } else {
        super.onBackPressed()
        finish()
    }
}
}