package com.pupplecow.myapplication.ui.worker.settings

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.pupplecow.myapplication.R
import com.pupplecow.myapplication.databinding.ActivitySettingEmergencyInformationChangeBinding

class SettingEmergencyInformationChangeActivity : AppCompatActivity() {

    private lateinit var binding:ActivitySettingEmergencyInformationChangeBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding= ActivitySettingEmergencyInformationChangeBinding.inflate(layoutInflater)
        setContentView(binding.root)
    }
}