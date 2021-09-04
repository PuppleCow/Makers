package com.pupplecow.myapplication.ui.manager.home.Complaint

import android.content.Intent
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.pupplecow.myapplication.R
import kotlinx.android.synthetic.main.fragment_manager_complaint.*

class ManagerComplaintActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_manager_complaint)

        //서버에서 제목,내용,날짜받아오기
        manager_MyComplaint_text_title.text="민원제목입니다."
        manager_MyComplaint_text_content.text="민원내용입니다."



//        //산업안전 뉴스 제목,링크 불러오기
//        manager_MyComplaint_text_news.text="뉴스 제목입니다."
//
//        manager_MyComplaint_text_news.setOnClickListener {
//            var intent =
//                Intent(Intent.ACTION_VIEW, Uri.parse("https://www.news1.kr/articles/?4386702"))
//            startActivity(intent)
//        }

        //목록버튼
        manager_MyComplaint_button_list.setOnClickListener {
            //목록페이지로 넘어가기
            finish()
        }

    }
}