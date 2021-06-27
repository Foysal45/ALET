package com.alet.apps.c_activity.ac_details.fragment.fg_faq.view

import android.annotation.SuppressLint
import android.app.Activity
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.content.ContextCompat
import androidx.recyclerview.widget.LinearLayoutManager
import com.alet.apps.R
import com.alet.apps.c_activity.ac_details.fragment.fg_faq.adapter.recycler_adapter.RecyclerAdapterFaq
import com.alet.apps.c_activity.ac_details.fragment.fg_faq.model.FAQ
import kotlinx.android.synthetic.main.fragment_faq.view.*

class FaqFragment : Fragment() {
    var v: View? = null
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        var view = inflater.inflate(R.layout.fragment_faq, container, false)
        init(view)
        action(view)
        return view
    }

    private fun init(view: View) {
        v = view
    }

    private fun action(view: View) {
        var faqList = mutableListOf<FAQ>()
        var recyclerAdapterFaq = RecyclerAdapterFaq(view.context, faqList)
        view.rec_faq.layoutManager = LinearLayoutManager(view.context)
        view.rec_faq.adapter = recyclerAdapterFaq
        faqList.add(FAQ("text of the printing and typesetting industry?","text of the printing and typesetting industry. Lorem Ipsum has been the industry's standard dummy text"))
        faqList.add(FAQ("text of the printing and typesetting industry?","text of the printing and typesetting industry. Lorem Ipsum has been the industry's standard dummy text"))
        faqList.add(FAQ("text of the printing and typesetting industry?","text of the printing and typesetting industry. Lorem Ipsum has been the industry's standard dummy text"))
        faqList.add(FAQ("text of the printing and typesetting industry?","text of the printing and typesetting industry. Lorem Ipsum has been the industry's standard dummy text"))
        faqList.add(FAQ("text of the printing and typesetting industry?","text of the printing and typesetting industry. Lorem Ipsum has been the industry's standard dummy text"))
        faqList.add(FAQ("text of the printing and typesetting industry?","text of the printing and typesetting industry. Lorem Ipsum has been the industry's standard dummy text"))
        faqList.add(FAQ("text of the printing and typesetting industry?","text of the printing and typesetting industry. Lorem Ipsum has been the industry's standard dummy text"))
        recyclerAdapterFaq.notifyDataSetChanged()
    }

}