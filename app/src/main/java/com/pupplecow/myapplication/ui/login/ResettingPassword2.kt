package com.pupplecow.myapplication.ui.login

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.appcompat.app.AlertDialog
import com.pupplecow.myapplication.ManageActivity
import com.pupplecow.myapplication.databinding.ActivityResettingPassword2Binding

class ResettingPassword2 : AppCompatActivity() {
    private lateinit var binding: ActivityResettingPassword2Binding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityResettingPassword2Binding.inflate(layoutInflater)
        setContentView(binding.root)


        // 새로운 비밀번호 입력받은 후, 기존 비밀번호에서 변경


        // 다음버튼 눌렀을때
        binding.resetting2Button1.setOnClickListener {
            //비밀번호 서로 같은지 확인하기
            val password = binding.resetting2Password.text.toString()
            val passwordCheck = binding.resetting2Password2.text.toString()



            // 영어 , 숫자 ,특수문자 포함 8~15 글자 중 하나라도 안지키면

            // 숫자, 문자, 특수문자 모두 포함 (8~15자)
            // ^(?=.*[A-Za-z])(?=.*[0-9])(?=.*[$@$!%*#?&]).{8,15}.$

//            String pwPattern = "^(?=.*[A-Za-z])(?=.*[0-9])(?=.*[$@$!%*#?&])[A-Za-z[0-9]$@$!%*#?&]{8,10}$";
//
//            영어 대소문자가 한개이상 들어가 있는가 ?  숫자가 한개이상 들어가 있는가 ?? 특수문자가 한개이상 들어가 있는가 ?
//
//            영어부터 숫자 특수문자를 입력 받을것이고,  8개 이상 10개 이하 의숫자를 받아야 한다.
            //
//            val s:String="^(?=.*[A-Za-z])(?=.*[0-9])(?=.*[$@$!%*#?&])[A-Za-z[0-9]$@$!%*#?&]{8,}$";
//            val s="^(?=.*[A-Za-z])(?=.*[0-9])(?=.*[\$@\$!%*#?&]).{8,15}.\$"
//            val b_password:Boolean= Pattern.matches(s,password)
//            val b_passwordCheck:Boolean=Pattern.matches(s,passwordCheck)



            // ====================> 비밀번호 조건: 6자리 & 숫자로만 <=====================

            if (binding.resetting2Password.length() != 6 || binding.resetting2Password2.length() != 6) {
                binding.resetting2TextView4.text = "글자 수가 맞지 않습니다. 다시 입력해주세요."
                binding.resetting2TextView5.text = ""
            }else if(isNumOnly(password)==false || isNumOnly(passwordCheck)==false){
                // 숫자로만 이루어져있는 지 확인
                binding.resetting2TextView4.text = "숫자로만 입력해주세요."
                binding.resetting2TextView5.text = ""
            }
            else if (password != passwordCheck) {
                // 비밀번호 다를 때

                binding.resetting2TextView4.text = "비밀번호가 맞지 않습니다. 다시 입력해주세요."
                binding.resetting2TextView5.text = ""
            } else {

                //비밀번호 같을때
                //"비밀번호 변경이 정상적으로 완료되었습니다." 메세지

                val builder = AlertDialog.Builder(this)
                builder.setTitle("")
                builder.setMessage("비밀번호 변경이 정상적으로 완료되었습니다")
                builder.setPositiveButton("확인", null)
                builder.show()

                // '관리자 탭'으로로 이동
                // ManageActivity로 넘어가기
                val intent = Intent(this, ManageActivity::class.java)
                startActivity(intent)
            }
        }

    }

    // 숫자로만 되어있는 지 판별
    fun isNumOnly(s:String):Boolean{
        for(item in s){
            if(item=='0'|| item=='1'|| item=='2'|| item=='3'|| item=='4'||
                item=='5'|| item=='6'|| item=='7'|| item=='8'|| item=='9'){
                return true
            }
        }
        return false
    }
}

//    fun validatePasswordc(c:Char) {
//        return /^1(?=.*[A-Za-z])(?=.*\d)(?=.*[$@$!%*#?&])[A-Za-z\d$@$!%*#?&]{6,}$/.test(character)
//    }

//
//        fun isAlphabet(c: Char) {
//            c in 'a'..'z' || c in 'A'..'Z'
//        }
//
//        fun isNUmber(c: Char) = c in '0'..'9'

//    fun isAlphabetInString(s:String) :Boolean {
//        for(c in s){
//
//        }

