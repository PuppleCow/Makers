package com.pupplecow.myapplication

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ArrayAdapter
import androidx.appcompat.app.AlertDialog
import kotlinx.android.synthetic.main.activity_complaint.*
import kotlinx.android.synthetic.main.activity_workers_status.*

class WorkersStatusActivity : AppCompatActivity() {
    //민원항목
    val GroupData= arrayOf("근무자그룹선택","모든 작업자","A","B","기타")

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_workers_status)

        //민원항목 선택 스피너

        val WorkerGroupAdapter = ArrayAdapter(this,android.R.layout.simple_spinner_item,GroupData)
        WorkerGroupAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
        workers_status_spinner_workers_group.adapter= WorkerGroupAdapter

        //근무자 그룹선택후 조회하기 버튼 클릭
        workers_status_spinner_button_check.setOnClickListener {
            val workersGruop =
                GroupData[workers_status_spinner_workers_group.selectedItemPosition]


            if(workersGruop=="근무자그룹선택"){
                val builder= AlertDialog.Builder(this)
                builder.setTitle("")
                builder.setMessage("근무자 그룹을 선택해주세요")
                builder.setPositiveButton("네",null)
                builder.show()
            }
            else{
                workers_status_text_member.text=workersGruop+"의 근무인원"

                //해당 팀에서 일하는 근무인원정보 받아와서 표시
                workers_status_text_member_number.text="명이 근무중입니다."

                //리스트뷰 만들어서 표시

                //해당 팀에서 일하는 근무인원 이름 전화번호 시작시간 종료시간 관리자여부 서버에서 받아오기








            }

        }


    }
}