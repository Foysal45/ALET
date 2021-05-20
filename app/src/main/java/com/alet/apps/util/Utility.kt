package com.alet.apps.util

import android.app.Activity
import android.content.Context
import android.util.DisplayMetrics
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentActivity
import com.alet.apps.R
import com.alet.apps.enam.AcName

/**
 * Utility.kt
 * ALET
 * Crated by Towhidur Rahman on 04-Mar-21
 * Copyright © 2021 SIMEC System LTD. All rights reserved.
 */
object Utility {


    fun replaceFramgentWithoutBackStack(acName: AcName, activity: Activity, fragment: Fragment) {
        val fragmentManager1 = (activity as FragmentActivity).supportFragmentManager
        val fragmentTransaction = fragmentManager1.beginTransaction()
        when (acName) {
            AcName.AUTH -> {
                fragmentTransaction.replace(R.id.container_auth, fragment)
            }
            AcName.DETAILS -> {
                fragmentTransaction.replace(R.id.container_details, fragment)
            }
            AcName.SPLASH -> TODO()
            AcName.WELCOME -> TODO()
            AcName.DASHBOARD -> TODO()
        }
        fragmentTransaction.commitAllowingStateLoss()
    }

    fun replaceFramgentWithBackStack(acName: AcName, context: Context, fragment: Fragment) {
        val fragmentManager = (context as FragmentActivity).supportFragmentManager
        val fragmentTransaction = fragmentManager.beginTransaction()
        fragmentTransaction.addToBackStack(fragment.javaClass.name)
        when (acName) {
            AcName.AUTH -> {
                fragmentTransaction.add(R.id.container_auth, fragment)
            }
            AcName.DETAILS -> {
                fragmentTransaction.replace(R.id.container_details, fragment)
            }
            AcName.SPLASH -> TODO()
            AcName.WELCOME -> TODO()
            AcName.DASHBOARD -> TODO()
        }
        fragmentTransaction.commitAllowingStateLoss()
    }


    fun replaceFramgentWithoutBackStack(acName: AcName, context: Context, fragment: Fragment) {
        val fragmentManager = (context as FragmentActivity).supportFragmentManager
        val fragmentTransaction = fragmentManager.beginTransaction()
        when (acName) {
            AcName.AUTH -> {
                fragmentTransaction.add(R.id.container_auth, fragment)
            }
            AcName.DETAILS -> {
                fragmentTransaction.replace(R.id.container_details, fragment)
            }
            AcName.SPLASH -> TODO()
            AcName.WELCOME -> TODO()
            AcName.DASHBOARD -> TODO()
        }
        fragmentTransaction.commitAllowingStateLoss()
    }
}