package com.pupplecow.myapplication

import android.content.Context
import android.icu.text.CaseMap
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import java.util.*
import kotlin.collections.ArrayList

class AnnouncementListAdapterActivity(val context:Context, val AnnouncementList:ArrayList<AnnounceMentListActivity2>):
    RecyclerView.Adapter<AnnouncementListAdapterActivity.Holder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): Holder {

            val view = LayoutInflater.from(context).inflate(R.layout.activity_frameofannouncementlist, parent, false)
            return Holder(view)
    }

        override fun getItemCount(): Int {
            return AnnouncementList.size
        }

        override fun onBindViewHolder(holder: Holder, position: Int) {
            holder?.bind(AnnouncementList[position], context)
        }

        inner class Holder(itemView: View?) : RecyclerView.ViewHolder(itemView!!) {
            val date = itemView?.findViewById<TextView>(R.id.frame_textView2)
            val Title = itemView?.findViewById<TextView>(R.id.frame_textView3)
            val EssentialRead = itemView?.findViewById<TextView>(R.id.frame_textView5)

            fun bind(AnnouncementListActivity2: AnnounceMentListActivity2, context: Context) {
                date?.text = AnnouncementListActivity2.Date
                Title?.text = AnnouncementListActivity2.Title
                EssentialRead?.text = AnnouncementListActivity2.EssentialRead
            }

        }


}
