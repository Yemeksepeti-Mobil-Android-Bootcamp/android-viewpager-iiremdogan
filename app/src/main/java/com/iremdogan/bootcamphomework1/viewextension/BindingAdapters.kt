package com.iremdogan.bootcamphomework1.viewextension

import android.widget.ImageView
import com.iremdogan.bootcamphomework1.R

//Extension for ImageView to change its background

fun ImageView.setIndicatorBackground(isSelected: Boolean) {
    if (isSelected) {
        this.background = this.context.getDrawable(R.drawable.shape_selected_indicator)
    } else {
        this.background = this.context.getDrawable(R.drawable.shape_unselected_indicator)
    }
}