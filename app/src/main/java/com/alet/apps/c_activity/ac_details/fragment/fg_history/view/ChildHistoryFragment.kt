package com.alet.apps.c_activity.ac_details.fragment.fg_history.view

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import com.alet.apps.R
import com.alet.apps.c_activity.ac_details.fragment.fg_history.adapter.recycler_adapter.RecyclerAdapterHistory
import com.alet.apps.c_activity.ac_details.fragment.fg_history.model.History
import com.alet.apps.c_activity.ac_details.fragment.fg_terms.adapter.recycler_adapter.RecyclerAdapterTerms
import com.alet.apps.c_activity.ac_details.fragment.fg_terms.model.Terms
import com.alet.apps.enam.HistoryType
import kotlinx.android.synthetic.main.fragment_child_history.view.*
import kotlinx.android.synthetic.main.fragment_terms.view.*

private const val HISTORYTYPE = "historyType"


class ChildHistoryFragment : Fragment() {
    private var historyType: String? = null
    var v: View? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
            historyType = it.getString(HISTORYTYPE)
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        var view = inflater.inflate(R.layout.fragment_child_history, container, false)
        init(view)
        action(view)
        return view
    }

    private fun init(view: View) {
        v = view
    }

    private fun action(view: View) {

        var historyList = mutableListOf<History>()
        var recyclerAdapterHistory = RecyclerAdapterHistory(view.context, historyList)
        view.rec_history.layoutManager = LinearLayoutManager(view.context)
        view.rec_history.adapter = recyclerAdapterHistory

        historyList.add(History("Lorem Ipsum is simply dummy text of the printing and typesetting industry. Lorem Ipsum has been the industry's standard dummy text ever since the 1500s, when an unknown printer took a galley of type and scrambled it to make a type specimen book.","11 Feb,2021","08.09 PM"))
        historyList.add(History("Lorem Ipsum is simply dummy text of the printing and typesetting industry. Lorem Ipsum has been the industry's standard dummy text ever since the 1500s, when an unknown printer took a galley of type and scrambled it to make a type specimen book.","11 Feb,2021","08.09 PM"))
        historyList.add(History("Lorem Ipsum is simply dummy text of the printing and typesetting industry. Lorem Ipsum has been the industry's standard dummy text ever since the 1500s, when an unknown printer took a galley of type and scrambled it to make a type specimen book.","11 Feb,2021","08.09 PM"))
        historyList.add(History("Lorem Ipsum is simply dummy text of the printing and typesetting industry. Lorem Ipsum has been the industry's standard dummy text ever since the 1500s, when an unknown printer took a galley of type and scrambled it to make a type specimen book.","11 Feb,2021","08.09 PM"))
        historyList.add(History("Lorem Ipsum is simply dummy text of the printing and typesetting industry. Lorem Ipsum has been the industry's standard dummy text ever since the 1500s, when an unknown printer took a galley of type and scrambled it to make a type specimen book.","11 Feb,2021","08.09 PM"))
        historyList.add(History("Lorem Ipsum is simply dummy text of the printing and typesetting industry. Lorem Ipsum has been the industry's standard dummy text ever since the 1500s, when an unknown printer took a galley of type and scrambled it to make a type specimen book.","11 Feb,2021","08.09 PM"))
        historyList.add(History("Lorem Ipsum is simply dummy text of the printing and typesetting industry. Lorem Ipsum has been the industry's standard dummy text ever since the 1500s, when an unknown printer took a galley of type and scrambled it to make a type specimen book.","11 Feb,2021","08.09 PM"))
        recyclerAdapterHistory.notifyDataSetChanged()

        if (historyType != null) {
            when (historyType) {
                HistoryType.All.toString() -> {
                }
                HistoryType.PENDING.toString() -> {
                }
                HistoryType.APPROVED.toString() -> {
                }
                HistoryType.REJECT.toString() -> {
                }
            }

        }
    }

    companion object {
        @JvmStatic
        fun newInstance(historyType: String) =
            ChildHistoryFragment().apply {
                arguments = Bundle().apply {
                    putString(HISTORYTYPE, historyType)
                }
            }
    }
}