package com.alet.apps.c_activity.ac_details.fragment.fg_property_details.adapter.recycler_adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.alet.apps.R
import com.alet.apps.c_activity.ac_details.fragment.fg_property_details.model.PropertyFeature
import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.item_property_feature.view.*

class RecyclerAdapterPropertyFeature(
    var mcontext: Context,
    var mData: MutableList<PropertyFeature>
) :
    RecyclerView.Adapter<RecyclerAdapterPropertyFeature.MyViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        val view =
            LayoutInflater.from(mcontext).inflate(R.layout.item_property_feature, parent, false)
        return MyViewHolder(view)
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        holder.title.text = mData[position].getTitle()
        holder.photo.setImageResource(mData[position].getImg())
    }

    override fun getItemCount(): Int {
        return mData.size
    }

    class MyViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val photo: ImageView = itemView.photo
        val title: TextView = itemView.title
    }
}