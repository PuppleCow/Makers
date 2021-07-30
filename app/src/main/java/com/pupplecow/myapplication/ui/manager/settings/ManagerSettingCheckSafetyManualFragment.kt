package com.pupplecow.myapplication.ui.manager.settings

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.pupplecow.myapplication.databinding.FragmentManagerSettingCheckSafetyManualBinding

class ManagerSettingCheckSafetyManualFragment:Fragment() {

    private var binding: FragmentManagerSettingCheckSafetyManualBinding?=null

    companion object {
        fun newInstance(): ManagerSettingCheckSafetyManualFragment {
            return ManagerSettingCheckSafetyManualFragment()
        }
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        val binding=FragmentManagerSettingCheckSafetyManualBinding.inflate(inflater,container,false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        // 안전 메뉴얼 확인 구현 ~~!!

    }

}