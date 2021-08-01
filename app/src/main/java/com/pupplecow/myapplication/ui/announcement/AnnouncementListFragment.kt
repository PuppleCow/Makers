package com.pupplecow.myapplication.ui.announcement

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import com.pupplecow.myapplication.R
import kotlinx.android.synthetic.main.fragment_announcementworker.*

//근무자 위한 list 프래그먼트
class AnnouncementListFragment:Fragment() {


    private lateinit var announcementFragmentWorkerVer : AnnouncementFragmentWorkerVer

    var AnnouncementList= arrayListOf<AnnounceMentList>(
        AnnounceMentList("5/10", "공지1", "필독!" ),
        AnnounceMentList("5/12", "공지2", "필독!" ),
        AnnounceMentList("5/13", "공지3", "" ),
        AnnounceMentList("5/14", "공지4", "" ),
        AnnounceMentList("5/15", "공지5", ""),
        AnnounceMentList("5/16", "공지6", ""),
        AnnounceMentList("5/17", "공지7", "필독!")

    )



    companion object {
        fun newInstance(): AnnouncementListFragment {
            return AnnouncementListFragment()
        }
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)



        val listAdapter = AnnouncementListAdapterActivity(requireContext(), AnnouncementList){
                Announcement->
            announcementFragmentWorkerVer= AnnouncementFragmentWorkerVer.newInstance()
            val transaction = activity?.supportFragmentManager?.beginTransaction()?.replace(R.id.main_nav_frame,announcementFragmentWorkerVer)?.addToBackStack(null)?.commit()

        }
        announcementlist_recyclerviewWorker.adapter = listAdapter


        val lm = LinearLayoutManager(requireContext())
        announcementlist_recyclerviewWorker.layoutManager = lm
        announcementlist_recyclerviewWorker.setHasFixedSize(true)


    }


    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState:Bundle?): View?{
        val view=inflater.inflate(R.layout.fragment_announcementworker,container,false)
        return view
    }


}