package com.pupplecow.myapplication

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.pupplecow.myapplication.databinding.ActivitySettingEmergencyInformaionBinding

class SettingEmergencyInformationActivity: AppCompatActivity() {

    private lateinit var binding:ActivitySettingEmergencyInformaionBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding= ActivitySettingEmergencyInformaionBinding.inflate(layoutInflater)
        setContentView(binding.root)
    }

}