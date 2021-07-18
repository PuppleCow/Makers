package com.pupplecow.myapplication

import android.content.DialogInterface
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.appcompat.app.AlertDialog
import kotlinx.android.synthetic.main.activity_complaint.*
import kotlinx.android.synthetic.main.activity_create_announcement.*
import java.util.*

class CreateAnnouncementActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_create_announcement)

        //등록하기버튼
        create_announcement_button_enroll.setOnClickListener {
            //제목란 비어있는지 확인
            if (create_announcement_editText_title.text.toString() == "") {
                //비어있으면 작성해주세요 다이얼로그
                val builder = AlertDialog.Builder(this)
                builder.setTitle("공지사항")
                builder.setMessage("제목을 작성해주세요")
                builder.setPositiveButton("네", null)
                builder.show()
            } else {
                //textarea비어있는지 확인

                if (create_announcement_editTextTextMultiLine.text.toString() == "") {
                    //비어있으면 작성해주세요 다이얼로그
                    val builder = AlertDialog.Builder(this)
                    builder.setTitle("공지사항")
                    builder.setMessage("공지사항을 작성해주세요")
                    builder.setPositiveButton("네", null)
                    builder.show()
                } else {
                    //공지사항작성 다이얼로그
                    val builder = AlertDialog.Builder(this)
                    builder.setTitle("공지사항")
                    builder.setMessage("공지사항을 등록하시겠습니까?")
                    var listener = object : DialogInterface.OnClickListener {
                        override fun onClick(p0: DialogInterface?, p1: Int) {
                            when (p1) {
                                //"네" 눌렀을때
                                DialogInterface.BUTTON_POSITIVE -> {

                                    //공지시간 표시
                                    val homeNow = Calendar.getInstance()
                                    val year = homeNow.get(Calendar.YEAR).toString()
                                    val month = homeNow.get(Calendar.MONTH).toString()
                                    val date = homeNow.get(Calendar.DATE).toString()
                                    val hour = homeNow.get(Calendar.HOUR).toString()
                                    val minute = homeNow.get(Calendar.MINUTE).toString()


                                    //서버에 사진,공지 제목,공지내용,공지날짜,시간,공지한 사람 정보 저장


                                    //다음페이지로 넘어가기
                                    //MyConplaintActivity로 넘어가기
                                    val intent = Intent(
                                        this@CreateAnnouncementActivity,
                                        AnnouncementActivity::class.java
                                    )
                                    startActivity(intent)

                                }

                            }
                        }
                    }
                    builder.setNegativeButton("아니오", listener)
                    builder.setPositiveButton("네", listener)
                    builder.show()
                }
            }
        }





    }
}