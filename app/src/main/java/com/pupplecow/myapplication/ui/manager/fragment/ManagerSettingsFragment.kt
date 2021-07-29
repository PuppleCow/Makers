package com.pupplecow.myapplication.ui.manager.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.pupplecow.myapplication.R
import com.pupplecow.myapplication.ui.complaint.ComplaintFragment

class ManagerSettingsFragment:Fragment() {
    companion object {
        fun newInstance(): ManagerSettingsFragment{
            return ManagerSettingsFragment()
        }
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)


    }


    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState:Bundle?): View?{
        val view=inflater.inflate(R.layout.fragment_manager_settings,container,false)
        return view
    }
}