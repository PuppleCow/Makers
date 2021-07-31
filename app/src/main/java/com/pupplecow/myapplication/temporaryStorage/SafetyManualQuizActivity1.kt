package com.pupplecow.myapplication.temporaryStorage

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.CompoundButton
import android.widget.Toast
import com.pupplecow.myapplication.databinding.ActivitySafetyManualQuiz1Binding
import com.pupplecow.myapplication.R
import com.pupplecow.myapplication.temporaryStorage.SafetyManualQuizActivity2

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

        // ====================== 약관 내용 보이기 ========================

        // 개인정보 처리 동의 버튼
        binding.quiz1TextView2.setOnClickListener {
            binding.quiz1Scrollview.visibility=View.VISIBLE

            binding.quiz1TextView6.text="약관1 \n" +
                    "개인정보\n처리\n동의\n"
        }


        // 개인정보 지속 처리 동의 버튼
        binding.quiz1TextView3.setOnClickListener {
            binding.quiz1Scrollview.visibility=View.VISIBLE

            binding.quiz1TextView6.text="약관2 \n" +
                    "개인정보\n지속\n처리\n동의\n"
        }


        // 주민등록번호 지속 처리 동의 버튼
        binding.quiz1TextView4.setOnClickListener {
            binding.quiz1Scrollview.visibility=View.VISIBLE

            binding.quiz1TextView6.text="약관3 \n" +
                    "주민등록번호\n지속\n처리\n동의\n"
        }


        // 출근 안내 등 정보이용 동의 버튼
        binding.quiz1TextView5.setOnClickListener {
            binding.quiz1Scrollview.visibility=View.VISIBLE

            binding.quiz1TextView6.text="약관4 \n" +
                    "출근 안내 등\n정보이용\n동의\n"
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
