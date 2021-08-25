
package com.pupplecow.myapplication.ui.manager.announcement

import android.app.Person
import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.google.firebase.firestore.FirebaseFirestore
import com.pupplecow.myapplication.R
import com.pupplecow.myapplication.ui.manager.announcement.AnnouncementData
import kotlinx.android.synthetic.main.activity_frameofannouncementlist.view.*
import kotlinx.android.synthetic.main.manager_complaint_list_item.view.*
import kotlinx.android.synthetic.main.manager_complaint_list_item.view.manager_complaint_list_title

class ManagerAnnouncementListAdapter (val context: Context,val itemClick: (AnnouncementData) -> Unit):
    RecyclerView.Adapter<ManagerAnnouncementListAdapter.Holder>() {
    var announcement: ArrayList<AnnouncementData> = arrayListOf(

    )
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
        return Holder(view, itemClick)
    }

    override fun getItemCount(): Int {
        return announcement.size
    }


    override fun onBindViewHolder(holder: Holder, position: Int) {
        //holder?.bind(announcement[position], context)
        var viewHolder = holder.itemView

        viewHolder.frame_textView2.text=announcement[position].month
        viewHolder.frame_textView6.text=announcement[position].date
        viewHolder.frame_textView3.text=announcement[position].title

        holder?.itemView.setOnClickListener{
            itemClick(announcement[position])
        }


    }

    //데이터 가져옴
    inner class Holder(itemView: View, itemClick: (AnnouncementData) -> Unit) :
        RecyclerView.ViewHolder(itemView) {
        //파이어베이스

        val Month = itemView?.findViewById<TextView>(R.id.frame_textView2)
        val Category = itemView?.findViewById<TextView>(R.id.frame_textView6)
        val Title = itemView?.findViewById<TextView>(R.id.frame_textView3)
        //val EssentialRead = itemView?.findViewById<TextView>(R.id.frame_textView5)

        fun bind(Announce: AnnouncementData, context: Context) {
//            Month?.text = Announce.month
//            Title?.text = Announce.date
//            Category?.text = Announce.category
            //EssentialRead?.text= Announce.EssentialRead

            //itemview를 클릭하면 itemClick(수행)
            itemView.setOnClickListener { itemClick(AnnouncementData()) }

        }

    }


}
