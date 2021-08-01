package com.pupplecow.myapplication.ui.home

import android.content.DialogInterface
import android.content.Intent
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AlertDialog
import com.pupplecow.myapplication.databinding.ActivitySafetyManualQuiz2Binding
import com.pupplecow.myapplication.temporaryStorage.HomeActivity1
import kotlinx.android.synthetic.main.fragment_manager_home.*

class SafetyManualQuizActivity2 : AppCompatActivity() {
    private lateinit var binding: ActivitySafetyManualQuiz2Binding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding= ActivitySafetyManualQuiz2Binding.inflate(layoutInflater)
        setContentView(binding.root)


        // 완료 버튼
        binding.quiz2Button1.setOnClickListener {

            // 두 문제 모두 체크되었으면
            // '퀴즈를 제출하시겠습니까?' 메세지 띄우기
            if((binding.quiz2RadioButton1.isChecked==true || binding.quiz2RadioButton2.isChecked==true) &&
                (binding.quiz2RadioButton3.isChecked==true || binding.quiz2RadioButton4.isChecked==true)) {
                val builder= AlertDialog.Builder(this)
                builder.setTitle("")
                builder.setMessage("퀴즈를 제출하시겠습니까?")

//                var listener = object : DialogInterface.OnClickListener {
//                    override fun onClick(p0: DialogInterface?, p1: Int) {
//                        when (p1) {
//                            DialogInterface.BUTTON_POSITIVE -> {
//                                val intent =
//                                    Intent(this@LoginActivity, RegisterActicity1::class.java)
//                                startActivity(intent)
//                            }
//                        }
//                    }
//                }

                builder.setPositiveButton("확인"){ dialogInterface: DialogInterface, i: Int ->

                    val builder= AlertDialog.Builder(this)
                    builder.setTitle("메뉴얼 퀴즈가 제출되었습니다.")
                    builder.setMessage("작업을 시작합니다.")
                    builder.setNegativeButton("취소",null)


                    // 확인 누르면 '작업장(홈)'으로 가기

                    builder.setPositiveButton("확인"){ dialogInterface: DialogInterface, i: Int ->
//                        val home_intent=Intent(this, HomeActivity1::class.java)
//                        startActivity(home_intent)
                        finish()
                    }

                    builder.show()
                }


                builder.setNegativeButton("취소",null)
                builder.show()
            }

            // 풀지 않은 퀴즈가 있다면
            else{
                val t1 = Toast.makeText(this, "풀지 않은 퀴즈가 있습니다", Toast.LENGTH_SHORT)
                t1.show()
            }
        }
    }
}