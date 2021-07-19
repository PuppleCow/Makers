package com.pupplecow.myapplication

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.pupplecow.myapplication.databinding.ActivitySafetyManualQuiz3Binding

class SafetyManualQuizActivity3 : AppCompatActivity() {
    private lateinit var binding:ActivitySafetyManualQuiz3Binding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding= ActivitySafetyManualQuiz3Binding.inflate(layoutInflater)
        setContentView(binding.root)


        // 취소 버튼 ( 뒤로 가기 )
        binding.quiz3Button1.setOnClickListener {
            finish()
        }
    }
}