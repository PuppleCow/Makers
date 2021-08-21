package com.pupplecow.myapplication.ui.home

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import com.pupplecow.myapplication.R
import com.pupplecow.myapplication.temporaryStorage.MyComplaintFragment
import com.pupplecow.myapplication.ui.manager.Complaint.ManagerComplaintList
import com.pupplecow.myapplication.ui.manager.Complaint.ManagerComplaintListAdapter
import kotlinx.android.synthetic.main.activity_complaint_list.*
import kotlinx.android.synthetic.main.activity_my_complaint_list.*

class ComplaintListActivity : AppCompatActivity() {

    var complaintList= arrayListOf<ManagerComplaintList>(
        //숫자,제목,항목,사진
        ManagerComplaintList("1", "title1", "불편사항 신고", ""),
        ManagerComplaintList("2", "title2", "불편사항 신고", ""),
        ManagerComplaintList("3", "title3", "불편사항 신고", ""),
        ManagerComplaintList("4", "title4", "불편사항 신고", ""),
        ManagerComplaintList("5", "title5", "불편사항 신고", ""),
        )

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_complaint_list)

        val mAdapter = ManagerComplaintListAdapter(this, complaintList){
                complaint->
            //해당 민원 내용프래그먼트로 넘어가기
            //넘어갈때 해당 내용 서버에서 불러오기
            val intent = Intent(this,MyComplaintActivity::class.java)
            startActivity(intent)
        }
        complaint_list_recyclerview.adapter = mAdapter

        val lm = LinearLayoutManager(this)
        complaint_list_recyclerview.layoutManager = lm
        complaint_list_recyclerview.setHasFixedSize(true)


    }
}