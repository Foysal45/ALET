package com.alet.apps.c_activity.ac_dashboard.menu.model

class DrawerMenu(
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