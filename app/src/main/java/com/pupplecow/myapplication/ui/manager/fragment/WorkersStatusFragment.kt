package com.pupplecow.myapplication.ui.manager.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.pupplecow.myapplication.R
import com.pupplecow.myapplication.ui.complaint.ComplaintFragment

class WorkersStatusFragment:Fragment() {
    companion object {
        fun newInstance(): WorkersStatusFragment {
            return WorkersStatusFragment()
        }
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)


    }


    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState:Bundle?): View?{
        val view=inflater.inflate(R.layout.fragment_manager_workers_status,container,false)
        return view
    }

}