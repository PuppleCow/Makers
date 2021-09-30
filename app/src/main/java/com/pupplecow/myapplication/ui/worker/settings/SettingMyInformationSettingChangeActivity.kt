package com.pupplecow.myapplication.ui.worker.settings

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.pupplecow.myapplication.databinding.ActivitySettingMyInformationSettingChangeBinding

class SettingMyInformationSettingChangeActivity : AppCompatActivity() {

    private lateinit var binding:ActivitySettingMyInformationSettingChangeBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding= ActivitySettingMyInformationSettingChangeBinding.inflate(layoutInflater)
        setContentView(binding.root)

        // 이름
        binding.setting2ChangeName

        // 생년월일
        binding.setting2ChangeBirth

        // 인증번호 받기 ( 전화번호 입력 )
        binding.setting2ChangeWritePhone

        // 인증번호 받기 버튼
        binding.setting2ChangeGetNumber.setOnClickListener {

        }

        // 인증번호 입력
        binding.setting2ChangeComparePhone

        // 완료 버튼
        binding.setting2ChangeComplete.setOnClickListener {

        }
    }
}