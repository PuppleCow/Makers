package com.pupplecow.myapplication.temporaryStorage

import android.content.DialogInterface
import android.content.Intent
import android.net.Uri
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.app.AlertDialog
import androidx.core.view.isInvisible
import com.pupplecow.myapplication.R
import com.pupplecow.myapplication.ui.home.MyComplaintListFragment
import kotlinx.android.synthetic.main.fragment_my_complaint.*


class MyComplaintFragment:Fragment() {
    private lateinit var complaintFragment: ComplaintFragment
    private lateinit var myComplaintListFragment: MyComplaintListFragment

    companion object {
        fun newInstance(): MyComplaintFragment {
            return MyComplaintFragment()
        }
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)


        //산업안전 뉴스 제목,링크 불러오기
        mycomplaint_text_news.text="뉴스 제목입니다."

        //사진 서버에서 가져오기
        //이미지 가져오기(있을때 없을때 구분)
        if(true) {
            //MyComplaint_imageView.setImageResource(0)
        }
        else{
            MyComplaint_imageView.isInvisible=true
        }

        mycomplaint_text_news.setOnClickListener {
            var intent =
                Intent(Intent.ACTION_VIEW, Uri.parse("https://www.news1.kr/articles/?4386702"))
            startActivity(intent)
        }

        //서버에서 내용받아오기
        MyComplaint_text_title.text="민원제목입니다."
        MyComplaint_text_content.text="민원내용입니다."

        //삭제버튼
        MyComplaint_button_delete.setOnClickListener {
            //민원삭제 다이얼로그
            val builder= AlertDialog.Builder(requireContext())
            builder.setTitle("민원삭제")
            builder.setMessage("민원내용을 삭제하시겠습니까?")
            var listener = object : DialogInterface.OnClickListener {
                override fun onClick(p0: DialogInterface?, p1: Int) {
                    when (p1) {
                        //"네" 눌렀을때
                        DialogInterface.BUTTON_POSITIVE -> {

                            //서버에서 민원삭제


                            //다음페이지로 넘어가기
                            //민원 목록페이지로 넘어가기
                            myComplaintListFragment= MyComplaintListFragment.newInstance()
                            val transaction=activity?.supportFragmentManager?.beginTransaction()?.replace(R.id.main_nav_frame,myComplaintListFragment)?.addToBackStack(null)?.commit()
                            //activity?.supportFragmentManager?.beginTransaction()?.remove(requireParentFragment())?.commit();

                        }

                    }
                }
        }
            builder.setNegativeButton("아니오",listener)
            builder.setPositiveButton("네",listener)
            builder.show()
        }

        //수정버튼
        MyComplaint_button_edit.setOnClickListener {
            //민원삭제 다이얼로그
            val builder= AlertDialog.Builder(requireContext())
            builder.setTitle("민원수정")
            builder.setMessage("민원내용을 수정하시겠습니까?")
            var listener = object : DialogInterface.OnClickListener {
                override fun onClick(p0: DialogInterface?, p1: Int) {
                    when (p1) {
                        //"네" 눌렀을때
                        DialogInterface.BUTTON_POSITIVE -> {


                            //다음페이지로 넘어가기
                            //민원작성페이지로 넘어가기
                            activity?.supportFragmentManager?.beginTransaction()?.remove(requireParentFragment())?.commit()
                            activity?.supportFragmentManager?.popBackStack()
                        }

                    }
                }
            }
            builder.setNegativeButton("아니오",listener)
            builder.setPositiveButton("네",listener)
            builder.show()
        }

        //목록버튼
        MyComplaint_button_list.setOnClickListener {
            //목록페이지로 넘어가기
            //myComplaintListFragment= MyComplaintListFragment.newInstance()
            activity?.supportFragmentManager?.beginTransaction()?.remove(this)?.commit()
            activity?.supportFragmentManager?.popBackStack()

           // val transaction=activity?.supportFragmentManager?.beginTransaction()?.replace(R.id.main_nav_frame,myComplaintListFragment)?.addToBackStack(null)?.commit()
            //val transaction=activity?.supportFragmentManager?.beginTransaction()?.replace(R.id.main_nav_frame,myComplaintListFragment)?.addToBackStack(null)?.commit()

        }

    }





    override fun onCreateView(inflater: LayoutInflater,container:ViewGroup?,savedInstanceState:Bundle?): View?{
        val view=inflater.inflate(R.layout.fragment_my_complaint,container,false)
        return view
    }



}


