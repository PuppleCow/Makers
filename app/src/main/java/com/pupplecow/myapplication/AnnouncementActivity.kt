package com.pupplecow.myapplication

import android.app.Activity
import android.content.DialogInterface
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.appcompat.app.AlertDialog
import kotlinx.android.synthetic.main.activity_announcement.*
import kotlinx.android.synthetic.main.activity_complaint.*
import java.util.*

class AnnouncementActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_announcement)

        //제목,공지날짜 서버에서 가져오기
        announcement_text_title.text="5/10 공지입니다."

        //필독 체크 유무 서버에서 가져오기
        if(true) {
            announcement_text_must_read.text = "필독!!"
        }
        else{
            announcement_text_must_read.text = ""
        }
        //공지내용 서버에서 가져오기
        announcement_text_content.text="공지\n공지입니당\n공쥐\n팥쥐"


        //수정버튼 누르면
        announcement_button_edit.setOnClickListener {
            //다이얼로그
            val builder= AlertDialog.Builder(this)
            builder.setTitle("")
            builder.setMessage("해당 공지를 수정하시겠습니까?")
            var listener = object : DialogInterface.OnClickListener {
                override fun onClick(p0: DialogInterface?, p1: Int) {
                    when (p1) {
                        //"네" 눌렀을때
                        DialogInterface.BUTTON_POSITIVE -> {
                            //예누르면 공지사항 작성페이지로 이동 --> 수정공지사항은 입력되어있어야함
                            //Activity로 넘어가기
                            val intent = Intent(this@AnnouncementActivity, CreateAnnouncementActivity::class.java)
                            startActivity(intent)

                        }

                    }
                }
            }
            builder.setNegativeButton("아니오",listener)
            builder.setPositiveButton("네",listener)
            builder.show()

        }




        //삭제버튼 누르면
        announcement_button_delete.setOnClickListener {
            //다이얼로그
                val builder= AlertDialog.Builder(this)
                builder.setTitle("")
                builder.setMessage("해당 공지를 삭제하시겠습니까?")
                var listener = object : DialogInterface.OnClickListener {
                    override fun onClick(p0: DialogInterface?, p1: Int) {
                        when (p1) {
                            //"네" 눌렀을때
                            DialogInterface.BUTTON_POSITIVE -> {

                                //해당 공지 서버에서 삭제하기


                                //공지사항 목록 페이지로 넘어가기
                                //AnnounceMentListActivity로 넘어가기
                                val intent = Intent(this@AnnouncementActivity, AnnounceMentListActivity::class.java)
                                startActivity(intent)

                            }

                        }
                    }
                }
                builder.setNegativeButton("아니오",listener)
                builder.setPositiveButton("네",listener)
                builder.show()
            }



        //목록버튼 누르면
        announcement_button_list.setOnClickListener {
            //공지사항 목록 페이지로 넘어가기
            //AnnounceMentListActivity로 넘어가기
            val intent = Intent(this@AnnouncementActivity, AnnounceMentListActivity::class.java)
            startActivity(intent)


        }






    }
}