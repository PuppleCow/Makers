package com.pupplecow.myapplication

import android.app.Activity
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        button1.setOnClickListener {

            //RegisterActivity로 넘어가기
            val intent = Intent(this, RegisterActicity1::class.java)
            startActivity(intent)
        }
        
        
        button2.setOnClickListener {
            // 안전 메뉴얼 퀴즈
            val intent = Intent(this, QuizActivity1::class.java)
            startActivity(intent)
        }


        button3.setOnClickListener {
            //HomeActivity(작업장)로 넘어가기
            val intent = Intent(this, HomeActivity1::class.java)
            startActivity(intent)
        }


        button4.setOnClickListener {
            //LoginActivity로 넘어가기
            val intent = Intent(this, LoginActivity::class.java)
            startActivity(intent)
        }


        button5.setOnClickListener {
            //CheckInActivity로 넘어가기
            val intent = Intent(this, CheckInActivity::class.java)
            startActivity(intent)
        }

        button6.setOnClickListener {
            //ConplaintActivity로 넘어가기
            val intent = Intent(this, ComplaintActivity::class.java)
            startActivity(intent)
        }

        button7.setOnClickListener {
            val intent = Intent(this, EmergencyNoticeActivity::class.java)
            startActivity(intent)
        }

        button8.setOnClickListener {
            val intent = Intent(this, CreateAnnouncementActivity::class.java)
            startActivity(intent)
        }



        button9.setOnClickListener {
            //ManageActivity 로 넘어가기
            val intent = Intent(this, ManageActivity::class.java)
            startActivity(intent)
        }

        button10.setOnClickListener {
            //ManageActivity 로 넘어가기
            val intent = Intent(this, Activity::class.java)
            startActivity(intent)
        }

        button11.setOnClickListener {
            //ManageActivity 로 넘어가기
            val intent = Intent(this, Activity::class.java)
            startActivity(intent)
        }

        button12.setOnClickListener {
            //ManageActivity 로 넘어가기
            val intent = Intent(this, Activity::class.java)
            startActivity(intent)
        }

        button13.setOnClickListener {
            //ManageActivity 로 넘어가기
            val intent = Intent(this, Activity::class.java)
            startActivity(intent)
        }

        button14.setOnClickListener {
            //ManageActivity 로 넘어가기
            val intent = Intent(this, Activity::class.java)
            startActivity(intent)
        }

        button15.setOnClickListener {
            //ManageActivity 로 넘어가기
            val intent = Intent(this, Activity::class.java)
            startActivity(intent)
        }

        button16.setOnClickListener {
            //ManageActivity 로 넘어가기
            val intent = Intent(this, Activity::class.java)
            startActivity(intent)
        }
        button17.setOnClickListener {
            //ManageActivity 로 넘어가기
            val intent = Intent(this, Activity::class.java)
            startActivity(intent)
        }


    }
}