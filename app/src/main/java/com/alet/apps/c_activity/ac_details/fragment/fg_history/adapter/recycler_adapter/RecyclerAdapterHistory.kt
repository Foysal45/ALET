package com.alet.apps.c_activity.ac_details.fragment.fg_history.adapter.recycler_adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.alet.apps.R
import com.alet.apps.c_activity.ac_details.fragment.fg_history.model.History
import kotlinx.android.synthetic.main.item_history.view.*


class RecyclerAdapterHistory(var mcontext: Context, var mData: MutableList<History>) :
    RecyclerView.Adapter<RecyclerAdapterHistory.MyViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        val view = LayoutInflater.from(mcontext).inflate(R.layout.item_history, parent, false)
        return MyViewHolder(view)
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        holder.description.text = mData[position].getDescription()
        holder.time.text = mData[position].getTime()
        holder.date.text = mData[position].getDate()
    }

    override fun getItemCount(): Int {
        return mData.size
    }

    class MyViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val description: TextView = itemView.tv_history_description
        val date: TextView = itemView.tv_history_date
        val time: TextView = itemView.tv_history_time

    }
}