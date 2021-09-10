package com.pupplecow.myapplication.ui.manager.home

import android.content.Intent
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.pupplecow.myapplication.R
import kotlinx.android.synthetic.main.activity_manager_worker_info.*


class ManagerWorkerInfoActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_manager_worker_info)

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
        manager_workerinfo_text_name.text="${name}"
        manager_workerinfo_text_startT.text="${startT}"
        manager_workerinfo_text_finishT.text="${finishT}"
        manager_workerinfo_text_phoneNum.text="${phoneNum}"
        manager_workerinfo_text_emergency_contact.text=" ${emergencyNum}(${NOK})"
        manager_workerinfo_text_blood_type.text="${bloodType}(형)"
        manager_workerinfo_text_special_note.text=" ${specialNote}"

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
}