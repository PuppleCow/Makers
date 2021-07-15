package com.pupplecow.myapplication

import android.content.DialogInterface
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ArrayAdapter
import androidx.appcompat.app.AlertDialog
import kotlinx.android.synthetic.main.activity_home1.*
import kotlinx.android.synthetic.main.activity_login.*
import kotlinx.android.synthetic.main.activity_login.view.*
import kotlinx.android.synthetic.main.activity_register1.*

class LoginActivity : AppCompatActivity() {
   val login_data = arrayOf("상용직","일용직")

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)



        val workpartAdapter = ArrayAdapter(this,android.R.layout.simple_spinner_item,login_data)
        workpartAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
        login_workpart.adapter= workpartAdapter





        //비밀번호 보여주기 이미지 클릭 시 text 보여주기 활성화(layout 분리해서)




        login_button.setOnClickListener {



            //로그인 성공했을 경우(id와 password와 일용직/상용직 매치되는 정보 있으면)
            if(login_id.textView.toString()=="01087347954"&&login_password.textView.toString()=="991109") {
                if(login_data[login_workpart.selectedItemPosition]=="상용직"){
                    //HomeActivity1로 이동
                    val intent = Intent(this, HomeActivity1::class.java)
                    startActivity(intent)
                }
                //이걸 따로 뺄 것인가 아니면 번호, 비밀번호 물어볼 때 같이 메시지 띄울 것인가?
                else{
                    println("상용직/일용직을 다시 선택해주세요")
                }


            }


            //로그인 실패했을 경우

            else{

                /*
                private fun showAlert() {
                    AlertDialog.Builder(this) .setTitle("휴대폰 번호나 비밀번호를 확인해주세요")
                        .setPositiveButton("확인") { dialogInterface: DialogInterface, i: Int -> finish() }
                        .setNegativeButton("취소") { dialogInterface: DialogInterface, i: Int -> } .show() }
                */

            //or

                /*
                val dig: AlertDialog.Builder = AlertDialog.Builder(this@LoginActivity, android.R.style.Theme_DeviceDefault_Light_Dialog_NoActionBar_MinWidth)
                dig.setTitle("일치하는 회원정보가 없습니다.") //제목
                dig.setMessage("휴대폰 번호나 비밀번호를 확인해주세요")
                dig.setPositiveButton("확인", DialogInterface.OnClickListener { dialog, which ->
                    startActivity(intent)
                    finish()
                })

                dig.show()

                 */
        }


    }
}

}

