package com.pupplecow.myapplication.ui.announcement

import android.content.DialogInterface
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.app.AlertDialog
import androidx.fragment.app.Fragment
import com.pupplecow.myapplication.R
import kotlinx.android.synthetic.main.activity_announcement.*

class AnnouncementFragment:Fragment() {
    private lateinit var createAnnounecementFragment:CreateAnnounecementFragment
    private lateinit var announcmentListFragment:AnnouncmentListFragment

    companion object {
        fun newInstance(): AnnouncementFragment {
            return AnnouncementFragment()
        }
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

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


        //수정버튼 누르면
        announcement_button_edit.setOnClickListener {
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
                            createAnnounecementFragment= CreateAnnounecementFragment.newInstance()
                            val transaction=activity?.supportFragmentManager?.beginTransaction()?.replace(R.id.main_nav_frame,createAnnounecementFragment)?.commit()

                        }

                    }
                }
            }
            builder.setNegativeButton("아니오",listener)
            builder.setPositiveButton("네",listener)
            builder.show()

        }




        //삭제버튼 누르면
        announcement_button_delete.setOnClickListener {
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
                            //AnnouncmentListFragment로 넘어가기
                            announcmentListFragment= AnnouncmentListFragment.newInstance()
                            val transaction=activity?.supportFragmentManager?.beginTransaction()?.replace(R.id.main_nav_frame,announcmentListFragment)?.commit()

                        }

                    }
                }
            }
            builder.setNegativeButton("아니오",listener)
            builder.setPositiveButton("네",listener)
            builder.show()
        }



        //목록버튼 누르면
        announcement_button_list.setOnClickListener {
            //공지사항 목록 페이지로 넘어가기
            //AnnouncmentListFragment로 넘어가기
            announcmentListFragment= AnnouncmentListFragment.newInstance()
            val transaction=activity?.supportFragmentManager?.beginTransaction()?.replace(R.id.main_nav_frame,announcmentListFragment)?.commit()

        }

    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View?{
        val view=inflater.inflate(R.layout.activity_announcement,container,false)

        return view
    }

}