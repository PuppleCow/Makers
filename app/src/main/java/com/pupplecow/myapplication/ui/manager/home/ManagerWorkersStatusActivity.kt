package com.pupplecow.myapplication.ui.manager.home

import android.content.Intent
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ArrayAdapter
import androidx.appcompat.app.AlertDialog
import androidx.recyclerview.widget.LinearLayoutManager
import com.pupplecow.myapplication.R
import com.pupplecow.myapplication.databinding.ActivityManagerWorkersStatusBinding
import kotlinx.android.synthetic.main.activity_manager_workers_status.*

class ManagerWorkersStatusActivity : AppCompatActivity() {
    private lateinit var binding: ActivityManagerWorkersStatusBinding

    //민원항목
    val groupData= arrayOf("근무자그룹선택","모든 작업자","인천항만 하역","인천항만 하역","기타")

    //리스트뷰에 들어갈 작업자 목록
    var workersList = arrayListOf<workersStatus>(
        workersStatus("이름","승인","시작시간","종료시간","휴대폰번호","관리자 여부"),
        workersStatus("홍길동","미승인","01:01","00:00","010-1234-5789","관리자"),
        workersStatus("김길동","승인","01:01","00:00","010-1234-5789",""),
        workersStatus("이길동","미승인","01:01","00:00","010-1234-5789",""),
        workersStatus("최길동","승인","01:01","00:00","010-1234-5789",""),
        workersStatus("홍길동","미승인","01:01","00:00","010-1234-5789",""),
    )

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_manager_workers_status)
        binding= ActivityManagerWorkersStatusBinding.inflate(layoutInflater)
        setContentView(binding.root)

        //산업안전 뉴스 제목,링크 불러오기
        binding.workersStatusTextNews.text="뉴스 제목입니다"

        binding.workersStatusTextNews.setOnClickListener {
            var intent =
                Intent(Intent.ACTION_VIEW, Uri.parse("https://www.news1.kr/articles/?4386702"))
            startActivity(intent)
        }



        //민원항목 선택 스피너

        val workerGroupAdapter = ArrayAdapter(this, android.R.layout.simple_spinner_item, groupData)
        workerGroupAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
        binding.workersStatusSpinnerWorkersGroup.adapter = workerGroupAdapter



        val workersAdapter = workersStatusListAdapter(this, workersList){
                worker->
            //다음페이지로 넘어가기
            //ManagerWorkerInfoFragment로 넘어가기
            val intent = Intent(this,ManagerWorkerInfoActivity::class.java)
            startActivity(intent)
        }
        //근무자 그룹선택후 조회하기 버튼 클릭
        binding.workersStatusSpinnerButtonCheck.setOnClickListener {
            val workersGruop =
                groupData[binding.workersStatusSpinnerWorkersGroup.selectedItemPosition]


            if (workersGruop == "근무자그룹선택") {
                val builder = AlertDialog.Builder(this)
                builder.setTitle("")
                builder.setMessage("근무자 그룹을 선택해주세요")
                builder.setPositiveButton("네", null)
                builder.show()
            } else {
                binding.workersStatusTextMember.text = "${workersGruop}의 근무인원"


                //해당 팀에서 일하는 근무인원정보 받아와서 표시
                binding.workersStatusTextMemberNumber.text = "명이 근무중입니다."


                //해당 팀에서 일하는 근무인원 이름 전화번호 시작시간 종료시간 관리자여부 서버에서 받아오기

                val workersAdapter = workersStatusListAdapter(this, workersList){
                        worker->
                    //다음페이지로 넘어가기
                    //ManagerWorkerInfoFragment로 넘어가기
                    val intent = Intent(this, ManagerWorkerInfoActivity::class.java)
                    startActivity(intent)
                }
                binding.workersStatusRecyclerview.adapter = workersAdapter


                val lm = LinearLayoutManager(this)
                binding.workersStatusRecyclerview.layoutManager = lm
                binding.workersStatusRecyclerview.setHasFixedSize(true)


            }



        }


        //전체선택 버튼
//        workers_status_toggleButton.setOnClickListener {
//            val cnt=workersList.size
//            if(workers_status_toggleButton.isChecked==true) {
//                setChe
////                for (i in 0..cnt){
////                    //workers_status_checkbox.isChecked=true
////                    val cnt: Int =workers_status_recyclerview.adapter!!.itemCount
////                        //workersAdapter.getCount() //리스트뷰에 올라가있는 리스트 개수 구하기
////                    for (i in 0 until cnt) {
////                        workers_status_recyclerview.(i, true)
////                    }
//                    notifyDataSetChanged()
////
////                }
//                //workerGroupAdapter.setCheckAll(false)
//
//
//            }
//            else{
//                //workerGroupAdapter.setCheckAll(boolean = true)
//                for (i in 0..cnt){
//                    workers_status_checkbox.isChecked=false
//                }
//            }
//            //val cnt=workersStatusListAdapter.getItemCount()
//
//
//
//        }

        //승인하기 버튼
        workers_status_button_confirm.setOnClickListener {

            //체크 되어있는 근무자 미승인->승인으로 바꾸기
        }
    }

    }