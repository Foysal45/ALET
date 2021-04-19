package com.alet.apps.c_activity.ac_splash.view

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.view.animation.*
import com.alet.apps.R
import com.alet.apps.c_activity.ac_dashboard.view.DashboardActivity
import com.alet.apps.c_activity.ac_welcome.view.WelcomeActivity
import kotlinx.android.synthetic.main.activity_splash.*

class SplashActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash)
        background_circle.animate().setDuration(5000).setStartDelay(100).scaleY(8f).scaleX(8f).start()

        Handler().postDelayed(
            {
               /* if (sharedPref!!.isLogin!!)
                    startActivity(Intent(this, HomeActivity::class.java))
                else
                    startActivity(Intent(this, MainActivity::class.java))
                if (sharedPref!!.isLogin!!)
                    startActivity(Intent(this, HomeActivity::class.java))
                else*/
                    startActivity(Intent(this, DashboardActivity::class.java))
                overridePendingTransition(R.anim.fade_in, R.anim.fade_out)
                this.finish()
            }, 3100
        )
    }
}