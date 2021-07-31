package com.pupplecow.myapplication.ui.manager.settings

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.pupplecow.myapplication.R
import com.pupplecow.myapplication.databinding.FragmentManagerSettingsBinding
import com.pupplecow.myapplication.ui.settings.*

class ManagerSettingsFragment:Fragment() {
    private lateinit var managerSettingMyInformationFragment: ManagerSettingMyInformationFragment
    private lateinit var managerSettingOpenSourceLicenseFragment: ManagerSettingOpenSourceLicenseFragment
    private lateinit var managerSettingTermsAndPolicyFragment: ManagerSettingTermsAndPolicyFragment
    private lateinit var managerSettingCheckSafetyManualFragment: ManagerSettingCheckSafetyManualFragment

    private val binding:FragmentManagerSettingsBinding?=null

    companion object {
        fun newInstance(): ManagerSettingsFragment {
            return ManagerSettingsFragment()
        }

    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View?{
        val binding=FragmentManagerSettingsBinding.inflate(inflater,container,false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        // 내 정보 설정
        binding?.fragmentManagerSettings1ImageButton1?.setOnClickListener {

            managerSettingMyInformationFragment = ManagerSettingMyInformationFragment.newInstance()
            val tran=activity?.supportFragmentManager?.beginTransaction()?.replace(R.id.manager_nav_frame, managerSettingMyInformationFragment)?.addToBackStack(null)?.commit()
        }

        // 오픈소스 라이센스
        binding?.fragmentManagerSettings1ImageButton2?.setOnClickListener {

            managerSettingOpenSourceLicenseFragment = ManagerSettingOpenSourceLicenseFragment.newInstance()
            val tran=activity?.supportFragmentManager?.beginTransaction()?.replace(R.id.main_nav_frame,managerSettingOpenSourceLicenseFragment)?.addToBackStack(null)?.commit()
        }

        // 약관 및 정책
        binding?.fragmentManagerSettings1ImageButton3?.setOnClickListener {

            managerSettingTermsAndPolicyFragment = ManagerSettingTermsAndPolicyFragment.newInstance()
            val tran=activity?.supportFragmentManager?.beginTransaction()?.replace(R.id.main_nav_frame, managerSettingTermsAndPolicyFragment)?.addToBackStack(null)?.commit()
        }

        // 안전 메뉴얼 확인
        binding?.fragmentManagerSettings1ImageButton4?.setOnClickListener {

            managerSettingCheckSafetyManualFragment = ManagerSettingCheckSafetyManualFragment.newInstance()
            val tran=activity?.supportFragmentManager?.beginTransaction()?.replace(R.id.main_nav_frame, managerSettingCheckSafetyManualFragment
            )?.addToBackStack(null)?.commit()
        }
    }
}