package com.alet.apps.c_activity.ac_details.fragment.fg_property_details.adapter.recycler_adapter

import android.content.Context
import android.content.res.Resources
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.recyclerview.widget.RecyclerView
import com.alet.apps.R
import com.daimajia.androidanimations.library.Techniques
import com.daimajia.androidanimations.library.YoYo
import com.alet.apps.c_activity.ac_details.fragment.fg_property_details.model.PropertyPhoto
import com.squareup.picasso.Picasso
import com.varunest.sparkbutton.SparkButton
import kotlinx.android.synthetic.main.item_property_photo.view.*

class RecyclerAdapterPropertyPhoto(var mcontext: Context, var mData: MutableList<PropertyPhoto>) :
    RecyclerView.Adapter<RecyclerAdapterPropertyPhoto.MyViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        val view = LayoutInflater.from(mcontext).inflate(R.layout.item_property_photo, parent, false)
        return MyViewHolder(view)
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        holder.photo_lay.layoutParams.width= Resources.getSystem().displayMetrics.widthPixels-mcontext.resources.getDimensionPixelSize(R.dimen._50sdp)
        holder.photo_lay.requestLayout()
        Picasso.get().load(mData[position].getImgUrl()).into(holder.photo)

        YoYo.with(Techniques.Pulse)
            .duration(1000)
            .repeat(100)
            .playOn(holder.spark_button);
    }

    override fun getItemCount(): Int {
        return mData.size
    }

    class MyViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val photo: ImageView = itemView.photo
        val spark_button: SparkButton = itemView.spark_button
        val photo_margin: ImageView = itemView.photo_margin
        val photo_lay: ConstraintLayout = itemView.photo_lay
    }
}