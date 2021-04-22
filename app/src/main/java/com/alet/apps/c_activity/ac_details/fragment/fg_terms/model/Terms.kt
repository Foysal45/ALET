package com.alet.apps.c_activity.ac_details.fragment.fg_terms.model

class Terms(
    private var title: String?,
    private var description: String?) {
    fun getTitle(): String {
        if (title.equals(null))
            return ""
        return title!!
    }

    fun getDescription(): String {
        if (description.equals(null))
            return ""
        return description!!
    }
}