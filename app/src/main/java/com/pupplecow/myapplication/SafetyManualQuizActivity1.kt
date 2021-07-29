package com.pupplecow.myapplication

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.CompoundButton
import android.widget.PopupMenu
import android.widget.Toast
import com.pupplecow.myapplication.databinding.ActivitySafetyManualQuiz1Binding

class SafetyManualQuizActivity1 : AppCompatActivity() {
    private lateinit var binding: ActivitySafetyManualQuiz1Binding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivitySafetyManualQuiz1Binding.inflate(layoutInflater)
        setContentView(binding.root)


        // 체크 박스들
        binding.quiz1CheckBox1.setOnClickListener{ onCheckChanged(binding.quiz1CheckBox1)}
        binding.quiz1CheckBox2.setOnClickListener{ onCheckChanged(binding.quiz1CheckBox2)}
        binding.quiz1CheckBox3.setOnClickListener{ onCheckChanged(binding.quiz1CheckBox3)}
        binding.quiz1CheckBox4.setOnClickListener{ onCheckChanged(binding.quiz1CheckBox4)}
        binding.quiz1CheckBox5.setOnClickListener{ onCheckChanged(binding.quiz1CheckBox5)}

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

            // 필수항목 체크됐을 때만 넘어가기
            if (binding.quiz1CheckBox2.isChecked == true) {
                val quiz2_intent = Intent(this, SafetyManualQuizActivity2::class.java)
                startActivity(quiz2_intent)
                finish()
            }

            // 필수 항목 체크돼있지 않으면
            else{
                val t1=Toast.makeText(this,"필수항목이 비어있습니다",Toast.LENGTH_SHORT)
                t1.show()
            }
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