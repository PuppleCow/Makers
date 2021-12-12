package com.pupplecow.myapplication.ui.worker.home

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import com.pupplecow.myapplication.R
import com.pupplecow.myapplication.databinding.ActivityConfirmWaitingBinding
import com.pupplecow.myapplication.ui.login.ResettingPassword1
import kotlinx.android.synthetic.main.activity_confirm_waiting.*
import javax.xml.datatype.DatatypeConstants.DURATION

class ConfirmWaitingActivity : AppCompatActivity() {
    private lateinit var binding: ActivityConfirmWaitingBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_confirm_waiting)

        binding = ActivityConfirmWaitingBinding.inflate(layoutInflater)
        setContentView(binding.root)


        //승인요청
        //5초 후 화면 자동으로 넘어가게(아두이노)
        Handler().postDelayed({
            val intent = Intent(this, ConfirmWaitingActivity::class.java)
            intent.addFlags(Intent.FLAG_ACTIVITY_NO_ANIMATION)
            finish()
        }, DURATION)
    }
        companion object {
            private const val DURATION : Long=3000;
        }


    //승인확인후 다음페이지로 이동
    //임시(화면 누르면 넘어가게

//        binding.confrimWaiting.setOnClickListener{
//            finish()
//        }


    }




