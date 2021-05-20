package com.alet.apps.c_activity.ac_details.fragment.fg_job_details.adapter.recycler_adapter

import android.content.ClipData
import android.content.ClipboardManager
import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView
import com.alet.apps.R
import com.alet.apps.c_activity.ac_details.fragment.fg_job_details.model.BulletPoint
import kotlinx.android.synthetic.main.item_bullet_point.view.*


class RecyclerAdapterBulletPoint(
    var mcontext: Context,
    var mData: MutableList<BulletPoint>
) :
    RecyclerView.Adapter<RecyclerAdapterBulletPoint.MyViewHolder>() {
    private val clipboard: ClipboardManager = mcontext.getSystemService(Context.CLIPBOARD_SERVICE) as ClipboardManager


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        val view =
            LayoutInflater.from(mcontext).inflate(R.layout.item_bullet_point, parent, false)
        return MyViewHolder(view)
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        holder.tv_bullet_text.text = mData[position].getPoint()
        holder.iv_bullet_point.setImageResource(mData[position].getImg())
        if (mData[position].isCopyAble()) {
            holder.tv_bullet_text.setOnClickListener {
                clipboard.setPrimaryClip(
                    ClipData.newPlainText(
                        "Copied Text",
                        holder.tv_bullet_text.text
                    )
                )
                Toast.makeText(mcontext,"Text Copied !",Toast.LENGTH_LONG).show()
            }
        }
    }

    override fun getItemCount(): Int {
        return mData.size
    }

    class MyViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val iv_bullet_point: ImageView = itemView.iv_bullet_point
        val tv_bullet_text: TextView = itemView.tv_bullet_text
    }
}