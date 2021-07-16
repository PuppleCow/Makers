package com.pupplecow.myapplication

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.pupplecow.myapplication.databinding.ActivityQuiz3Binding

class QuizActivity3 : AppCompatActivity() {
    private lateinit var binding:ActivityQuiz3Binding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding= ActivityQuiz3Binding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.quiz3Button1.setOnClickListener {
            finish()
        }
    }
}