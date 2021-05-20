package com.alet.apps.c_activity.ac_details.fragment.fg_job_details.model

class BulletHeader(
    private var title: String,
    private var bulletPoint: MutableList<BulletPoint>,
) {
    fun getTitle(): String {
        return title
    }
    fun getBulletPoint(): MutableList<BulletPoint> {
        return bulletPoint
    }
}