package com.example.myapplication.onboarding

import android.content.Intent
import android.content.SharedPreferences
import android.os.Bundle
import android.text.Html
import android.widget.Button
import android.widget.LinearLayout
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.viewpager.widget.ViewPager
import com.example.myapplication.R
import com.example.myapplication.signup.SignInActivity
import me.inassar.onboardingfreebi.view.adapter.SliderAdapter

class OnBoardingActivity : AppCompatActivity() {

    private lateinit var slider: ViewPager
    private lateinit var nextBtn: Button
    private lateinit var skipBtn: Button
    private lateinit var startBtn: Button
    private lateinit var dotsLayout: LinearLayout
    private lateinit var sliderAdapter: SliderAdapter
    private var dots: Array<TextView?>? = null
    private lateinit var layouts: Array<Int>

    private val sliderChangeListener = object : ViewPager.OnPageChangeListener {
        override fun onPageSelected(position: Int) {
            addBottomDots(position)

            if (position == layouts.size - 1) {
                nextBtn.visibility = Button.GONE
                skipBtn.visibility = Button.GONE
                startBtn.visibility = Button.VISIBLE
            } else {
                nextBtn.visibility = Button.VISIBLE
                skipBtn.visibility = Button.VISIBLE
                startBtn.visibility = Button.GONE
            }
        }

        override fun onPageScrollStateChanged(state: Int) {}

        override fun onPageScrolled(position: Int, positionOffset: Float, positionOffsetPixels: Int) {}
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_on_boarding)

        init()
        dataSet()
        interactions()
    }

    private fun init() {
        slider = findViewById(R.id.slider)
        nextBtn = findViewById(R.id.nextBtn)
        skipBtn = findViewById(R.id.skipBtn)
        startBtn = findViewById(R.id.startBtn)
        dotsLayout = findViewById(R.id.dotsLayout)

        layouts = arrayOf(
            R.layout.onboarding_slide1,
            R.layout.onboarding_slide2,
            R.layout.onboarding_slide3
        )

        sliderAdapter = SliderAdapter(this, layouts)
    }

    private fun dataSet() {
        addBottomDots(0)
        slider.adapter = sliderAdapter
        slider.addOnPageChangeListener(sliderChangeListener)
    }

    private fun interactions() {
        skipBtn.setOnClickListener { navigateToLogin() }
        startBtn.setOnClickListener { navigateToLogin() }
        nextBtn.setOnClickListener {
            val current = getCurrentScreen(+1)
            if (current < layouts.size) {
                slider.currentItem = current
            } else {
                navigateToLogin()
            }
        }
    }

    private fun navigateToLogin() {
        val sharedPreferences = getSharedPreferences("MyPrefs", MODE_PRIVATE)
        val editor = sharedPreferences.edit()
        editor.putBoolean("isFirstTime", false) // Mark onboarding as completed
        editor.apply()

        startActivity(Intent(this, SignInActivity::class.java))
        finish()
    }

    private fun addBottomDots(currentPage: Int) {
        dots = arrayOfNulls(layouts.size)
        dotsLayout.removeAllViews()
        for (i in dots!!.indices) {
            dots!![i] = TextView(this)
            dots!![i]?.text = Html.fromHtml("&#8226;")
            dots!![i]?.textSize = 35f
            dots!![i]?.setTextColor(resources.getColor(R.color.colorGrey, theme))
            dotsLayout.addView(dots!![i])
        }
        dots?.get(currentPage)?.setTextColor(resources.getColor(R.color.colorIndigo, theme))
    }

    private fun getCurrentScreen(i: Int): Int = slider.currentItem + i
}
