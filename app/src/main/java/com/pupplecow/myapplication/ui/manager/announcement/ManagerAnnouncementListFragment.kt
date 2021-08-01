package com.pupplecow.myapplication.ui.manager.announcement

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import com.pupplecow.myapplication.R
import com.pupplecow.myapplication.temporaryStorage.CreateAnnouncementActivity
import com.pupplecow.myapplication.ui.announcement.AnnounceMentList
import kotlinx.android.synthetic.main.fragment_manager_announcement_list.*

class ManagerAnnouncementListFragment:Fragment() {


    private lateinit var managerAnnouncementFragment: ManagerAnnouncementFragment

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
        fun newInstance(): ManagerAnnouncementListFragment {
            return ManagerAnnouncementListFragment()
        }
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val listAdapter = ManagerAnnouncementListAdapter(requireContext(), AnnouncementList){
           Announcement->

            managerAnnouncementFragment= ManagerAnnouncementFragment.newInstance()
            val transaction = activity?.supportFragmentManager?.beginTransaction()?.replace(R.id.manager_nav_frame,managerAnnouncementFragment)?.addToBackStack(null)?.commit()

        }
        announcementlist_recyclerview.adapter = listAdapter


        val lm = LinearLayoutManager(requireContext())
        announcementlist_recyclerview.layoutManager = lm
        announcementlist_recyclerview.setHasFixedSize(true)


        fragment_announcement_news.setOnClickListener{
            var intent =
                Intent(Intent.ACTION_VIEW, Uri.parse("https://www.news1.kr/articles/?4386702"))
            startActivity(intent)

        }

        announcementlist_writeButton.setOnClickListener {
            val intent = Intent(getActivity(), CreateAnnouncementActivity::class.java)
            startActivity(intent)
        }




    }


    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState:Bundle?): View?{
        val view=inflater.inflate(R.layout.fragment_manager_announcement_list,container,false)
        return view
    }
}