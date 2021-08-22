package com.pupplecow.myapplication.ui.home.complaint

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.database.*
import com.pupplecow.myapplication.R
import com.pupplecow.myapplication.ui.manager.home.Complaint.ManagerComplaintList
import com.pupplecow.myapplication.ui.manager.home.Complaint.ManagerComplaintListAdapter
import kotlinx.android.synthetic.main.activity_complaint_list.*


class ComplaintListActivity : AppCompatActivity() {

    private lateinit var database:DatabaseReference
    private lateinit var auth:FirebaseAuth

    var complaintList= arrayListOf<ManagerComplaintList>(
        //숫자,제목,항목,사진


//        ManagerComplaintList("1", "title1", "불편사항 신고", ""),
//        ManagerComplaintList("2", "title2", "불편사항 신고", ""),
//        ManagerComplaintList("3", "title3", "불편사항 신고", ""),
//        ManagerComplaintList("4", "title4", "불편사항 신고", ""),
//        ManagerComplaintList("5", "title5", "불편사항 신고", ""),
        )


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_complaint_list)

        auth = FirebaseAuth.getInstance()

        database=FirebaseDatabase.getInstance().getReference().child("board")


        val mAdapter = ManagerComplaintListAdapter(this, complaintList){
                complaint->
            //해당 민원 내용프래그먼트로 넘어가기
            //넘어갈때 해당 내용 서버에서 불러오기
            val intent = Intent(this, MyComplaintActivity::class.java)
            intent.putExtra("uid",auth.currentUser?.uid)
            startActivity(intent)
        }
        complaint_list_recyclerview.adapter = mAdapter

        val lm = LinearLayoutManager(this)
        complaint_list_recyclerview.layoutManager = lm
        complaint_list_recyclerview.setHasFixedSize(true)


        
        database.addValueEventListener(object : ValueEventListener{
            override fun onCancelled(error: DatabaseError) {
                TODO("Not yet implemented")
            }

            override fun onDataChange(snapshot: DataSnapshot) {
                for(data in snapshot.children){
                    val modelResult=data.getValue(ComplaintData::class.java)
                    complaintList.apply {
                        add(ManagerComplaintList(
                            month = modelResult?.month.toString(),
                            date = modelResult?.date.toString(),
                            title = modelResult?.title.toString(),
                            category = modelResult?.category.toString(),
                            uid = modelResult?.uid.toString(),
                            contents = modelResult?.contents.toString()
                        ))
                            //ManagerComplaintList.complaintList=complaintList
                    }
                }
                mAdapter.notifyDataSetChanged()

            }
        })

    }
}


//        database.addListenerForSingleValueEvent(object : ValueEventListener {
//            override fun onDataChange(dataSnapshot: DataSnapshot) {
//
//
//            }
//
//            override fun onCancelled(databaseError: DatabaseError) {}
//        })

//        database.limitToLast(20).addListenerForSingleValueEvent(object : ValueEventListener {
//            override fun onDataChange(dataSnapshot: DataSnapshot) {
//
//                val mAdapter = ManagerComplaintListAdapter(this@ComplaintListActivity, complaintList){
//                        complaint->
//                    //해당 민원 내용프래그먼트로 넘어가기
//                    //넘어갈때 해당 내용 서버에서 불러오기
//                    val intent = Intent(this@ComplaintListActivity, MyComplaintActivity::class.java)
//                    //intent.putExtra("uid",auth.currentUser?.uid)
//                    startActivity(intent)
//                }
//                complaint_list_recyclerview.adapter = mAdapter
//
//                val lm = LinearLayoutManager(this@ComplaintListActivity)
//                complaint_list_recyclerview.layoutManager = lm
//                complaint_list_recyclerview.setHasFixedSize(true)
//            }
//
//            override fun onCancelled(databaseError: DatabaseError) {}
//        })

