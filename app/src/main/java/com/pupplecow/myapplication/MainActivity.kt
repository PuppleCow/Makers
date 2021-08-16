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

        //작업장(홈)
        button2.setOnClickListener {
            val intent = Intent(this, HomeActivity1::class.java)
            startActivity(intent)
        }

        //민원접수
        button3.setOnClickListener {
            val intent = Intent(this, ComplaintActivity::class.java)
            startActivity(intent)
        }
        //공지사항
        button4.setOnClickListener {
            val intent = Intent(this, AnnounceMentListActivity::class.java)
            startActivity(intent)
        }
        //설정
        button5.setOnClickListener {
            val intent = Intent(this, SettingActivity::class.java)
            startActivity(intent)
        }
        //비밀번호 재설정
        button6.setOnClickListener {
            val intent = Intent(this, ResettingPassword1::class.java)
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