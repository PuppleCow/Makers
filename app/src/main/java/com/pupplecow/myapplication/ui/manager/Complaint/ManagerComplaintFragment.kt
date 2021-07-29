package com.pupplecow.myapplication.ui.manager.Complaint

import android.content.DialogInterface
import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.app.AlertDialog
import androidx.fragment.app.Fragment
import com.pupplecow.myapplication.R
import com.pupplecow.myapplication.ui.complaint.ComplaintFragment
import com.pupplecow.myapplication.ui.complaint.MyComplaintListFragment
import kotlinx.android.synthetic.main.fragment_manager_complaint.*
import kotlinx.android.synthetic.main.fragment_my_complaint.*
import kotlinx.android.synthetic.main.fragment_my_complaint.MyComplaint_button_list

class ManagerComplaintFragment:Fragment() {
    private lateinit var managerComplaintListFragment: ManagerComplaintListFragment
    companion object {
        fun newInstance(): ManagerComplaintFragment {
            return ManagerComplaintFragment()
        }
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        //서버에서 내용받아오기
        MyComplaint_text_title.text="민원제목입니다."
        MyComplaint_text_content.text="민원내용입니다."



        //산업안전 뉴스 제목,링크 불러오기
        manager_MyComplaint_text_news.text="뉴스 제목입니다."

        manager_MyComplaint_text_news.setOnClickListener {
            var intent =
                Intent(Intent.ACTION_VIEW, Uri.parse("https://www.news1.kr/articles/?4386702"))
            startActivity(intent)
        }

        //목록버튼
        manager_MyComplaint_button_list.setOnClickListener {
            //목록페이지로 넘어가기
            managerComplaintListFragment = ManagerComplaintListFragment.newInstance()
            val transaction=activity?.supportFragmentManager?.beginTransaction()?.replace(R.id.main_nav_frame,managerComplaintListFragment)?.addToBackStack(null)?.commit()
        }


    }


    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState:Bundle?): View?{
        val view=inflater.inflate(R.layout.fragment_manager_complaint,container,false)
        return view
    }

}