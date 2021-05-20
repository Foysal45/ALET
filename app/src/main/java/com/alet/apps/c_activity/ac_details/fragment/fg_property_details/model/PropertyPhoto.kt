package com.alet.apps.c_activity.ac_details.fragment.fg_property_details.model

class PropertyPhoto(
    private var imgUrl: String?
) {
    fun getImgUrl(): String {
        if (imgUrl.equals(null))
            return ""
        return imgUrl!!
    }
}