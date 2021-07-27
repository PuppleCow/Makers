package com.pupplecow.myapplication.ui.settings

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.pupplecow.myapplication.*
import kotlinx.android.synthetic.main.activity_setting.*

class SettingsFragment:Fragment() {

    companion object {
        fun newInstance(): SettingsFragment {
            return SettingsFragment()
        }
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View?{
        val view=inflater.inflate(R.layout.activity_setting,container,false)

        return view
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setting1_imageButton1.setOnClickListener {
            val myInformationSetting_intent= Intent(activity,SettingMyInformationSettingActivity::class.java)
            startActivity(myInformationSetting_intent)
        }

        // 오픈소스 라이센스
        setting1_imageButton2.setOnClickListener {
            val openSourceLicense_intent= Intent(activity,SettingOpenSourceLicense::class.java)
            startActivity(openSourceLicense_intent)
        }

        // 약관 및 정책
        setting1_imageButton3.setOnClickListener {
            val termsAndPolicy_intent= Intent(activity,SettingTermsAndPolicy::class.java)
            startActivity(termsAndPolicy_intent)
        }

        // 안전 메뉴얼 확인
        setting1_imageButton4.setOnClickListener {
            val checkSafetyManual_intent= Intent(activity,SettingCheckSafetyManual::class.java)
            startActivity(checkSafetyManual_intent)
        }
    }
}