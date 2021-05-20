package com.alet.apps.c_activity.ac_details.fragment.fg_job_details.model

class JobKey(
    private var img: Int,
    private var title: String,
    private var subTitle: String
) {
    fun getImg(): Int {
        return img
    }

    fun getTitle(): String {
        return title
    }

    fun getSubTitle(): String {
        return subTitle
    }
}