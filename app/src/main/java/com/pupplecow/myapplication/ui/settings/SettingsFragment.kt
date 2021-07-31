package com.pupplecow.myapplication.ui.settings

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.pupplecow.myapplication.*
import kotlinx.android.synthetic.main.activity_setting.*
import kotlinx.android.synthetic.main.fragment_setting.*

class SettingsFragment:Fragment() {

    companion object {
        fun newInstance(): SettingsFragment {
            return SettingsFragment()
        }

        private lateinit var settingMyInformationFragment: SettingMyInformationFragment
        private lateinit var settingOpenSourceLicenseFragment: SettingOpenSourceLicenseFragment
        private lateinit var settingTermsAndPolicyFragment: SettingTermsAndPolicyFragment
        private lateinit var settingCheckSafetyManualFragment: SettingCheckSafetyManualFragment
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View?{
        val view=inflater.inflate(R.layout.fragment_setting,container,false)

        return view
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        // 내 정보 설정
        fragment_setting1_imageButton1.setOnClickListener {

//            val myInformationSetting_intent= Intent(activity,SettingMyInformationSettingActivity::class.java)
//            startActivity(myInformationSetting_intent)

            settingMyInformationFragment=SettingMyInformationFragment.newInstance()
            val tran=activity?.supportFragmentManager?.beginTransaction()?.replace(R.id.main_nav_frame, settingMyInformationFragment)?.addToBackStack(null)?.commit()
        }

        // 오픈소스 라이센스
        fragment_setting1_imageButton2.setOnClickListener {

//            val openSourceLicense_intent= Intent(activity,SettingOpenSourceLicense::class.java)
//            startActivity(openSourceLicense_intent)

            settingOpenSourceLicenseFragment=SettingOpenSourceLicenseFragment.newInstance()
            val tran=activity?.supportFragmentManager?.beginTransaction()?.replace(R.id.main_nav_frame, settingOpenSourceLicenseFragment)?.addToBackStack(null)?.commit()
        }

        // 약관 및 정책
        fragment_setting1_imageButton3.setOnClickListener {

//            val termsAndPolicy_intent= Intent(activity,SettingTermsAndPolicy::class.java)
//            startActivity(termsAndPolicy_intent)

            settingTermsAndPolicyFragment=SettingTermsAndPolicyFragment.newInstance()
            val tran=activity?.supportFragmentManager?.beginTransaction()?.replace(R.id.main_nav_frame, settingTermsAndPolicyFragment)?.addToBackStack(null)?.commit()
        }

        // 안전 메뉴얼 확인
        fragment_setting1_imageButton4.setOnClickListener {

//            val checkSafetyManual_intent= Intent(activity,SettingCheckSafetyManual::class.java)
//            startActivity(checkSafetyManual_intent)

            settingCheckSafetyManualFragment=SettingCheckSafetyManualFragment.newInstance()
            val tran=activity?.supportFragmentManager?.beginTransaction()?.replace(R.id.main_nav_frame, settingCheckSafetyManualFragment)?.addToBackStack(null)?.commit()
        }
    }
}