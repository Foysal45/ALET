package com.alet.apps.c_activity.ac_welcome.view

import android.content.Intent
import android.os.Bundle
import android.text.Html
import android.view.View
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.viewpager.widget.ViewPager
import com.alet.apps.R
import com.alet.apps.c_activity.ac_auth.view.AuthCommonActivity
import com.alet.apps.c_activity.ac_welcome.adapter.viewpager_adapter.SliderAdapter
import kotlinx.android.synthetic.main.activity_welcome.*

class WelcomeActivity : AppCompatActivity() {
    val mdots = arrayOfNulls<TextView>(3)
    lateinit var sliderAdapter: SliderAdapter
    private var mCurrentPage = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_welcome)



        sliderAdapter = SliderAdapter(this)
        viewpager_id.setAdapter(sliderAdapter)

        addDotsIndicator(0)
        viewpager_id.addOnPageChangeListener(viewListener)

        next_btn.setOnClickListener(View.OnClickListener {
            viewpager_id.setCurrentItem(
                mCurrentPage + 1
            )
        })
        skip_btn.setOnClickListener(View.OnClickListener {
            startActivity(Intent(this, AuthCommonActivity::class.java))
            overridePendingTransition(android.R.anim.fade_in, android.R.anim.fade_out)
            this.finish()
        })
        start_btn.setOnClickListener(View.OnClickListener {
            startActivity(Intent(this, AuthCommonActivity::class.java))
            overridePendingTransition(android.R.anim.fade_in, android.R.anim.fade_out)
            this.finish()
        })


    }

    fun addDotsIndicator(position: Int) {
        dotsLayout.removeAllViews()
        for (i in mdots.indices) {
            mdots[i] = TextView(this)
            mdots[i]!!.text = Html.fromHtml("&#8226")
            mdots[i]!!.textSize = 35f
            mdots[i]!!.setTextColor(resources.getColor(R.color.colorBlack))
            dotsLayout.addView(mdots[i])
        }
        if (mdots.isNotEmpty()) mdots[position]!!.setTextColor(resources.getColor(R.color.colorWhite))
    }



    var viewListener: ViewPager.OnPageChangeListener = object : ViewPager.OnPageChangeListener {

        override fun onPageScrolled(position: Int, positionOffset: Float, positionOffsetPixels: Int) {}
        override fun onPageSelected(position: Int) {
            addDotsIndicator(position)
            mCurrentPage = position
            when (position) {
                0 -> {
                    start_btn.visibility = View.GONE
                    next_btn.visibility = View.VISIBLE
                    skip_btn.visibility = View.VISIBLE
                    dotsLayout.visibility = View.VISIBLE
                }
                mdots.size - 1 -> {
                    start_btn.visibility = View.VISIBLE
                    next_btn.visibility = View.GONE
                    skip_btn.visibility = View.GONE
                    dotsLayout.visibility = View.GONE
                }
                else -> {
                    next_btn.text = "Next"
                    start_btn.visibility = View.GONE
                    dotsLayout.visibility = View.VISIBLE
                    next_btn.visibility = View.VISIBLE
                    skip_btn.visibility = View.VISIBLE
                }
            }
        }

       override fun onPageScrollStateChanged(state: Int) {}
    }

}