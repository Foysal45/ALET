package com.alet.apps.c_activity.base_ac.view

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.alet.apps.R

class BaseActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_base)
    }
}