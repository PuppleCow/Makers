package com.pupplecow.myapplication

import android.content.Context
import android.icu.text.CaseMap
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class AnnouncementListAdapterActivity(val context:Context, val AnnouncementList:ArrayList<AnnounceMentListActivity2>):
    RecyclerView.Adapter<AnnouncementListAdapterActivity.Holder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): Holder {

            val view = LayoutInflater.from(context).inflate(R.layout.activity_frameofannouncementlist, parent, false)
            return Holder(view)
        TODO("Not yet implemented")
    }

        override fun getItemCount(): Int {
            return AnnouncementList.size
        }

        override fun onBindViewHolder(holder: Holder, position: Int) {
            TODO("Not yet implemented")
            holder?.bind(AnnouncementList[position], context)
        }

        inner class Holder(itemView: View?) : RecyclerView.ViewHolder(itemView!!) {
            val date = itemView?.findViewById<TextView>(R.id.frame_textView2)
            val Title = itemView?.findViewById<TextView>(R.id.frame_textView3)
            val EssentialRead = itemView?.findViewById<TextView>(R.id.frame_textView5)

            fun bind(dog: AnnounceMentListActivity2, context: Context) {
                date?.text = dog.Date
                Title?.text = dog.Title
                EssentialRead?.text = dog.EssentialRead
            }
        }


}
