package com.pupplecow.myapplication.ui.manager.home.Complaint

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.google.firebase.firestore.FirebaseFirestore
import com.pupplecow.myapplication.R
import com.pupplecow.myapplication.ui.home.complaint.ComplaintData
import kotlinx.android.synthetic.main.manager_complaint_list_item.view.*


//class ManagerComplaintListAdapter(val context: Context,val complaint:ArrayList<ManagerComplaint>, val itemClick: (ManagerComplaint) -> Unit):
class ManagerComplaintListAdapter(val context: Context, val itemClick: (ComplaintData) -> Unit):
    RecyclerView.Adapter<ManagerComplaintListAdapter.Holder>() {
    var firestore:FirebaseFirestore?= FirebaseFirestore.getInstance()

    var complaintList:ArrayList<ComplaintData> = arrayListOf(    )

    init{
        firestore?.collection("complaint")?.addSnapshotListener{querySnapshot,firebaseFirestoreException ->
        // ArrayList 비워줌
            complaintList.clear()

        for (snapshot in querySnapshot!!.documents) {
            var item = snapshot.toObject(ComplaintData::class.java)
            complaintList.add(item!!)
        }
        notifyDataSetChanged()
    }

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): Holder {
        val view = LayoutInflater.from(context).inflate(R.layout.manager_complaint_list_item, parent, false)
        return Holder(view, itemClick)
    }

    override fun getItemCount(): Int {
        return complaintList.size
    }

    override fun onBindViewHolder(holder: Holder, position: Int) {
//        holder?.bind(complaintList[position], context)
        var viewHolder= holder.itemView

        viewHolder.manager_complaint_list_title.text="["+complaintList[position].category+"]"+complaintList[position]. title
        viewHolder.manager_complaint_list_number.text=complaintList[position].month+"/"+complaintList[position].date

        holder?.itemView.setOnClickListener {
            itemClick(complaintList[position])
        }
    }

    inner class Holder(itemView: View, itemClick: (ComplaintData) -> Unit) : RecyclerView.ViewHolder(itemView) {

        //val complaintPhoto = itemView?.findViewById<ImageView>(R.id.manager_complaint_list_imageview)
        val complaintNum = itemView?.findViewById<TextView>(R.id.manager_complaint_list_number)
        val complaintTitle = itemView?.findViewById<TextView>(R.id.manager_complaint_list_title)
        //val complaintCategory = itemView?.findViewById<TextView>(R.id.manager_complaint_list_category)

        fun bind(complaint: ComplaintData, context: Context) {

            itemView.setOnClickListener { itemClick(complaint) }
            /* (3) itemView가 클릭됐을 때 처리할 일을 itemClick으로 설정한다.
             (Dog) -> Unit 에 대한 함수는 나중에 MainActivity.kt 클래스에서 작성한다. */

        }
    }
}