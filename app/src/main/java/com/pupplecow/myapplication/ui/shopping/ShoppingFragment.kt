package com.pupplecow.myapplication.ui.shopping

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.pupplecow.myapplication.R
import com.pupplecow.myapplication.ui.complaint.ComplaintFragment

class ShoppingFragment:Fragment() {

    companion object {
        fun newInstance(): ShoppingFragment {
            return ShoppingFragment()
        }
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)


    }

    override fun onCreateView(inflater: LayoutInflater,container:ViewGroup?,savedInstanceState:Bundle?): View?{
        val view=inflater.inflate(R.layout.fragment_shopping,container,false)
        return view
    }

}
