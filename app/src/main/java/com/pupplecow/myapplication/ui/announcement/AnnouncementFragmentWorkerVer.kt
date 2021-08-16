package com.pupplecow.myapplication.ui.announcement

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.pupplecow.myapplication.R
import com.pupplecow.myapplication.temporaryStorage.CreateAnnounecementFragment
import kotlinx.android.synthetic.main.activity_announcement.*

class AnnouncementFragmentWorkerVer:Fragment() {
    private lateinit var createAnnounecementFragment: CreateAnnounecementFragment
    private lateinit var announcementListFragment:AnnouncementListFragment

    companion object {
        fun newInstance(): AnnouncementFragmentWorkerVer {
            return AnnouncementFragmentWorkerVer()
        }
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        announcement_button_edit.visibility = View.GONE
        announcement_button_delete.visibility = View.GONE


        //산업안전 뉴스 제목,링크 불러오기
        announcement_text_news.text="최신 뉴스입니다."

        announcement_text_news.setOnClickListener {
            var intent =
                Intent(Intent.ACTION_VIEW, Uri.parse("https://www.news1.kr/articles/?4386702"))
            startActivity(intent)
        }

        //제목,공지날짜 서버에서 가져오기
        announcement_text_title.text="5/10 공지입니다."

        //필독 체크 유무 서버에서 가져오기
        if(true) {
            announcement_text_must_read.text = "필독!!"
        }
        else{
            announcement_text_must_read.text = ""
        }
        //공지내용 서버에서 가져오기
        announcement_text_content.text="공지\n공지입니당\n공쥐\n팥쥐"







        //목록버튼
        announcement_button_list.setOnClickListener {
            //공지사항 목록 페이지로 넘어가기
            //AnnouncmentListFragment로 넘어가기
            //announcementListFragment= AnnouncementListFragment.newInstance()
            //val transaction=activity?.supportFragmentManager?.beginTransaction()?.replace(R.id.main_nav_frame,announcementListFragment)?.addToBackStack(null)?.commit()

            val transaction= activity?.supportFragmentManager?.beginTransaction()?.remove(this)?.commit()
            activity?.supportFragmentManager?.popBackStack()
        }

    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View?{
        val view=inflater.inflate(R.layout.activity_announcement,container,false)

        return view
    }

}