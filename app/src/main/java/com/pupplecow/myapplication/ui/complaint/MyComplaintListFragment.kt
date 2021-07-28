package com.pupplecow.myapplication.ui.complaint

import android.Manifest
import android.content.DialogInterface
import android.content.Intent
import android.graphics.BitmapFactory
import android.graphics.ImageDecoder
import android.net.Uri
import android.os.Build
import android.os.Bundle
import android.provider.MediaStore
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.isVisible
import com.pupplecow.myapplication.R
import com.pupplecow.myapplication.ui.home.HomeFragment
import kotlinx.android.synthetic.main.activity_complaint.*
import kotlinx.android.synthetic.main.fragment_my_complaint.*
import java.util.*


class MyComplaintListFragment:Fragment() {
    private lateinit var complaintFragment: ComplaintFragment


    companion object {
        fun newInstance(): MyComplaintListFragment {
            return MyComplaintListFragment()
        }
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)



    }





    override fun onCreateView(inflater: LayoutInflater,container:ViewGroup?,savedInstanceState:Bundle?): View?{
        val view=inflater.inflate(R.layout.activity_my_complaint_list,container,false)
        return view
    }



}


