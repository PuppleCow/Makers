package com.pupplecow.myapplication

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View.inflate
import android.widget.CompoundButton
import android.widget.PopupMenu
import androidx.core.content.res.ColorStateListInflaterCompat.inflate
import androidx.core.content.res.ComplexColorCompat.inflate
import com.pupplecow.myapplication.databinding.ActivityQuiz1Binding
import kotlinx.android.synthetic.main.activity_quiz1.*
import kotlinx.android.synthetic.main.activity_register2.*

class QuizActivity1 : AppCompatActivity() {
    private lateinit var binding: ActivityQuiz1Binding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityQuiz1Binding.inflate(layoutInflater)
        setContentView(binding.root)


        // 체크 박스들
        binding.quiz1CheckBox1.setOnClickListener{ onCheckChanged(quiz1_checkBox1)}
        binding.quiz1CheckBox2.setOnClickListener{ onCheckChanged(quiz1_checkBox2)}
        binding.quiz1CheckBox3.setOnClickListener{ onCheckChanged(quiz1_checkBox3)}
        binding.quiz1CheckBox4.setOnClickListener{ onCheckChanged(quiz1_checkBox4)}
        binding.quiz1CheckBox5.setOnClickListener{ onCheckChanged(quiz1_checkBox5)}

        // 개인정보 처리 동의 버튼
        binding.quiz1ImageButton2.setOnClickListener {
            val pop = PopupMenu(this, binding.quiz1Menu2)
            menuInflater.inflate(R.menu.menu, pop.menu)
            pop.show()
        }


        // 개인정보 지속 처리 동의 버튼
        binding.quiz1ImageButton3.setOnClickListener {
            val pop = PopupMenu(this, binding.quiz1Menu3)
            menuInflater.inflate(R.menu.menu, pop.menu)
            pop.show()
        }


        // 주민등록번호 지속 처리 동의 버튼
        binding.quiz1ImageButton4.setOnClickListener {
            val pop = PopupMenu(this, binding.quiz1Menu4)
            menuInflater.inflate(R.menu.menu, pop.menu)
            pop.show()
        }


        // 출근 안내 등 정보이용 동의 버튼
        binding.quiz1ImageButton5.setOnClickListener {
            val pop = PopupMenu(this, binding.quiz1Menu5)
            menuInflater.inflate(R.menu.menu, pop.menu)
            pop.show()
        }


        // 확인버튼
        binding.quiz1Button1.setOnClickListener {
            val quiz2_intent = Intent(this, QuizActivity2::class.java)
            startActivity(quiz2_intent)
        }
    }

    fun onCheckChanged(compoundButton: CompoundButton) {
        when (compoundButton.id) {
            R.id.quiz1_checkBox1 -> {
                if (binding.quiz1CheckBox1.isChecked) {
                    binding.quiz1CheckBox2.isChecked = true
                    binding.quiz1CheckBox3.isChecked = true
                    binding.quiz1CheckBox4.isChecked = true
                    binding.quiz1CheckBox5.isChecked = true
                } else {
                    binding.quiz1CheckBox2.isChecked = false
                    binding.quiz1CheckBox2.isChecked = false
                    binding.quiz1CheckBox2.isChecked = false
                    binding.quiz1CheckBox2.isChecked = false
                }
            }
            else -> {
                binding.quiz1CheckBox1.isChecked = (
                        binding.quiz1CheckBox2.isChecked
                                && binding.quiz1CheckBox3.isChecked
                                && binding.quiz1CheckBox4.isChecked
                                && binding.quiz1CheckBox5.isChecked)
            }
        }
    }
}