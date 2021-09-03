package com.pupplecow.myapplication.ui.home.complaint

import android.content.DialogInterface
import android.content.Intent
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AlertDialog
import androidx.core.view.isInvisible
import com.pupplecow.myapplication.R
import kotlinx.android.synthetic.main.fragment_my_complaint.*

class MyComplaintActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_my_complaint)
//산업안전 뉴스 제목,링크 불러오기
        //mycomplaint_text_news.text="뉴스 제목입니다."
        //val data = intent.getSerializableExtra("uid")
        //사진 서버에서 가져오기
        //이미지 가져오기(있을때 없을때 구분)
        if(true) {
            //MyComplaint_imageView.setImageResource(0)
        }
        else{
            MyComplaint_imageView.visibility= View.VISIBLE
        }

//        mycomplaint_text_news.setOnClickListener {
//            var intent =
//                Intent(Intent.ACTION_VIEW, Uri.parse("https://www.news1.kr/articles/?4386702"))
//            startActivity(intent)
//        }

        //서버에서 내용받아오기
        MyComplaint_text_title.text="민원제목입니다."
        MyComplaint_text_content.text="민원내용입니다."

        //삭제버튼
        MyComplaint_button_delete.setOnClickListener {
            //민원삭제 다이얼로그
            val builder= AlertDialog.Builder(this)
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
                           finish()
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
            val builder= AlertDialog.Builder(this)
            builder.setTitle("민원수정")
            builder.setMessage("민원내용을 수정하시겠습니까?")
            var listener = DialogInterface.OnClickListener { p0, p1 ->
                when (p1) {
                    //"네" 눌렀을때
                    DialogInterface.BUTTON_POSITIVE -> {


                        //다음페이지로 넘어가기
                        //민원작성페이지로 넘어가기
                        val intent = Intent(this@MyComplaintActivity, ComplaintListActivity::class.java)
                        startActivity(intent)
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
            finish()

        }



    }
}