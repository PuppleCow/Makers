package com.pupplecow.myapplication.ui.worker.settings

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.pupplecow.myapplication.databinding.ActivitySettingEmergencyInformaionBinding

class SettingEmergencyInformationActivity: AppCompatActivity() {

    private lateinit var binding:ActivitySettingEmergencyInformaionBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding= ActivitySettingEmergencyInformaionBinding.inflate(layoutInflater)
        setContentView(binding.root)

        // 수정 버튼 누르면 이동하기
        binding.setting6Change.setOnClickListener {
            val intent=Intent(this,SettingEmergencyInformationChangeActivity::class.java)
            startActivity(intent)
        }


    }
}