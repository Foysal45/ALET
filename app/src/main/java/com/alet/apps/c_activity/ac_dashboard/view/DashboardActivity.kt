package com.alet.apps.c_activity.ac_dashboard.view

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import com.alet.apps.R
import com.alet.apps.c_activity.ac_dashboard.menu.adapter.recycler_adapter.RecyclerAdapterMenu
import com.alet.apps.c_activity.ac_dashboard.menu.model.DrawerMenu
import kotlinx.android.synthetic.main.activity_dashboard.*

class DashboardActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_dashboard)
        init()
        action()
    }

    private fun init() {
        menu()

    }

    private fun menu() {
        var menuList = mutableListOf<DrawerMenu>()
        var recyclerAdapterMenu = RecyclerAdapterMenu(this, menuList)
        rec_menu.layoutManager = LinearLayoutManager(this)
        rec_menu.adapter = recyclerAdapterMenu
        menuList.add(DrawerMenu(R.drawable.ic_drawer_home, "Home"))
        menuList.add(DrawerMenu(R.drawable.ic_drawer_create_post, "Create Post"))
        menuList.add(DrawerMenu(R.drawable.ic_drawer_profile, "Profile"))
        menuList.add(DrawerMenu(R.drawable.ic_drawer_history, "History"))
        menuList.add(DrawerMenu(R.drawable.ic_drawer_fav, "Favorites"))
        menuList.add(DrawerMenu(R.drawable.ic_drawer_settings, "Settings"))
        menuList.add(DrawerMenu(R.drawable.ic_drawer_terms, "Terms & Condition"))
        menuList.add(DrawerMenu(R.drawable.ic_drawer_faq, "FAQs"))
        menuList.add(DrawerMenu(R.drawable.ic_drawer_about, "About"))
        recyclerAdapterMenu.notifyDataSetChanged()
    }

    private fun action() {

    }
}