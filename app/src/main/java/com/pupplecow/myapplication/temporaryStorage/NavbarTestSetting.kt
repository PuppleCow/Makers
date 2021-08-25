package com.pupplecow.myapplication.temporaryStorage

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.pupplecow.myapplication.R

class NavbarTestSetting: Fragment() {

    companion object{
        fun newInstance() : NavbarTestSetting {
            return NavbarTestSetting()
        }
    }


    // 뷰가 생성되었을 때
    // 프레그먼트와 레이아웃을 연결시켜주는 부분
   override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {

        val view=inflater.inflate(R.layout.activity_navbar_test_setting,container,false)

        return view
    }
}