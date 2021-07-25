package com.pupplecow.myapplication

import android.R.attr.button
import android.content.DialogInterface
import android.content.Intent
import android.os.Bundle
import android.view.MotionEvent
import android.view.View.OnTouchListener
import android.widget.ArrayAdapter
import android.widget.Spinner
import android.widget.Toast
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_login.*
import kotlinx.android.synthetic.main.activity_login.view.*


class LoginActivity : AppCompatActivity() {
    val login_data = arrayOf("선택", "상용직", "일용직")
    //val spinner=findViewById<Spinner>(R.id.login_workpart)
    //val choice=spinner.toString()

    //선택은 클릭해도 안되는 걸로 설정하기
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)


        val workpartAdapter = ArrayAdapter(this, android.R.layout.simple_spinner_item, login_data)
        workpartAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
        login_workpart.adapter = workpartAdapter


        //비밀번호 보여주기 이미지 클릭 시 text 보여주기 활성화(layout 분리해서)


        /*비밀번호 숨기기 해제
        login_imageButton.setOnClickListener(new OnTouchListener(){
            private fun boolean onTouch(View v, MotionEvent event) {
                login_imageButton.setOnTouchListener(OnTouchListener { v, event ->
                    when (event.action) {
                        MotionEvent.ACTION_UP -> editText.setInputType(InputType.TYPE_CLASS_TEXT or InputType.TYPE_TEXT_VARIATION_PASSWORD)
                        MotionEvent.ACTION_DOWN -> editText.setInputType(InputType.TYPE_CLASS_TEXT)
                    }
                    true
                })
        }
            */
        login_button.setOnClickListener {


            //spinner그룹
            val workpart = login_data[login_workpart.selectedItemPosition]

            //로그인 성공했을 경우(id와 password와 일용직/상용직 매치되는 정보 있으면)
            if (login_editTextPhone.text.toString() == "01087347954" && login_editTextTextPassword.text.toString() == "991109") {
                Toast.makeText(this@LoginActivity, "로그인 성공했습니다.", Toast.LENGTH_SHORT).show()

                val intent = Intent(this@LoginActivity, CheckInActivity::class.java)
                startActivity(intent)

            }

                //!!!로그인 성공했을 경우 toast 띄우기


            //<로그인 실패했을 경우>


            //휴대폰 번호가 입력되지 않았을 경우
            else if (login_editTextPhone.text.toString() == "") {
                val builder = AlertDialog.Builder(this)
                builder.setMessage("휴대폰 번호를 입력해주세요")
                builder.setPositiveButton("확인", null)
                builder.show()

            }
            //비밀번호가 입력되지 않았을 경우

            else if (login_editTextTextPassword.text.toString() == "") {
                val builder = AlertDialog.Builder(this)
                builder.setMessage("비밀번호를 입력해주세요")
                builder.setPositiveButton("확인", null)
                builder.show()
            }
            //상용/일용 선택되지 않았을 경우



            else if (workpart == "선택") {
                val builder = AlertDialog.Builder(this)
                builder.setMessage("상용직/일용직 중 선택해주세요")
                builder.setPositiveButton("확인", null)
                builder.show()
            }


            //휴대폰 or 비밀번호 틀렸을 경우
            else {
                val builder = AlertDialog.Builder(this)
                builder.setTitle("틀렸습니다")
                builder.setMessage("휴대폰 번호와 비밀번호를 확인해주세요")
                builder.setPositiveButton("확인", null)
                builder.show()
            }



            login_register_button.setOnClickListener {
                val builder = AlertDialog.Builder(this)
                builder.setTitle("아직 회원이 아니세요?")
                builder.setMessage("회원가입하시겠습니까?")
                var listener = object : DialogInterface.OnClickListener {
                    override fun onClick(p0: DialogInterface?, p1: Int) {
                        when (p1) {
                            DialogInterface.BUTTON_POSITIVE -> {
                                val intent =
                                    Intent(this@LoginActivity, RegisterActicity1::class.java)
                                startActivity(intent)
                            }
                        }
                    }
                }
                builder.setNegativeButton("아니오", listener)
                builder.setPositiveButton("네", listener)
                builder.show()


            }

        }
    }

}




