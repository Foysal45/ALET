package com.alet.apps.c_activity.ac_details.fragment.fg_history.model

class History(
    private var description: String?,
    private var date: String?,
    private var time: String?
    ) {
    fun getDate(): String {
        if (date.equals(null))
            return ""
        return date!!
    }

    fun getTime(): String {
        if (time.equals(null))
            return ""
        return time!!
    }

    fun getDescription(): String {
        if (description.equals(null))
            return ""
        return description!!
    }
}