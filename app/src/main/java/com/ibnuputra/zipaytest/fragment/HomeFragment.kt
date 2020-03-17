package com.ibnuputra.zipaytest.fragment

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.LinearLayout
import androidx.fragment.app.Fragment
import com.denzcoskun.imageslider.ImageSlider
import com.denzcoskun.imageslider.models.SlideModel
import com.ibnuputra.zipaytest.PaymentActivity
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
        val topUp = view.findViewById(R.id.topUp) as LinearLayout

        imageSlider.setImageList(imageList)

        topUp.setOnClickListener {
            val intent = Intent(context, PaymentActivity::class.java)
            startActivity(intent)
        }

        return view
    }


}