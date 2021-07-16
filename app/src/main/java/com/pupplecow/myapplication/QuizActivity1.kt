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

        binding.quiz1Button1.setOnClickListener {
            val quiz2_intent= Intent(this,QuizActivity2::class.java)
            startActivity(quiz2_intent)
        }

        binding.quiz1CheckBox1.setOnClickListener {
            if(binding.quiz1CheckBox1.isChecked==true)
            {
                binding.quiz1CheckBox2.isChecked=true
                binding.quiz1CheckBox3.isChecked=true
                binding.quiz1CheckBox4.isChecked=true
                binding.quiz1CheckBox5.isChecked=true
            }

            binding.quiz1ImageButton2.setOnClickListener{
                val pop= PopupMenu(this,binding.quiz1Menu2)
                menuInflater.inflate(R.menu.menu,pop.menu)
                pop.show()
            }
            binding.quiz1ImageButton3.setOnClickListener{
                val pop= PopupMenu(this,binding.quiz1Menu3)
                menuInflater.inflate(R.menu.menu,pop.menu)
                pop.show()
            }
            binding.quiz1ImageButton4.setOnClickListener{
                val pop= PopupMenu(this,binding.quiz1Menu4)
                menuInflater.inflate(R.menu.menu,pop.menu)
                pop.show()
            }
            binding.quiz1ImageButton5.setOnClickListener{
                val pop= PopupMenu(this,binding.quiz1Menu5)
                menuInflater.inflate(R.menu.menu,pop.menu)
                pop.show()
            }
        }
    }
}