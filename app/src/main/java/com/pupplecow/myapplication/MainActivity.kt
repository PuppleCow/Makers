package com.pupplecow.myapplication


import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.pupplecow.myapplication.ui.announcement.AnnounceMentListActivity
import com.pupplecow.myapplication.ui.home.ComplaintActivity
import com.pupplecow.myapplication.temporaryStorage.HomeActivity1
import com.pupplecow.myapplication.ui.login.LoginActivity
import com.pupplecow.myapplication.ui.login.ResettingPassword1
import com.pupplecow.myapplication.ui.manager.ManagerNavActivity
import kotlinx.android.synthetic.main.activity_main.*


class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        //로그인
        button.setOnClickListener {
            val intent = Intent(this, LoginActivity::class.java)
            startActivity(intent)
        }

        //메인 네비바
        button7.setOnClickListener {
            val intent = Intent(this, MainNavActivity::class.java)
            startActivity(intent)
        }


        //관리자 네비바
        button8.setOnClickListener{
            val intent=Intent(this, ManagerNavActivity::class.java)
            startActivity(intent)
        }



    }




}