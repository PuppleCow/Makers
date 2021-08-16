package com.pupplecow.myapplication.ui.home

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.pupplecow.myapplication.R
import kotlinx.android.synthetic.main.activity_confirm_waiting.*

class ConfirmWaitingActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_confirm_waiting)


        //승인요청

        //승인확인후 다음페이지로 이동
        //임시(화면 누르면 넘어가게
        confrim_waiting_.setOnClickListener{
            finish()
        }



    }
}