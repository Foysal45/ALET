package com.alet.apps.c_activity.ac_details.fragment.fg_faq.adapter.recycler_adapter

import android.content.Context
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.RelativeLayout
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.alet.apps.R
import com.alet.apps.c_activity.ac_details.fragment.fg_faq.model.FAQ
import kotlinx.android.synthetic.main.item_faq.view.*
import java.util.HashMap

class RecyclerAdapterFaq(var mcontext: Context, var mData: MutableList<FAQ>) :
    RecyclerView.Adapter<RecyclerAdapterFaq.MyViewHolder>() {
    var checkHash: HashMap<Int, Boolean> = HashMap()
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        val view = LayoutInflater.from(mcontext).inflate(R.layout.item_faq, parent, false)
        return MyViewHolder(view)
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        holder.question.text = mData[position].getQuestion()
        holder.answer.text = mData[position].getAnswer()
        if (checkHash.containsKey(position)) {
            if (checkHash[position]!!) {
                holder.answer.visibility = View.VISIBLE
                holder.icon.rotation = 0f
                holder.question_lay.setBackgroundResource(R.drawable.shape_rec_solid_white_4dp_orange_strock)
            } else {
                holder.answer.visibility = View.GONE
                holder.icon.rotation = -90f
                holder.question_lay.setBackgroundResource(R.drawable.shape_rec_solid_white_4dp)
            }
        } else {
            holder.answer.visibility = View.GONE
            holder.icon.rotation = -90f
            holder.question_lay.setBackgroundResource(R.drawable.shape_rec_solid_white_4dp)
        }
        holder.question_lay.setOnClickListener(View.OnClickListener {
            if (holder.answer.visibility == View.VISIBLE) {
                holder.answer.visibility = View.GONE
                holder.icon.rotation = -90f
                holder.question_lay.setBackgroundResource(R.drawable.shape_rec_solid_white_4dp)
                checkHash[position] = false
            } else {
                holder.answer.visibility = View.VISIBLE
                holder.icon.rotation = 0f
                holder.question_lay.setBackgroundResource(R.drawable.shape_rec_solid_white_4dp_orange_strock)
                checkHash[position] = true
            }
        })
    }

    override fun getItemCount(): Int {
        return mData.size
    }

    class MyViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val question: TextView = itemView.tv_faq_question
        val answer: TextView = itemView.tv_faq_answer
        val icon: ImageView = itemView.iv_question_icon
        val question_lay: RelativeLayout = itemView.question_lay
    }
}