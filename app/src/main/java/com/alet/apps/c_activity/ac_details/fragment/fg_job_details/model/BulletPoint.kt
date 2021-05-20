package com.alet.apps.c_activity.ac_details.fragment.fg_job_details.model

import com.alet.apps.R

class BulletPoint(
    private var point: String,
    private var img: Int= R.drawable.shape_rec_dice,
    private var copyAble: Boolean=false
) {
    fun getImg(): Int {
        return img
    }

    fun isCopyAble(): Boolean {
        return copyAble
    }

    fun getPoint(): String {
        return point
    }
}