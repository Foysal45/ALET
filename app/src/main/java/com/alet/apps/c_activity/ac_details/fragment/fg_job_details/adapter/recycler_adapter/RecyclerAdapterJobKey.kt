package com.alet.apps.c_activity.ac_details.fragment.fg_job_details.adapter.recycler_adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.alet.apps.R
import com.alet.apps.c_activity.ac_details.fragment.fg_job_details.model.JobKey
import kotlinx.android.synthetic.main.item_job_key.view.*

class RecyclerAdapterJobKey(
    var mcontext: Context,
    var mData: MutableList<JobKey>
) :
    RecyclerView.Adapter<RecyclerAdapterJobKey.MyViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        val view =
            LayoutInflater.from(mcontext).inflate(R.layout.item_job_key, parent, false)
        return MyViewHolder(view)
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        holder.title.text = mData[position].getTitle()
        holder.subTitle.text = mData[position].getSubTitle()
        holder.photo.setImageResource(mData[position].getImg())
    }

    override fun getItemCount(): Int {
        return mData.size
    }

    class MyViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val photo: ImageView = itemView.iv_icon
        val title: TextView = itemView.tv_title
        val subTitle: TextView = itemView.tv_sub_title
    }
}