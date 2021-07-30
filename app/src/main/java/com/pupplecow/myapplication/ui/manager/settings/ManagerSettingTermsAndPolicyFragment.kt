package com.pupplecow.myapplication.ui.manager.settings

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.pupplecow.myapplication.databinding.FragmentManagerSettingTermsAndPolicyBinding


class ManagerSettingTermsAndPolicyFragment: Fragment() {

    private var binding:FragmentManagerSettingTermsAndPolicyBinding?=null

    companion object{
        fun newInstance(): ManagerSettingTermsAndPolicyFragment{
            return ManagerSettingTermsAndPolicyFragment()
        }
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        val binding=FragmentManagerSettingTermsAndPolicyBinding.inflate(inflater,container,false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        // 약관 및 정책 구현 ~~!!

    }

}