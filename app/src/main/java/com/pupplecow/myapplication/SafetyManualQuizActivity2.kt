package com.pupplecow.myapplication

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.pupplecow.myapplication.databinding.ActivitySafetyManualQuiz2Binding

class SafetyManualQuizActivity2 : AppCompatActivity() {
    private lateinit var binding: ActivitySafetyManualQuiz2Binding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding= ActivitySafetyManualQuiz2Binding.inflate(layoutInflater)
        setContentView(binding.root)


        // 확인 버튼
        binding.quiz2Button1.setOnClickListener {
            val quiz3_intent= Intent(this,SafetyManualQuizActivity3::class.java)

            // 두 문제 모두 체크되었을 때만 넘어가기
            if((binding.quiz2RadioButton1.isChecked==true || binding.quiz2RadioButton2.isChecked==true) &&
                (binding.quiz2RadioButton3.isChecked==true || binding.quiz2RadioButton4.isChecked==true)) {
                startActivity(quiz3_intent)
            }
        }
    }
}