package com.pupplecow.myapplication

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_register_acticity.*

class RegisterActicity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_register_acticity)

        //인증번호 받기 버튼 클릭
        register_id_button.setOnClickListener {
            //인증번호 전송 메시지
            register_message.text="010 **** 1234로 인증번호가 전송되었습니다.\n회원가입을 계속하시려면 인증번호를 입력하세요."


        }

        //다음버튼 클릭
        register_button1.setOnClickListener {
            //인증번호 확인

            //인증번호 확인되면
            //이름, 주민등록번호, 전화번호 저장

            //RegisterActivity_2로 넘어가기
            //val intent = Intent(this, RegisterAtivity_2::class.java)
            //startActivity(intent)

            //인증번호 틀리면
            register_message.text="인증번호가 틀렸습니다. 다시 인증해 주세요요"
        }

    }
}