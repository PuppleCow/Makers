package com.pupplecow.myapplication.ui.manager.settings

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.pupplecow.myapplication.databinding.FragmentManagerSettingOpenSourceLicenseBinding


class ManagerSettingOpenSourceLicenseFragment : Fragment(){

    private val binding: FragmentManagerSettingOpenSourceLicenseBinding?=null

    companion object{
        fun newInstance(): ManagerSettingOpenSourceLicenseFragment{
            return ManagerSettingOpenSourceLicenseFragment()
        }
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        val binding=FragmentManagerSettingOpenSourceLicenseBinding.inflate(inflater,container,false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        // 오픈소스 라이선스 구현~~!!

    }

}