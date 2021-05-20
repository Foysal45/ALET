package com.alet.apps.c_activity.ac_details.fragment.fg_property_details.model

class PropertyFeature(
    private var img: Int,
    private var title: String
) {
    fun getImg(): Int {
        return img
    }

    fun getTitle(): String {
        return title
    }
}