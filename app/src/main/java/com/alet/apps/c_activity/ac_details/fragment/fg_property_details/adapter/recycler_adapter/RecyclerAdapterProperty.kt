package com.alet.apps.c_activity.ac_details.fragment.fg_property_details.adapter.recycler_adapter

import android.content.Context
import android.content.res.Resources
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.RelativeLayout
import androidx.recyclerview.widget.RecyclerView
import com.alet.apps.R
import com.alet.apps.c_activity.ac_details.fragment.fg_property_details.model.PropertyPhoto
import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.item_property.view.*

class RecyclerAdapterProperty(var mcontext: Context, var mData: MutableList<PropertyPhoto>) :
    RecyclerView.Adapter<RecyclerAdapterProperty.MyViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        val view = LayoutInflater.from(mcontext).inflate(R.layout.item_property, parent, false)
        return MyViewHolder(view)
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        val totalWidth=Resources.getSystem().displayMetrics.widthPixels
        val margin=mcontext.resources.getDimensionPixelSize(R.dimen._34sdp)
        val pading=mcontext.resources.getDimensionPixelSize(R.dimen._8sdp)
        holder.property_lay.layoutParams.width= (totalWidth-margin)/2
        holder.photo.layoutParams.height= (totalWidth-margin-pading)/2
        holder.photo.requestLayout()
        holder.property_lay.requestLayout()
        Picasso.get().load(mData[position].getImgUrl()).into(holder.photo)
    }

    override fun getItemCount(): Int {
        return mData.size
    }

    class MyViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val photo: ImageView = itemView.photo
        val property_lay: RelativeLayout = itemView.property_lay
    }
}