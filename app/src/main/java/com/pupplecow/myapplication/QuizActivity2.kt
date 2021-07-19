package com.pupplecow.myapplication

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.pupplecow.myapplication.databinding.ActivityQuiz2Binding

class QuizActivity2 : AppCompatActivity() {
    private lateinit var binding: ActivityQuiz2Binding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding= ActivityQuiz2Binding.inflate(layoutInflater)
        setContentView(binding.root)


        // 확인 버튼
        binding.quiz2Button1.setOnClickListener {
            val quiz3_intent= Intent(this,QuizActivity3::class.java)

            // 두 문제 모두 체크되었을 때만 넘어가기
            if((binding.quiz2RadioButton1.isChecked==true || binding.quiz2RadioButton2.isChecked==true) &&
                (binding.quiz2RadioButton3.isChecked==true || binding.quiz2RadioButton4.isChecked==true)) {
                startActivity(quiz3_intent)
            }
        }
    }
}