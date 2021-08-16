package com.pupplecow.myapplication.temporaryStorage

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.pupplecow.myapplication.R
import kotlinx.android.synthetic.main.fragment_manager_worker_info.*

class ManagerWorkerInfoFragment:Fragment() {

    companion object {
        fun newInstance(): ManagerWorkerInfoFragment {
            return ManagerWorkerInfoFragment()
        }
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)


        //서버에서 이름,작업시작,종료시간,전화번호 보호자연락처,혈액형,특이사항 받아오기
        val name:String="홍길동"
        val startT:String="09:00"
        val finishT:String="18:00"
        val phoneNum:String="01027562874"
        val emergencyNum:String="01012345678"
        val NOK:String="부"
        val bloodType:String="AB"
        val specialNote:String="당뇨,고혈압"


        manager_workerinfo_text_title.text="${name}님의 정보"
        manager_workerinfo_text_name.text="이름 : ${name}"
        manager_workerinfo_text_startT.text="오늘 작업 시작시간 : ${startT}"
        manager_workerinfo_text_finishT.text="오늘 작업 종료시간 : ${finishT}"
        manager_workerinfo_text_phoneNum.text="전화번호 : ${phoneNum}"
        manager_workerinfo_text_emergency_contact.text="보호자 연락처 : ${emergencyNum}(${NOK})"
        manager_workerinfo_text_blood_type.text="혈액형 : ${bloodType}(형)"
        manager_workerinfo_text_special_note.text="특이사항 : ${specialNote}"

        manager_workerinfo_button_emergency_call.setOnClickListener {
            var intent = Intent(Intent.ACTION_DIAL)
            intent.data = Uri.parse("tel:${emergencyNum}")
            startActivity(intent)

        }

        manager_workerinfo_text_text_news.text="뉴스 제목입니다."
        manager_workerinfo_text_text_news.setOnClickListener {
             var intent =
             Intent(Intent.ACTION_VIEW, Uri.parse("https://www.news1.kr/articles/?4386702"))
             startActivity(intent)
        }


    }


    override fun onCreateView(inflater: LayoutInflater,container:ViewGroup?,savedInstanceState:Bundle?): View?{
        val view=inflater.inflate(R.layout.fragment_manager_worker_info,container,false)
        return view
    }



}