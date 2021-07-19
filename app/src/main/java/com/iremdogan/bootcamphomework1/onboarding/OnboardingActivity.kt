package com.iremdogan.bootcamphomework1.onboarding

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.viewpager.widget.ViewPager
import com.iremdogan.bootcamphomework1.MainActivity
import com.iremdogan.bootcamphomework1.R

class OnboardingActivity : AppCompatActivity(), IViewPagerAdapterClickListener {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_onboarding)
        initializeViewPager()
    }

    private fun initializeViewPager() {
        val  viewpagerAdapter = SliderPagerAdapter(this, getOnboardingItems(), this)
        val viewPager = findViewById<ViewPager>(R.id.viewPager)
        viewPager.adapter = viewpagerAdapter
        viewPager.addOnPageChangeListener(object : ViewPager.OnPageChangeListener {

            override fun onPageScrollStateChanged(state: Int) {
            }

            override fun onPageScrolled(position: Int, positionOffset: Float, positionOffsetPixels: Int) {

            }
            override fun onPageSelected(position: Int) {
                viewpagerAdapter.setIndicatorBackground(position)
            }
        })
    }

    private fun getOnboardingItems(): List<Pair<String, Int>> {
        val onboardingItems = mutableListOf<Pair<String, Int>>()
        return onboardingItems.apply {
            add( Pair(resources.getString(R.string.text_onboarding_first_page_info), R.drawable.ic_receipts))
            add( Pair(resources.getString(R.string.text_onboarding_second_page_info), R.drawable.ic_chart))
            add( Pair(resources.getString(R.string.text_onboarding_third_page_info), R.drawable.ic_location))
        }
    }

    private fun navigateToMainActivity() {
        val intent = Intent(this, MainActivity::class.java)
        startActivity(intent)
    }

    override fun onGetStartedClicked() {
        navigateToMainActivity()
    }
}