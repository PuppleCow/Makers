package com.pupplecow.myapplication.ui.announcement

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.pupplecow.myapplication.R


class AnnouncmentListFragment:Fragment() {
    companion object {
        fun newInstance(): AnnouncmentListFragment {
            return AnnouncmentListFragment()
        }
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)


    }


    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState:Bundle?): View?{
        val view=inflater.inflate(R.layout.activity_announce_ment_list,container,false)
        return view
    }


}