package com.pupplecow.myapplication.temporaryStorage

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ArrayAdapter
import androidx.appcompat.app.AlertDialog
import androidx.recyclerview.widget.LinearLayoutManager
import com.pupplecow.myapplication.R
import com.pupplecow.myapplication.ui.manager.home.ManagerWorkerInfoFragment
import com.pupplecow.myapplication.ui.manager.home.workersStatus
import com.pupplecow.myapplication.ui.manager.home.workersStatusListAdapter
import kotlinx.android.synthetic.main.activity_workers_status.*

class WorkersStatusActivity : AppCompatActivity() {
    //민원항목
    val groupData= arrayOf("근무자그룹선택","모든 작업자","A","B","기타")

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
        setContentView(R.layout.activity_workers_status)

        //민원항목 선택 스피너

        val workerGroupAdapter = ArrayAdapter(this,android.R.layout.simple_spinner_item,groupData)
        workerGroupAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
        workers_status_spinner_workers_group1.adapter= workerGroupAdapter

        //근무자 그룹선택후 조회하기 버튼 클릭
        workers_status_spinner_button_check1.setOnClickListener {
            val workersGruop =
                groupData[workers_status_spinner_workers_group1.selectedItemPosition]


            if(workersGruop=="근무자그룹선택"){
                val builder= AlertDialog.Builder(this)
                builder.setTitle("")
                builder.setMessage("근무자 그룹을 선택해주세요")
                builder.setPositiveButton("네",null)
                builder.show()
            }
            else{
                workers_status_text_member1.text="${workersGruop}의 근무인원"

                //해당 팀에서 일하는 근무인원정보 받아와서 표시
                workers_status_text_member_number1.text="명이 근무중입니다."


                //해당 팀에서 일하는 근무인원 이름 전화번호 시작시간 종료시간 관리자여부 서버에서 받아오기

                val workersAdapter= workersStatusListAdapter(this,workersList){
                        worker->

                }
                workers_status_recyclerview1.adapter=workersAdapter

                val lm = LinearLayoutManager(this)
                workers_status_recyclerview1.layoutManager = lm
                workers_status_recyclerview1.setHasFixedSize(true)






            }

        }


    }
}