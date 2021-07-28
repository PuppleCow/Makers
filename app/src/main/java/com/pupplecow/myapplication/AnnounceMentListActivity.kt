package com.pupplecow.myapplication

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.activity_announce_ment_list.*
import kotlinx.android.synthetic.main.activity_announce_ment_list.view.*
import kotlinx.android.synthetic.main.activity_announcement.*
import kotlinx.android.synthetic.main.activity_home1.*
import kotlinx.android.synthetic.main.row.view.*

class AnnounceMentListActivity : AppCompatActivity() {
    //순서대로 날짜, 공지 제목, 필독 유무




    var AnnouncementList= arrayListOf<AnnounceMentListActivity2>(
        AnnounceMentListActivity2("5/10", "공지1", "필독" ),
        AnnounceMentListActivity2("5/12", "공지2", "필독" ),
        AnnounceMentListActivity2("5/13", "공지3", "" ),
        AnnounceMentListActivity2("5/14", "공지4", "" ),
        AnnounceMentListActivity2("5/15", "공지5", ""),
        AnnounceMentListActivity2("5/16", "공지6", ""),
        AnnounceMentListActivity2("5/17", "공지7", "필독")

    )


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_announce_ment_list)

        val listAdapter = AnnouncementListAdapterActivity(this, AnnouncementList)
        announcementlist_recyclerview.adapter = listAdapter


        val lm = LinearLayoutManager(this)
        announcementlist_recyclerview.layoutManager = lm
        announcementlist_recyclerview.setHasFixedSize(true)
    }


    //============================================================위에가 recyclerview 새로운 방법(안되면 listview하기...)

/*

    var AnnouncementList=arrayOf("공지1","공지2","공지3")



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_announce_ment_list)
        //공지사항 작성 시 공지 제목에 날짜와 필독 유무 가져오기

        //일단은 날짜는 지금 날짜로 출력하자(아닌가..?바로 할 수 있나?)
        //필독도 그러면 가져오자 공지사항 작성글에서!
        //AnnouncementActivity에서 이거(annountcement_text_title)를 text로 저장해줘
        //val announcement_text_title=intent.getIntExtra(announcement_text_title)


        /*
        val essential = intent.getIntExtra("필독")

        */
        //제목 불러오면 됨

        val adapter1=RecyclerAdapter()
        recycler1.adapter =adapter1


    }


        inner class RecyclerAdapter:RecyclerView.Adapter<RecyclerAdapter.ViewHolderClass>(){
            override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerAdapter.ViewHolderClass {
                val itemView = LayoutInflater.inflate(R.layout.row,null)
                val holder = ViewHolderClass(itemView)

                return holder
        }

            override fun onBindViewHolder(holder: ViewHolderClass, position: Int) {
                holder.list.text=AnnouncementList[position]
            }

        inner class ViewHolderClass(itemView: View) : RecyclerView.ViewHolder(itemView){
            //항목 view 내부의 view객체의 주소를 담는다.
            val list=itemView.announce__list_textview
        }
    }


*/
}