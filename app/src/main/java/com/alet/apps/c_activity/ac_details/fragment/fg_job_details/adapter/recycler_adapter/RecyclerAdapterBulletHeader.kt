package com.alet.apps.c_activity.ac_details.fragment.fg_job_details.adapter.recycler_adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.LinearLayout
import android.widget.TextView
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.alet.apps.R
import com.alet.apps.c_activity.ac_details.fragment.fg_job_details.model.BulletHeader
import kotlinx.android.synthetic.main.item_bullet_header.view.*


class RecyclerAdapterBulletHeader(
    var mcontext: Context,
    var mData: MutableList<BulletHeader>
) :
    RecyclerView.Adapter<RecyclerAdapterBulletHeader.MyViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        val view =
            LayoutInflater.from(mcontext).inflate(R.layout.item_bullet_header, parent, false)
        return MyViewHolder(view)
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        if (position % 2 == 0) {
            holder.ll_bullet_lay.setBackgroundResource(R.color.colorWhite)
        } else
            holder.ll_bullet_lay.setBackgroundResource(R.color.colorLowGray)
        holder.tv_bullet_header.text = mData[position].getTitle()
        holder.rec_bullet.layoutManager = LinearLayoutManager(mcontext)
        holder.rec_bullet.adapter =
            RecyclerAdapterBulletPoint(mcontext, mData[position].getBulletPoint())

    }

    override fun getItemCount(): Int {
        return mData.size
    }

    class MyViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val ll_bullet_lay: LinearLayout = itemView.ll_bullet_lay
        val rec_bullet: RecyclerView = itemView.rec_bullet
        val tv_bullet_header: TextView = itemView.tv_bullet_header
    }
}