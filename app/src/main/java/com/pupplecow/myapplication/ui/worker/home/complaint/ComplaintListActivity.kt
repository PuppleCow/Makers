package com.pupplecow.myapplication.ui.worker.home.complaint

import android.content.Intent
import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import com.google.firebase.firestore.FirebaseFirestore
import com.google.firebase.firestore.ktx.firestore
import com.google.firebase.ktx.Firebase
import com.pupplecow.myapplication.R
import com.pupplecow.myapplication.databinding.ActivityComplaintListBinding
import com.pupplecow.myapplication.Adapter.ComplaintListAdapter
import com.pupplecow.myapplication.data.Complaint
import com.pupplecow.myapplication.view.LinearLayoutManagerWrapper


class ComplaintListActivity : AppCompatActivity() {
    private lateinit var binding:ActivityComplaintListBinding

    private val db=Firebase.firestore
    private val complaintList:ArrayList<Complaint> = ArrayList()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_complaint_list)
        binding= ActivityComplaintListBinding.inflate(layoutInflater)
        setContentView(binding.root)



//        val mAdapter = ManagerComplaintListAdapter(this, complaintList){
        val mAdapter = ComplaintListAdapter(this) {
                complaint->

            //도큐먼트 아이디 추출
            //val documentID="null"


            //해당 민원 내용프래그먼트로 넘어가기
            //넘어갈때 도큐먼트 아이디 넘기기
            val intent = Intent(this, ComplaintActivity::class.java)
            intent.putExtra("DocumentID",complaint.key)
            startActivity(intent)
        }
        binding.complaintListRecyclerview.adapter = mAdapter


        val lm = LinearLayoutManagerWrapper(this,LinearLayoutManager.VERTICAL,false)
        binding.complaintListRecyclerview.layoutManager = lm
        binding.complaintListRecyclerview.setHasFixedSize(true)


    }

    override fun onResume() {
        super.onResume()
        loadData()
    }

    private fun loadData() {
        db.collection("COMPLAINT")
            //.whereEqualTo("writerName", "최지혜")  //조건 추가 가능
            .get()
            .addOnSuccessListener { documents ->
                complaintList.clear()
                for (document in documents) {
                    Log.e("COMPLAINT", "${document.id} => ${document.data}")
                    val data=document.toObject(Complaint::class.java)
                    data.key=document.id
                    complaintList.add(data)
                }
                (binding.complaintListRecyclerview.adapter as ComplaintListAdapter).setDatas(complaintList)
            }
            .addOnFailureListener { exception ->
                Log.w("", "Error getting documents: ", exception)
            }
    }

}

//        fbFirestore?.collection("complaint")?.addSnapshotListener{querySnapshot,firebaseFirestoreException ->
//            // ArrayList 비워줌
//            complaintList.clear()
//
//            for (snapshot in querySnapshot!!.documents) {
//                var item = snapshot.toObject(ComplaintData::class.java)
//                complaintList.apply {
//                    add(ManagerComplaint(
//                        month = item?.month.toString(),
//                        date = item?.date.toString(),
//                        title = item?.title.toString(),
//                        category = item?.category.toString(),
//                        uid = item?.uid.toString(),
//                        contents = item?.contents.toString()
//                    ))
//
//
//                    //ManagerComplaintList.complaintList=complaintList
//                }
//            }//mAdapter.notifyDataSetChanged()
//
//        }//notifyDataSetChanged()

        
//        database.addValueEventListener(object : ValueEventListener{
//            override fun onCancelled(error: DatabaseError) {
//
//            }
//
//            override fun onDataChange(snapshot: DataSnapshot) {
//                for(data in snapshot.children){
//                    val modelResult=data.getValue(ComplaintData::class.java)
//                    complaintList.apply {
//                        add(ManagerComplaint(
//                            month = modelResult?.month.toString(),
//                            date = modelResult?.date.toString(),
//                            title = modelResult?.title.toString(),
//                            category = modelResult?.category.toString(),
//                            uid = modelResult?.uid.toString(),
//                            contents = modelResult?.contents.toString()
//                        ))
//                            //ManagerComplaintList.complaintList=complaintList
//                    }
//                }
//                mAdapter.notifyDataSetChanged()
//
//            }
//        })


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

