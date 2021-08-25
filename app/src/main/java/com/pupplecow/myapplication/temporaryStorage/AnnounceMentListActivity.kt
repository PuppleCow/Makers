
package com.pupplecow.myapplication.temporaryStorage

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.database.DatabaseReference
import com.pupplecow.myapplication.R
import com.pupplecow.myapplication.ui.announcement.AnnouncementListAdapterActivity
import kotlinx.android.synthetic.main.activity_announce_ment_list.*

class AnnounceMentListActivity : AppCompatActivity() {
    //순서대로 날짜, 공지 제목, 필독 유무

    private lateinit var database: DatabaseReference
    private lateinit var auth: FirebaseAuth

    var AnnouncementList= arrayListOf<AnnounceMentList>(
        AnnounceMentList("5/10", "공지1", "필독" ),
        AnnounceMentList("5/12", "공지2", "필독" ),
        AnnounceMentList("5/13", "공지3", "" ),
        AnnounceMentList("5/14", "공지4", "" ),
        AnnounceMentList("5/15", "공지5", ""),
        AnnounceMentList("5/16", "공지6", ""),
        AnnounceMentList("5/17", "공지7", "필독")

    )


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_announce_ment_list)

        val listAdapter = AnnouncementListAdapterActivity(this){

        }
        announcementlist_recyclerview2.adapter = listAdapter


        val lm = LinearLayoutManager(this)
        announcementlist_recyclerview2.layoutManager = lm
        announcementlist_recyclerview2.setHasFixedSize(true)
    }


}

