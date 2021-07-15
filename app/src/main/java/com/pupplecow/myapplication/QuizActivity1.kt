package com.pupplecow.myapplication

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View.inflate
import android.widget.PopupMenu
import androidx.core.content.res.ColorStateListInflaterCompat.inflate
import androidx.core.content.res.ComplexColorCompat.inflate
import com.pupplecow.myapplication.databinding.ActivityQuiz1Binding

class QuizActivity1 : AppCompatActivity() {
    private lateinit var binding:ActivityQuiz1Binding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding= ActivityQuiz1Binding.inflate(layoutInflater)
        setContentView(binding.root)

//        binding.quizButton1.setOnClickListener {
//            val second_intent= Intent(this,binding.SecondActivity::class.java)
//            startActivity(second_intent)
//        }

        binding.quizCheckBox1.setOnClickListener {
            if(binding.quizCheckBox1.isChecked==true)
            {
                binding.quizCheckBox2.isChecked=true
                binding.quizCheckBox3.isChecked=true
                binding.quizCheckBox4.isChecked=true
                binding.quizCheckBox5.isChecked=true
            }

            binding.quizImageButton2.setOnClickListener{
                val pop= PopupMenu(this,binding.quizMenu2)
                menuInflater.inflate(R.menu.menu,pop.menu)
                pop.show()
            }
            binding.quizImageButton3.setOnClickListener{
                val pop= PopupMenu(this,binding.quizMenu3)
                menuInflater.inflate(R.menu.menu,pop.menu)
                pop.show()
            }
            binding.quizImageButton4.setOnClickListener{
                val pop= PopupMenu(this,binding.quizMenu4)
                menuInflater.inflate(R.menu.menu,pop.menu)
                pop.show()
            }
            binding.quizImageButton5.setOnClickListener{
                val pop= PopupMenu(this,binding.quizMenu5)
                menuInflater.inflate(R.menu.menu,pop.menu)
                pop.show()
            }
        }
    }
}