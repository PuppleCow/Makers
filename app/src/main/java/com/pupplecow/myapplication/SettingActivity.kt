package com.pupplecow.myapplication

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.pupplecow.myapplication.databinding.ActivitySettingBinding


class SettingActivity : AppCompatActivity() {
    private lateinit var binding:ActivitySettingBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding= ActivitySettingBinding.inflate(layoutInflater)
        setContentView(binding.root)

        // 내 정보 설정
        binding.setting1ImageButton1.setOnClickListener {
            val myInformationSetting_intent= Intent(this,SettingMyInformationSettingActivity::class.java)
            startActivity(myInformationSetting_intent)
        }

        // 오픈소스 라이센스
        binding.setting1ImageButton2.setOnClickListener {
            val openSourceLicense_intent= Intent(this,SettingOpenSourceLicense::class.java)
            startActivity(openSourceLicense_intent)
        }

        // 약관 및 정책
        binding.setting1ImageButton3.setOnClickListener {
            val termsAndPolicy_intent= Intent(this,SettingTermsAndPolicy::class.java)
            startActivity(termsAndPolicy_intent)
        }

        // 안전 메뉴얼 확인
        binding.setting1ImageButton4.setOnClickListener {
            val checkSafetyManual_intent= Intent(this,SettingCheckSafetyManual::class.java)
            startActivity(checkSafetyManual_intent)
        }

    }
}