package com.example.ilmizlab.view

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.lifecycle.Lifecycle
import androidx.viewpager2.adapter.FragmentStateAdapter
import com.example.ilmizlab.screen.drawer_fragments.course.CoursesFragment
import com.example.ilmizlab.screen.drawer_fragments.news.NewsFragment
import com.example.ilmizlab.screen.drawer_fragments.prices.PricesFragment

class ViewPagerAdapter(fragmentManager: FragmentManager, lifecycle: Lifecycle) :
    FragmentStateAdapter(fragmentManager, lifecycle) {


    //  class ViewPagerAdapter(manager: FragmentManager): FragmentPagerAdapter(manager){
     private val fragmentList : MutableList<Fragment> = ArrayList()
     private val titleList : MutableList<String> = ArrayList()

    override fun getItemCount(): Int {
        return 3
    }

    override fun createFragment(position: Int): Fragment {
        return when(position) {
            0->{
                CoursesFragment()
            }
            1->{
                NewsFragment()
            }
            2->{
                PricesFragment()
            }
            else ->{
                Fragment()
            }

        }
    }

}