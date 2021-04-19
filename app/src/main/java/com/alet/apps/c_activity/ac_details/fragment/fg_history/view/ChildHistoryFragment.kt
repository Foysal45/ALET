package com.alet.apps.c_activity.ac_details.fragment.fg_history.view

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.alet.apps.R
import com.alet.apps.enam.HistoryType
import kotlinx.android.synthetic.main.fragment_child_history.view.*

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
        if (historyType != null) {
            view.sampleText.text = historyType
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