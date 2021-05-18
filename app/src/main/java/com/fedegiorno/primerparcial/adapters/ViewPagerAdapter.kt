package com.fedegiorno.primerparcial.adapters

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentActivity
import androidx.viewpager2.adapter.FragmentStateAdapter
import com.fedegiorno.primerparcial.fragments.DetailFragment1
import com.fedegiorno.primerparcial.fragments.DetailFragment2
import com.fedegiorno.primerparcial.fragments.DetailFragment3


class ViewPagerAdapter(fragmentActivity: FragmentActivity) : FragmentStateAdapter(fragmentActivity) {

    override fun createFragment(position: Int): Fragment {

        return when(position){
            0 -> DetailFragment1()
            1 -> DetailFragment2()
            2 -> DetailFragment3()

            else -> DetailFragment1()
        }
    }

    override fun getItemCount(): Int {
        return TAB_COUNT
    }

    companion object {
        private const val TAB_COUNT = 3
    }
}