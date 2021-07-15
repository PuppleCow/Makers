package com.pupplecow.myapplication

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ArrayAdapter
import kotlinx.android.synthetic.main.activity_home1.*
import java.time.LocalDate
import java.util.*

class HomeActivity1 : AppCompatActivity() {

    val workspaceData =arrayOf("인천항만","인천항만","인천항만","인천항만","기타")
    val worksData =arrayOf("하역","하역","하역","하역","기타")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home1)


        //어댑터를 생성한다. 접혔을 때의 모습을 구성할 Layout을 설정한다.
        val workspaceAdapter = ArrayAdapter(this,android.R.layout.simple_spinner_item,workspaceData)
        //펼쳐졌을 때의 모습을 구성하기 위한 Layout을 지정한다
        workspaceAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)

        home_spinner_workspace.adapter= workspaceAdapter

        //어댑터를 생성한다. 접혔을 때의 모습을 구성할 Layout을 설정한다.
        val workAdapter = ArrayAdapter(this,android.R.layout.simple_spinner_item,worksData)
        //펼쳐졌을 때의 모습을 구성하기 위한 Layout을 지정한다
        workAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)

        home_spinner_work.adapter= workAdapter


        //오늘날짜 표시
        val homeNow=Calendar.getInstance()
        val year=homeNow.get(Calendar.YEAR).toString()
        val month=(homeNow.get(Calendar.MONTH)+1).toString()
        val day=homeNow.get(Calendar.DATE).toString()

        home_text_date.text="안녕하세요\n오늘은 "+year+"년 "+month+"월 "+day+"일입니다."

        //근무시작버튼 활성화,근무종료버튼 비활성화





        //근무시작버튼
        home_button_start.setOnClickListener {
            //근무시작시간,작업장,작업 서버에 저장
            home_text_start.text=System.currentTimeMillis().toString()
            //근무시작시간 표시


            //근무장소 표시
            home_text_start.text="시작\n"+home_spinner_workspace.selectedItemPosition

            //근무종료버튼 활성화

        }


        //근무종료버튼
       home_button_finish.setOnClickListener {
            //근무시작버튼 활성화

            //근무종료시간 저장
           home_text_finish.text=System.currentTimeMillis().toString()

           //근무종료시간 저장
        }






    }
}