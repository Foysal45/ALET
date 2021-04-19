package com.alet.apps.c_activity.ac_details.fragment.fg_terms.view

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import com.alet.apps.R
import com.alet.apps.c_activity.ac_details.fragment.fg_terms.adapter.recycler_adapter.RecyclerAdapterTerms
import com.alet.apps.c_activity.ac_details.fragment.fg_terms.model.Terms
import kotlinx.android.synthetic.main.fragment_terms.view.*

class TermsFragment : Fragment() {
    var v: View? = null

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        var view = inflater.inflate(R.layout.fragment_terms, container, false)
        init(view)
        action(view)
        return view
    }

    private fun init(view: View) {
        v = view
    }

    private fun action(view: View) {
        terms(view)


    }

    private fun terms(view: View) {
        var termsList = mutableListOf<Terms>()
        var recyclerAdapterTerms = RecyclerAdapterTerms(view.context, termsList)
        view.rec_terms.layoutManager = LinearLayoutManager(view.context)
        view.rec_terms.adapter = recyclerAdapterTerms
        termsList.add(
            Terms(
                "Point Name 1",
                "Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam, quis nostrud exercitation ullamco laboris nisi ut aliquip ex ea commodo consequat. Duis aute irure dolor in reprehenderit in voluptate velit esse cillum dolore eu fugiat nulla pariatur. Excepteur sint occaecat cupidatat non proident, sunt in culpa qui officia deserunt mollit anim id est laborum."
            )
        )
        termsList.add(
            Terms(
                "Point Name 2",
                "Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam, quis nostrud exercitation ullamco laboris nisi ut aliquip ex ea commodo consequat."
            )
        )
        termsList.add(
            Terms(
                "Point Name 3",
                "Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam, quis nostrud exercitation ullamco laboris nisi ut aliquip ex ea commodo consequat. Duis aute irure dolor in reprehenderit in voluptate velit esse cillum dolore eu fugiat nulla pariatur. Excepteur sint occaecat cupidatat non proident"
            )
        )
        recyclerAdapterTerms.notifyDataSetChanged()
    }
}