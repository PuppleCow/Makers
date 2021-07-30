package com.pupplecow.myapplication.ui.settings

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.pupplecow.myapplication.databinding.FragmentSettingOpenSourceLicenseBinding


class SettingOpenSourceLicenseFragment : Fragment(){

    private val binding: FragmentSettingOpenSourceLicenseBinding?=null

    companion object{
        fun newInstance(): SettingOpenSourceLicenseFragment{
            return SettingOpenSourceLicenseFragment()
        }
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        val binding=FragmentSettingOpenSourceLicenseBinding.inflate(inflater,container,false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        // 오픈소스 라이선스 구현~~!!

    }

}