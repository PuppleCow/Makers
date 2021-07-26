package com.pupplecow.myapplication.ui.complaint

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import com.pupplecow.myapplication.R
import com.pupplecow.myapplication.ui.home.HomeFragment

class ComplaintFragment:Fragment() {

    companion object {
        fun newInstance(): ComplaintFragment {
            return ComplaintFragment()
        }
    }

    override fun onCreateView(inflater: LayoutInflater,container:ViewGroup?,savedInstanceState:Bundle?): View?{
        val view=inflater.inflate(R.layout.activity_complaint,container,false)

        return view
    }

}


