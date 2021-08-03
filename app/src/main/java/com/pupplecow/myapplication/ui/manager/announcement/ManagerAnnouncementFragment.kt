package com.pupplecow.myapplication.ui.manager.announcement

import android.content.DialogInterface
import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.app.AlertDialog
import androidx.fragment.app.Fragment
import com.pupplecow.myapplication.R
import com.pupplecow.myapplication.ui.announcement.CreateAnnounecementFragment
import kotlinx.android.synthetic.main.fragment_manager_announcement.*

class ManagerAnnouncementFragment:Fragment() {
    private lateinit var managerCreateAnnouncementFragment:ManagerCreateAnnouncementFragment
    private lateinit var managerAnnouncementListFragment:ManagerAnnouncementListFragment
    companion object {
        fun newInstance(): ManagerAnnouncementFragment {
            return ManagerAnnouncementFragment()
        }
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        //산업안전 뉴스 제목,링크 불러오기
        manager_announcement_text_news.text="뉴스 제목입니다."

        manager_announcement_text_news.setOnClickListener {
            var intent =
                Intent(Intent.ACTION_VIEW, Uri.parse("https://www.news1.kr/articles/?4386702"))
            startActivity(intent)
        }

        //제목,공지날짜 서버에서 가져오기
        manager_announcement_text_title.text="5/10 공지입니다."

        //필독 체크 유무 서버에서 가져오기
        if(true) {
            manager_announcement_text_must_read.text = "필독!!"
        }
        else{
            manager_announcement_text_must_read.text = ""
        }
        //공지내용 서버에서 가져오기
        manager_announcement_text_content.text="공지\n공지입니당\n공쥐\n팥쥐"


        //수정버튼 누르면
        manager_announcement_button_edit.setOnClickListener {
            //다이얼로그
            val builder= AlertDialog.Builder(requireContext())
            builder.setTitle("")
            builder.setMessage("해당 공지를 수정하시겠습니까?")
            var listener = object : DialogInterface.OnClickListener {
                override fun onClick(p0: DialogInterface?, p1: Int) {
                    when (p1) {
                        //"네" 눌렀을때
                        DialogInterface.BUTTON_POSITIVE -> {
                            //예누르면 공지사항 작성페이지로 이동 --> 수정공지사항은 입력되어있어야함
                            //CreateAnnounecementFragment로 넘어가기
                            managerCreateAnnouncementFragment= ManagerCreateAnnouncementFragment.newInstance()
                            val transaction=activity?.supportFragmentManager?.beginTransaction()?.replace(R.id.manager_nav_frame,managerCreateAnnouncementFragment)?.addToBackStack(null)?.commit()

                        }

                    }
                }
            }
            builder.setNegativeButton("아니오",listener)
            builder.setPositiveButton("네",listener)
            builder.show()

        }




        //삭제버튼 누르면
        manager_announcement_button_delete.setOnClickListener {
            //다이얼로그
            val builder= AlertDialog.Builder(requireContext())
            builder.setTitle("")
            builder.setMessage("해당 공지를 삭제하시겠습니까?")
            var listener = object : DialogInterface.OnClickListener {
                override fun onClick(p0: DialogInterface?, p1: Int) {
                    when (p1) {
                        //"네" 눌렀을때
                        DialogInterface.BUTTON_POSITIVE -> {

                            //해당 공지 서버에서 삭제하기


                            //공지사항 목록 페이지로 넘어가기
                            //ManagerAnnouncementListFragmentt로 넘어가기
                            managerAnnouncementListFragment= ManagerAnnouncementListFragment.newInstance()
                            val transaction=activity?.supportFragmentManager?.beginTransaction()?.replace(R.id.manager_nav_frame,managerAnnouncementListFragment)?.addToBackStack(null)?.commit()

                        }

                    }
                }
            }
            builder.setNegativeButton("아니오",listener)
            builder.setPositiveButton("네",listener)
            builder.show()
        }
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState:Bundle?): View?{
        val view=inflater.inflate(R.layout.fragment_manager_announcement,container,false)
        return view
    }
}