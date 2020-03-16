package com.ibnuputra.zipaytest.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.denzcoskun.imageslider.ImageSlider
import com.denzcoskun.imageslider.models.SlideModel
import com.ibnuputra.zipaytest.R
import kotlinx.android.synthetic.main.home_fragment.*

class HomeFragment  :Fragment() {
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val imageList = ArrayList<SlideModel>()
        imageList.add(SlideModel(R.drawable.banner))
        imageList.add(SlideModel(R.drawable.banner))
        imageList.add(SlideModel(R.drawable.banner))

        val view = inflater.inflate(R.layout.home_fragment, container, false)

        val imageSlider = view.findViewById<ImageSlider>(R.id.image_slider)

        imageSlider.setImageList(imageList)

        return view
    }


}