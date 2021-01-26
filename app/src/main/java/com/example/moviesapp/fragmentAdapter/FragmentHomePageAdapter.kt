package com.example.moviesapp.fragmentAdapter

import android.content.Context
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentPagerAdapter
import com.example.moviesapp.fragments.TopRatedMoviesFreagment
import com.example.moviesapp.fragments.UpcomingMoviesFragment


class FragmentHomePageAdapter(private val myContext: Context, fm: FragmentManager, internal var totalTabs: Int) : FragmentPagerAdapter(fm) {

    // this is for fragment tabs
    override fun getItem(position: Int): Fragment {
        when (position) {
            0 -> {

                return TopRatedMoviesFreagment()
            }
            1 -> {
                return UpcomingMoviesFragment()
            }

            else -> return null!!
        }
    }

    // this counts total number of tabs
    override fun getCount(): Int {
        return totalTabs
    }
}