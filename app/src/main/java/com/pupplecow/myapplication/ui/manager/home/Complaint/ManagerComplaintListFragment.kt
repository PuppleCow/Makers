package com.pupplecow.myapplication.ui.manager.home.Complaint

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import com.pupplecow.myapplication.R
import com.pupplecow.myapplication.temporaryStorage.ManagerComplaintFragment
import com.pupplecow.myapplication.ui.home.complaint.ComplaintListActivity
import kotlinx.android.synthetic.main.fragment_manager_complaint_list.*

class ManagerComplaintListFragment:Fragment() {
    private lateinit var managerComplaintFragment: ManagerComplaintFragment
    var managerComplaintList= arrayListOf<ManagerComplaintList>(
        //숫자,제목,항목,사진
        ManagerComplaintList("05","23","불편사항 신고",""),
        ManagerComplaintList("05","23","불편사항 신고",""),


    )
    companion object {
        fun newInstance(): ManagerComplaintListFragment {
            return ManagerComplaintListFragment()
        }
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)


        val mAdapter = ManagerComplaintListAdapter(requireContext(), managerComplaintList){
            complaint->
            //해당 민원 내용프래그먼트로 넘어가기
            //넘어갈때 해당 내용 서버에서 불러오기
            //MyConplaintActivity로 넘어가기
            val intent = Intent(requireContext(), ManagerComplaintActivity::class.java)
            startActivity(intent)
        }
        manager_complaint_recyclerview.adapter = mAdapter

        val lm = LinearLayoutManager(requireContext())
        manager_complaint_recyclerview.layoutManager = lm
        manager_complaint_recyclerview.setHasFixedSize(true)

    }


    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState:Bundle?): View?{
        val view=inflater.inflate(R.layout.fragment_manager_complaint_list,container,false)
        return view
    }
}