package com.pupplecow.myapplication

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



    }
}