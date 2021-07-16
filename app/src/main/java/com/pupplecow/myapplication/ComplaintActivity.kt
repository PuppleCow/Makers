package com.pupplecow.myapplication

import android.content.DialogInterface
import android.content.Intent
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ArrayAdapter
import androidx.appcompat.app.AlertDialog
import kotlinx.android.synthetic.main.activity_complaint.*
import kotlinx.android.synthetic.main.activity_home1.*
import java.util.*

class ComplaintActivity : AppCompatActivity() {

    //민원항목
    val complaintCategoryData= arrayOf("불편사항 접수","불법행위 신고","시설물 파손 신고/수리요청","환경오염 행위 신고","기타")

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_complaint)

        //민원항목 선택 스피너

        val complaintAdapter = ArrayAdapter(this,android.R.layout.simple_spinner_item,complaintCategoryData)
        complaintAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
        complaint_spinner_category.adapter= complaintAdapter


        //사진첨부버튼
        complaint_button_photo.setOnClickListener {

        }

        //등록하기버튼
        complaint_button_enroll.setOnClickListener {
            //textarea비어있는지 확인
            if(complaint_editTextTextMultiLine.text.toString()=="") {
                //비어있으면 작성해주세요 다이얼로그
                val builder= AlertDialog.Builder(this)
                builder.setTitle("민원접수")
                builder.setMessage("민원내용을 작성해주세요")
                builder.setPositiveButton("네",null)
                builder.show()
            }
            else {
                //민원접수 다이얼로그
                val builder= AlertDialog.Builder(this)
                builder.setTitle("민원접수")
                builder.setMessage("민원내용을 접수하시겠습니까?")
                var listener = object : DialogInterface.OnClickListener {
                    override fun onClick(p0: DialogInterface?, p1: Int) {
                        when (p1) {
                            //"네" 눌렀을때
                            DialogInterface.BUTTON_POSITIVE -> {

                                //민원시간 표시
                                val homeNow = Calendar.getInstance()
                                val year = homeNow.get(Calendar.YEAR).toString()
                                val month = homeNow.get(Calendar.MONTH).toString()
                                val date = homeNow.get(Calendar.DATE).toString()
                                val hour = homeNow.get(Calendar.HOUR).toString()
                                val minute = homeNow.get(Calendar.MINUTE).toString()


                                //서버에 사진,민원항목,민원내용,민원날짜,시간저장

                                //민원항목
                                val complaintCategory =
                                    complaintCategoryData[complaint_spinner_category.selectedItemPosition]

                                //다음페이지로 넘어가기
                                //MyConplaintActivity로 넘어가기
                                //val intent = Intent(this, MyComplaintActivity::class.java)
                                //startActivity(intent)

                            }

                        }
                    }
                }
                builder.setNegativeButton("아니오",listener)
                builder.setPositiveButton("네",listener)
                builder.show()
            }
        }

        //전화걸기 버튼
        complaint_button_phonecall.setOnClickListener {
            var intent = Intent(Intent.ACTION_DIAL)
            intent.data = Uri.parse("tel:01012345678")
            if(intent.resolveActivity(packageManager) != null){
                startActivity(intent)
            }
        }

        //나의 민원 보기 버튼
        complaint_button_mycomplaint.setOnClickListener {
            //MyConplaintActivity로 넘어가기
            //val intent = Intent(this, MyComplaintActivity::class.java)
            //startActivity(intent)

        }


    }
}