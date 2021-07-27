package com.pupplecow.myapplication

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.pupplecow.myapplication.databinding.ActivitySafetyManualQuiz3Binding
import com.pupplecow.myapplication.temporaryStorage.HomeActivity1

class SafetyManualQuizActivity3 : AppCompatActivity() {
    private lateinit var binding:ActivitySafetyManualQuiz3Binding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding= ActivitySafetyManualQuiz3Binding.inflate(layoutInflater)
        setContentView(binding.root)

        // 확인 버튼 ( 작업장(홈) 으로 가기 )
        binding.quiz3Button3.setOnClickListener{
            val home_intent=Intent(this, HomeActivity1::class.java )
            startActivity(home_intent)
        }
    }
}