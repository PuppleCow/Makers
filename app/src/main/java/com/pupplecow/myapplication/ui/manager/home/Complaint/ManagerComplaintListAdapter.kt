package com.pupplecow.myapplication.ui.manager.home.Complaint

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.pupplecow.myapplication.R


class ManagerComplaintListAdapter(val context:Context, val complaintList:ArrayList<ManagerComplaintList>,val itemClick: (ManagerComplaintList) -> Unit):
    RecyclerView.Adapter<ManagerComplaintListAdapter.Holder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): Holder {
        val view = LayoutInflater.from(context).inflate(R.layout.manager_complaint_list_item, parent, false)
        return Holder(view, itemClick)
    }

    override fun getItemCount(): Int {
        return complaintList.size
    }

    override fun onBindViewHolder(holder: Holder, position: Int) {
        holder?.bind(complaintList[position], context)
    }

    inner class Holder(itemView: View,itemClick: (ManagerComplaintList) -> Unit) : RecyclerView.ViewHolder(itemView) {

        val complaintPhoto = itemView?.findViewById<ImageView>(R.id.manager_complaint_list_imageview)
        val complaintNum = itemView?.findViewById<TextView>(R.id.manager_complaint_list_number)
        val complaintTitle = itemView?.findViewById<TextView>(R.id.manager_complaint_list_title)
        val complaintCategory = itemView?.findViewById<TextView>(R.id.manager_complaint_list_category)



        fun bind(complaint: ManagerComplaintList, context: Context) {
            /* dogPhoto의 setImageResource에 들어갈 이미지의 id를 파일명(String)으로 찾고,
          이미지가 없는 경우 안드로이드 기본 아이콘을 표시한다.*/
            if (complaint.photo != "") {
                val resourceId =
                    context.resources.getIdentifier(complaint.photo, "drawable", context.packageName)
                complaintPhoto?.setImageResource(resourceId)
            } else {
                complaintPhoto?.setImageResource(R.mipmap.ic_launcher)
            }

            complaintNum ?.text = complaint.number
            complaintTitle?.text = complaint.title
            complaintCategory?.text = complaint.category

            itemView.setOnClickListener { itemClick(complaint) }
            /* (3) itemView가 클릭됐을 때 처리할 일을 itemClick으로 설정한다.
             (Dog) -> Unit 에 대한 함수는 나중에 MainActivity.kt 클래스에서 작성한다. */

        }
    }
}