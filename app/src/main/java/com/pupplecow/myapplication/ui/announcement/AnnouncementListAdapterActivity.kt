
package com.pupplecow.myapplication.ui.announcement

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.google.firebase.firestore.FirebaseFirestore
import com.pupplecow.myapplication.R
import com.pupplecow.myapplication.ui.manager.announcement.AnnouncementData
import kotlin.collections.ArrayList

class AnnouncementListAdapterActivity(val context:Context, val itemClick: (AnnouncementData) -> Unit):
    RecyclerView.Adapter<AnnouncementListAdapterActivity.Holder>() {
    var announcement: ArrayList<AnnouncementData> = arrayListOf()
    var firestore : FirebaseFirestore? = FirebaseFirestore.getInstance()

    init {
        firestore?.collection("announcement")
            ?.addSnapshotListener { querySnapshot, firebaseFireStore ->

                // ArrayList 비워줌
                announcement.clear()


                for (snapshot in querySnapshot!!.documents) {
                    var item = snapshot.toObject(AnnouncementData::class.java)
                    announcement.add(item!!)
                }
                notifyDataSetChanged()   //새로고침되도록
            }
        //
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): Holder {

        val view = LayoutInflater.from(context).inflate(R.layout.activity_frameofannouncementlist, parent, false)
        return Holder(view,itemClick)
    }

    override fun getItemCount(): Int {
        return announcement.size
    }

    override fun onBindViewHolder(holder: Holder, position: Int) {
        //holder?.bind(announcementList[position], context)
        var viewHolder = holder.itemView

        holder?.itemView.setOnClickListener{
            itemClick(announcement[position])
        }
    }

    inner class Holder(itemView: View,itemClick: (AnnouncementData) -> Unit) :
        RecyclerView.ViewHolder(itemView) {
        val Month = itemView?.findViewById<TextView>(R.id.frame_textView2)
        val Category = itemView?.findViewById<TextView>(R.id.frame_textView6)
        val Title = itemView?.findViewById<TextView>(R.id.frame_textView3)
        //val EssentialRead = itemView?.findViewById<TextView>(R.id.frame_textView5)

        fun bind(Announce: AnnouncementData, context: Context) {
            Month?.text = Announce.month
            Title?.text = Announce.date
            Category?.text = Announce.category
            //EssentialRead?.text= Announce.EssentialRead

            //itemview를 클릭하면 itemClick(수행)
            itemView.setOnClickListener { itemClick(AnnouncementData()) }

        }
    }


}
