package com.ibnuputra.zipaytest.model

class ImageSlider {

    private var image_drawables: Int = 0

    fun getImageDrawable():Int{
        return image_drawables
    }

    fun setImageDrawable(image_drawable: Int){
        this.image_drawables = image_drawable
    }
}