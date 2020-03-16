package com.ibnuputra.zipaytest.adapter

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentPagerAdapter
import com.ibnuputra.zipaytest.fragment.HistoryTabComplete
import com.ibnuputra.zipaytest.fragment.HistoryTabProgress


class ViewPagerAdapter(fm: FragmentManager) : FragmentPagerAdapter(fm)  {

    override fun getItem(position: Int): Fragment {
        return when (position) {
            0 -> {
                HistoryTabProgress()
            }
            else -> {
                return HistoryTabComplete()
            }
        }
    }

    override fun getCount(): Int {
        return 2
    }

    override fun getPageTitle(position: Int): CharSequence? {
        return when (position) {
            0 -> "In Progress"
            else -> {
                return "Completed"
            }
        }
    }
}