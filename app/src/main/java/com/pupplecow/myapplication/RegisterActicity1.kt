package com.pupplecow.myapplication

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.appcompat.app.AlertDialog
import kotlinx.android.synthetic.main.activity_create_announcement.*
import kotlinx.android.synthetic.main.activity_register1.*

class RegisterActicity1 : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_register1)


        //인증번호 받기 버튼 클릭
        register_id_button.setOnClickListener {
            //핸드폰번호 저장

            //핸드폰번호 입력했는지 확인 (빈칸이면 메시지)
            val userCellPhoneNumber=register_cellPhoneNumber_input.text.toString()
            if(userCellPhoneNumber==""){ }
            else{
            //val inputCellPhoneNumber
           // val userCellPhoneNumber=register_cellPhoneNumber_input.text.toString()
            val userCellPhoneNumberFront=userCellPhoneNumber.substring(0,3)
            val userCellPhoneNumberBack=userCellPhoneNumber.substring(7,11)


            //핸드폰 번호로 인증번호 전송 메시지
            //register_message.text=register_cellPhoneNumber_input.text
            register_message.text=userCellPhoneNumberFront+" **** "+userCellPhoneNumberBack+"로 인증번호가 전송되었습니다.\n회원가입을 계속하시려면 인증번호를 입력하세요."

            //인증번호 전송하기

            }
        }

        //다음버튼 클릭
        register_button1.setOnClickListener {

            //인증번호 확인
            if(register_number_input.text.toString()=="1234") {
                //인증번호 확인되면
                //이름, 주민등록번호, 전화번호 저장
                val userCellPhoneNumber=register_cellPhoneNumber_input.text.toString()
                var userName=register_name_input.text.toString()
                var userId=register_name_input.text.toString()

                //RegisterActivity_2로 넘어가기
                val intent = Intent(this, RegisterActivity2::class.java)
                intent.putExtra("userCellPhoneNumber",userCellPhoneNumber)
                startActivity(intent)


            }
            else{
                //인증번호 틀리면
                register_message.text="인증번호가 틀렸습니다. 다시 인증해 주세요"
            }
        }

    }

}