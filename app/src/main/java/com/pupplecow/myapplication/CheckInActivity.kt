package com.pupplecow.myapplication

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_check_in.*

class CheckInActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_check_in)


        //완료 버튼 클릭 시 정보 전송
        //어디 페이지로 이동? -> 안전매뉴얼퀴즈로 이동(QuizActivity2)
        check_in_button2.setOnClickListener {
            //완료 버튼 클릭 시 정보 전송
            //어디 페이지로 이동? -> 안전매뉴얼퀴즈로 이동(QuizActivity2)


            val intent = Intent(this@CheckInActivity,QuizActivity2::class.java)
            startActivity(intent)
        }

    }




}