package com.pupplecow.myapplication.ui.manager.settings

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.pupplecow.myapplication.R
import com.pupplecow.myapplication.databinding.FragmentManagerSettingCheckSafetyManualBinding

class ManagerSettingCheckSafetyManualFragment :Fragment(){

    companion object{
        fun newInstance(): ManagerSettingCheckSafetyManualFragment{
            return ManagerSettingCheckSafetyManualFragment()
        }
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        val view=inflater.inflate(R.layout.fragment_manager_setting_check_safety_manual,container,false)
        return view
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
    }

}

