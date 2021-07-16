package com.pupplecow.myapplication

import android.content.Intent
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ArrayAdapter
import kotlinx.android.synthetic.main.activity_complaint.*
import kotlinx.android.synthetic.main.activity_home1.*

class ComplaintActivity : AppCompatActivity() {

    //민원항목
    //val complaintCategoryData= arrayOf("불편사항 접수","불법행위 신고","시설물 파손 신고/수리요청","환경오염 행위 신고","기타")

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_complaint)

        //민원항목 선택 스피너

        //val complaintAdapter = ArrayAdapter(this,android.R.layout.simple_spinner_item,complaintCategoryData)
        //complaintAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
        //home_spinner_workspace.adapter= complaintAdapter


        //사진첨부버튼
        complaint_button_photo.setOnClickListener {

        }

        //등록하기버튼
        complaint_button_enroll.setOnClickListener {
            //민원접수 다이얼로그

            //서버에 사진,민원항목,민원내용저장




        }

        //전화걸기 버튼
        complaint_button_phonecall.setOnClickListener {
            //var intent = Intent(Intent.ACTION_DIAL)
            //intent.data = Uri.parse("tel:01012345678")
            //if(intent.resolveActivity(packageManager) != null){
            //    startActivity(intent)
            //}
        }

        //나의 민원 보기 버튼
        complaint_button_mycomplaint.setOnClickListener {


        }


    }
}