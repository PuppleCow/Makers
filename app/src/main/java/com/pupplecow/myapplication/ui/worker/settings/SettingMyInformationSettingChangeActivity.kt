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
    }
}