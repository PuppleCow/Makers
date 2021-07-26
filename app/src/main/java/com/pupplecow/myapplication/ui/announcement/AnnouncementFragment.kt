package com.pupplecow.myapplication.ui.announcement

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.pupplecow.myapplication.R
import com.pupplecow.myapplication.ui.home.HomeFragment

class AnnouncementFragment:Fragment() {

    companion object {
        fun newInstance(): AnnouncementFragment {
            return AnnouncementFragment()
        }
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View?{
        val view=inflater.inflate(R.layout.activity_announcement,container,false)

        return view
    }

}