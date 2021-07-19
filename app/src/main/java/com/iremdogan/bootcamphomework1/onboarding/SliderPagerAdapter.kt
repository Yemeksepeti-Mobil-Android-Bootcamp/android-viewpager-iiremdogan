package com.iremdogan.bootcamphomework1.onboarding

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.widget.AppCompatButton
import androidx.viewpager.widget.PagerAdapter
import com.iremdogan.bootcamphomework1.R
import com.iremdogan.bootcamphomework1.viewextension.setIndicatorBackground


class SliderPagerAdapter(private val context: Context, private val items: List<Pair<String, Int>>, private val getStartedClickListener: IViewPagerAdapterClickListener): PagerAdapter() {

    private lateinit var view: View
    private var lastSelectedPosition = 0
    override fun getCount(): Int = 3

    override fun isViewFromObject(view: View, `object`: Any): Boolean = view == `object`

    override fun instantiateItem(container: ViewGroup, position: Int): Any {
        val layoutInflater = context.getSystemService(Context.LAYOUT_INFLATER_SERVICE) as LayoutInflater
        view = layoutInflater.inflate(R.layout.layout_onboarding_slider, container, false)
        container.addView(view)
        val item = items[position]
        val imageViewIcon = view.findViewById<ImageView>(R.id.imageViewOnboardingIcon)
        imageViewIcon.setBackgroundResource(item.second)
        val textViewOnboarding = view.findViewById<TextView>(R.id.textViewOnboarding)
        textViewOnboarding.text = item.first
        val getStartedButton = view.findViewById<AppCompatButton>(R.id.buttonGetStarted)
        getStartedButton.setOnClickListener {
            getStartedClickListener.onGetStartedClicked()
        }
        val imageView = getIndicator(lastSelectedPosition)
        imageView?.setIndicatorBackground(isSelected = true)
        return view
    }

    private fun getIndicator(position: Int): ImageView? {
        return when (position) {
            0 -> {
                view.findViewById(R.id.indicator1)
            }
            1 -> {
                view.findViewById(R.id.indicator2)
            }
            2 -> {
                view.findViewById(R.id.indicator3)
            }
            else -> null
        }
    }

    fun setIndicatorBackground(newPosition: Int) {
        val imageView = getIndicator(newPosition)
        imageView?.setIndicatorBackground(isSelected = true)
        val oldImageView = getIndicator(lastSelectedPosition)
        oldImageView?.setIndicatorBackground(isSelected = false)
        lastSelectedPosition = newPosition
    }

    override fun destroyItem(container: ViewGroup, position: Int, `object`: Any) {
        container.removeView(`object` as View)
    }
}