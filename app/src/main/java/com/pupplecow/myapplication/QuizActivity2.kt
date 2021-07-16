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

        binding.quiz2Button1.setOnClickListener {
            val quiz3_intent= Intent(this,QuizActivity3::class.java)
            startActivity(quiz3_intent)
        }
    }
}