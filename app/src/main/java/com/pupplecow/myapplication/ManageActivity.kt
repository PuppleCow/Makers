package com.pupplecow.myapplication

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ArrayAdapter
import kotlinx.android.synthetic.main.activity_login.*
import kotlinx.android.synthetic.main.activity_manage.*

class ManageActivity : AppCompatActivity() {
    val Manage_SelectGroup = arrayOf("긴급알림 그룹 선택","모든 그룹","A","B","C","D","E")
    //직접 쓰기-> 따로 페이지 이동해야 함.
    val Manage_SelectNotif = arrayOf("긴급알림 종류 선택","모든 작업 일시 중단","공지사항 필독","직접 쓰기")


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_manage)

        //긴급알림 그룹 선택 스피너
        val SelectGroupAdapter = ArrayAdapter(this,android.R.layout.simple_spinner_item,Manage_SelectGroup)
        SelectGroupAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
        manage_SelectGroupSp.adapter= SelectGroupAdapter

        //긴급알림 종류 선택 스피너
        val SelectNotifAdapter = ArrayAdapter(this,android.R.layout.simple_spinner_item,Manage_SelectNotif)
        SelectGroupAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
        manage_SelectNotifSp.adapter= SelectGroupAdapter

    }
}