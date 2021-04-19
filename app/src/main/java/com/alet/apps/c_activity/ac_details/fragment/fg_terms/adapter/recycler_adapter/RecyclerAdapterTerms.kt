package com.alet.apps.c_activity.ac_details.fragment.fg_terms.adapter.recycler_adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.alet.apps.R
import com.alet.apps.c_activity.ac_details.fragment.fg_terms.model.Terms
import kotlinx.android.synthetic.main.item_terms.view.*


class RecyclerAdapterTerms(var mcontext: Context, var mData: MutableList<Terms>) :
    RecyclerView.Adapter<RecyclerAdapterTerms.MyViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        val view = LayoutInflater.from(mcontext).inflate(R.layout.item_terms, parent, false)
        return MyViewHolder(view)
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        holder.title.text = mData[position].getTitle()
        holder.description.text = mData[position].getDescription()
    }

    override fun getItemCount(): Int {
        return mData.size
    }

    class MyViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val title: TextView = itemView.tv_terms_title
        val description: TextView = itemView.tv_terms_description

    }
}