package com.ibnuputra.zipaytest.fragment

import android.graphics.Color
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.viewpager.widget.ViewPager
import com.google.android.material.tabs.TabLayout
import com.ibnuputra.zipaytest.R
import com.ibnuputra.zipaytest.adapter.ViewPagerAdapter

class HistoryFragment  :Fragment() {
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.history_fragment, container, false)

        val viewPager = view.findViewById(R.id.viewPager) as ViewPager
        val tabs = view.findViewById(R.id.tabs) as TabLayout

        val fragmentAdapter = ViewPagerAdapter(childFragmentManager)
        viewPager.adapter = fragmentAdapter
        tabs.setupWithViewPager(viewPager)
        tabs.setTabTextColors(resources.getColor(R.color.colorBlack), resources.getColor(R.color.colorLightOrange))


        return view
    }
}