package com.pupplecow.myapplication.ui.announcement

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.pupplecow.myapplication.R
import kotlin.collections.ArrayList

class AnnouncementListAdapterActivity(val context:Context, val announcementList:ArrayList<AnnounceMentList>, val itemClick: (AnnounceMentList) -> Unit):
    RecyclerView.Adapter<AnnouncementListAdapterActivity.Holder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): Holder {

        val view = LayoutInflater.from(context).inflate(R.layout.activity_frameofannouncementlist, parent, false)
        return Holder(view,itemClick)
    }

    override fun getItemCount(): Int {
        return announcementList.size
    }

    override fun onBindViewHolder(holder: Holder, position: Int) {
        holder?.bind(announcementList[position], context)
    }

    inner class Holder(itemView: View,itemClick: (AnnounceMentList) -> Unit) : RecyclerView.ViewHolder(itemView) {
        val Date = itemView?.findViewById<TextView>(R.id.frame_textView2)
        val Category = itemView?.findViewById<TextView>(R.id.frame_textView6)
        val Title = itemView?.findViewById<TextView>(R.id.frame_textView3)
        //val EssentialRead = itemView?.findViewById<TextView>(R.id.frame_textView5)

        fun bind(Announce: AnnounceMentList, context: Context) {
            Date?.text= Announce.Date
            Category.text = Announce.Category
            Title?.text= Announce.Title
            //EssentialRead?.text= Announce.EssentialRead

            //itemview를 클릭하면 itemClick(수행)
            itemView.setOnClickListener { itemClick(Announce) }

        }

    }


}
