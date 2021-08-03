package com.pupplecow.myapplication.temporaryStorage

import android.content.DialogInterface
import android.content.Intent
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AlertDialog
import com.pupplecow.myapplication.databinding.ActivitySafetyManualQuiz2Binding
import com.pupplecow.myapplication.temporaryStorage.HomeActivity1
import kotlinx.android.synthetic.main.activity_safety_manual_quiz2.*

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
                builder.setPositiveButton("확인") { dialogInterface: DialogInterface, i: Int ->

                    // 정답: 관리자(radioButton1), 오른쪽(radioButton3)
                     if((binding.quiz2RadioButton1.isChecked==true)&& (binding.quiz2RadioButton3.isChecked==true)) {
                        // 맞았을 때
                        val builder = AlertDialog.Builder(this)
                        builder.setTitle("메뉴얼 퀴즈가 제출되었습니다.")
                        builder.setMessage("작업을 시작합니다.")
                        builder.setNegativeButton("취소", null)


                        // 확인 누르면 '작업장(홈)'으로 가기

                        builder.setPositiveButton("확인") { dialogInterface: DialogInterface, i: Int ->
//                        val home_intent=Intent(this, HomeActivity1::class.java)
//                        startActivity(home_intent)
                            finish()
                        }

                        builder.show()
                    }

                    // 틀렸을 때
                    else
                     {
                         val t1 = Toast.makeText(this, "정답이 아닙니다.", Toast.LENGTH_SHORT)
                         t1.show()
                     }
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
//        //산업안전 뉴스 제목,링크 불러오기
//        binding.quiz2TextView5.text="뉴스 제목입니다."
//
//        binding.quiz2TextView5.setOnClickListener {
//            var intent =
//                Intent(Intent.ACTION_VIEW, Uri.parse("https://www.news1.kr/articles/?4386702"))
//            startActivity(intent)
//        }
    }
}