package com.pupplecow.myapplication.ui.settings

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.pupplecow.myapplication.databinding.FragmentSettingTermsAndPolicyBinding


class SettingTermsAndPolicyFragment: Fragment() {

    private var binding:FragmentSettingTermsAndPolicyBinding?=null

    companion object{
        fun newInstance(): SettingTermsAndPolicyFragment{
            return SettingTermsAndPolicyFragment()
        }
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        val binding=FragmentSettingTermsAndPolicyBinding.inflate(inflater,container,false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        // 약관 및 정책 구현 ~~!!

    }

}