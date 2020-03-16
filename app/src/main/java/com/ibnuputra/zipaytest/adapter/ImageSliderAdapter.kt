package com.ibnuputra.zipaytest.adapter

import android.content.Context
import android.os.Parcelable
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import androidx.viewpager.widget.PagerAdapter
import com.ibnuputra.zipaytest.R
import com.ibnuputra.zipaytest.model.ImageSlider

class ImageSliderAdapter(private val context: Context, private val imageModelArrayList : ArrayList<ImageSlider>):PagerAdapter() {
    private val inflater: LayoutInflater = LayoutInflater.from(context)

    override fun destroyItem(container: ViewGroup, position: Int, `object`: Any) {
        container.removeView(`object` as View)
    }

    override fun getCount(): Int {
        return imageModelArrayList.size
    }

    override fun instantiateItem(view: ViewGroup, position: Int): Any {
        val imageLayout = inflater.inflate(R.layout.sliding_image_layout, view, false)!!

        val imageView = imageLayout
            .findViewById(R.id.image) as ImageView


        imageView.setImageResource(imageModelArrayList[position].getImageDrawable())

        view.addView(imageLayout, 0)

        return imageLayout
    }

    override fun isViewFromObject(view: View, `object`: Any): Boolean {
        return view == `object`
    }

    override fun restoreState(state: Parcelable?, loader: ClassLoader?) {}

    override fun saveState(): Parcelable? {
        return null
    }

}