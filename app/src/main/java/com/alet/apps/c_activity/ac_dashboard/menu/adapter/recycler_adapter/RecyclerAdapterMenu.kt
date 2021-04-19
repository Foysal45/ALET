package com.alet.apps.c_activity.ac_dashboard.menu.adapter.recycler_adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.alet.apps.R
import com.alet.apps.c_activity.ac_dashboard.menu.model.DrawerMenu
import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.item_drawer_menu.view.*


class RecyclerAdapterMenu(var mcontext: Context, var mData: MutableList<DrawerMenu>) :
    RecyclerView.Adapter<RecyclerAdapterMenu.MyViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        val view = LayoutInflater.from(mcontext).inflate(R.layout.item_drawer_menu, parent, false)
        return MyViewHolder(view)
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        holder.title.text = mData[position].getTitle()
        holder.image.setImageResource(mData[position].getImg())
    }

    override fun getItemCount(): Int {
        return mData.size
    }

    class MyViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val image: ImageView = itemView.iv_menu_img
        val title: TextView = itemView.tv_menu_title

    }
}