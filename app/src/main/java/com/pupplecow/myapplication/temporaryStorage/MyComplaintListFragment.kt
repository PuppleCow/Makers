package com.pupplecow.myapplication.temporaryStorage

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import com.pupplecow.myapplication.R
import com.pupplecow.myapplication.ui.manager.home.Complaint.ManagerComplaintList
import com.pupplecow.myapplication.ui.manager.home.Complaint.ManagerComplaintListAdapter
import kotlinx.android.synthetic.main.activity_my_complaint_list.*

class MyComplaintListFragment:Fragment() {
    private lateinit var myComplaintFragment: MyComplaintFragment
    private lateinit var complaintFragment: ComplaintFragment
    var complaintList= arrayListOf<ManagerComplaintList>(
        //숫자,제목,항목,사진
        ManagerComplaintList("1", "title1", "불편사항 신고", ""),
        ManagerComplaintList("2", "title2", "불편사항 신고", ""),
        ManagerComplaintList("3", "title3", "불편사항 신고", ""),
        ManagerComplaintList("4", "title4", "불편사항 신고", ""),
        ManagerComplaintList("5", "title5", "불편사항 신고", ""),

        )

    companion object {
        fun newInstance(): MyComplaintListFragment {
            return MyComplaintListFragment()
        }
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val mAdapter = ManagerComplaintListAdapter(requireContext(), complaintList){
                complaint->
            //해당 민원 내용프래그먼트로 넘어가기
            //넘어갈때 해당 내용 서버에서 불러오기
            myComplaintFragment= MyComplaintFragment.newInstance()
            val transaction=activity?.supportFragmentManager?.beginTransaction()?.replace(R.id.main_nav_frame,myComplaintFragment)?.addToBackStack(null)?.commit()

        }
        mycomplaint_list_recyclerview.adapter = mAdapter

        val lm = LinearLayoutManager(requireContext())
        mycomplaint_list_recyclerview.layoutManager = lm
        mycomplaint_list_recyclerview.setHasFixedSize(true)


    }





    override fun onCreateView(inflater: LayoutInflater,container:ViewGroup?,savedInstanceState:Bundle?): View?{
        val view=inflater.inflate(R.layout.activity_my_complaint_list,container,false)
        return view
    }



}


