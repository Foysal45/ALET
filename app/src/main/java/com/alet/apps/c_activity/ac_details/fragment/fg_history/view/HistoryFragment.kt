package com.alet.apps.c_activity.ac_details.fragment.fg_history.view

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.viewpager.widget.ViewPager
import com.alet.apps.R
import com.alet.apps.c_adapter.viewpager_adapter.ViewPageAdapter
import com.alet.apps.enam.HistoryType
import com.google.android.material.tabs.TabLayout

class HistoryFragment : Fragment() {
    var v: View? = null
    private var tabLayout: TabLayout? = null
    private var viewPager: ViewPager? = null
    private var adapter: ViewPageAdapter? = null
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        var view = inflater.inflate(R.layout.fragment_history, container, false)
        init(view)
        action(view)
        return view
    }
    private fun init(view: View) {
        v = view
        tabLayout = view.findViewById<TabLayout>(R.id.tablayout_id)
        viewPager = view.findViewById<ViewPager>(R.id.viewpager_id)
        adapter = ViewPageAdapter(activity!!.supportFragmentManager)
    }

    private fun action(view: View) {
        viewpagerTab(view)


    }

    private fun viewpagerTab(view: View) {
        //add fragment
        adapter!!.addFragment(ChildHistoryFragment.newInstance(HistoryType.All.toString()), HistoryType.All.toString())
        adapter!!.addFragment(ChildHistoryFragment.newInstance(HistoryType.PENDING.toString()), HistoryType.PENDING.toString())
        adapter!!.addFragment(ChildHistoryFragment.newInstance(HistoryType.APPROVED.toString()), HistoryType.APPROVED.toString())
        adapter!!.addFragment(ChildHistoryFragment.newInstance(HistoryType.REJECT.toString()), HistoryType.REJECT.toString())
        // adding setup
        viewPager!!.adapter = adapter
        tabLayout!!.setupWithViewPager(viewPager)
    }

}