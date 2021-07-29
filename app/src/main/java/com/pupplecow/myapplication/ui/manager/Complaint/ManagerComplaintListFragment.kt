package com.pupplecow.myapplication.ui.manager.Complaint

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.pupplecow.myapplication.R

class ManagerComplaintListFragment:Fragment() {
    companion object {
        fun newInstance(): ManagerComplaintListFragment {
            return ManagerComplaintListFragment()
        }
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)


    }


    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState:Bundle?): View?{
        val view=inflater.inflate(R.layout.fragment_manager_complaint_list,container,false)
        return view
    }
}