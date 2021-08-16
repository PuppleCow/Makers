package com.pupplecow.myapplication.temporaryStorage

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import androidx.appcompat.app.AlertDialog
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import com.pupplecow.myapplication.R
import com.pupplecow.myapplication.ui.manager.home.workersStatus
import com.pupplecow.myapplication.ui.manager.home.workersStatusListAdapter
import kotlinx.android.synthetic.main.fragment_manager_workers_status.*

class ManagerWorkersStatusFragment:Fragment() {
    private lateinit var managerWorkerInfoFragment: ManagerWorkerInfoFragment
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
    companion object {
        fun newInstance(): ManagerWorkersStatusFragment {
            return ManagerWorkersStatusFragment()
        }
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        //산업안전 뉴스 제목,링크 불러오기
        workers_status_text_news.text="뉴스 제목입니다."

        workers_status_text_news.setOnClickListener {
            var intent =
                Intent(Intent.ACTION_VIEW, Uri.parse("https://www.news1.kr/articles/?4386702"))
            startActivity(intent)
        }



        //민원항목 선택 스피너

        val workerGroupAdapter = ArrayAdapter(requireContext(), android.R.layout.simple_spinner_item, groupData)
        workerGroupAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
        workers_status_spinner_workers_group.adapter = workerGroupAdapter


        val workersAdapter = workersStatusListAdapter(requireContext(), workersList){
                worker->
            //다음페이지로 넘어가기
            //ManagerWorkerInfoFragment로 넘어가기
            managerWorkerInfoFragment= ManagerWorkerInfoFragment.newInstance()
            val transaction=activity?.supportFragmentManager?.beginTransaction()?.replace(R.id.manager_nav_frame,managerWorkerInfoFragment)?.addToBackStack(null)?.commit()

        }
        //근무자 그룹선택후 조회하기 버튼 클릭
        workers_status_spinner_button_check.setOnClickListener {
            val workersGruop =
                groupData[workers_status_spinner_workers_group.selectedItemPosition]


            if (workersGruop == "근무자그룹선택") {
                val builder = AlertDialog.Builder(requireContext())
                builder.setTitle("")
                builder.setMessage("근무자 그룹을 선택해주세요")
                builder.setPositiveButton("네", null)
                builder.show()
            } else {
                workers_status_text_member.text = "${workersGruop}의 근무인원"

                //해당 팀에서 일하는 근무인원정보 받아와서 표시
                workers_status_text_member_number.text = "명이 근무중입니다."


                //해당 팀에서 일하는 근무인원 이름 전화번호 시작시간 종료시간 관리자여부 서버에서 받아오기

                val workersAdapter = workersStatusListAdapter(requireContext(), workersList){
                        worker->
                    //다음페이지로 넘어가기
                    //ManagerWorkerInfoFragment로 넘어가기
                    managerWorkerInfoFragment= ManagerWorkerInfoFragment.newInstance()
                    val transaction=activity?.supportFragmentManager?.beginTransaction()?.replace(R.id.manager_nav_frame,managerWorkerInfoFragment)?.addToBackStack(null)?.commit()

                }
                workers_status_recyclerview.adapter = workersAdapter

                val lm = LinearLayoutManager(requireContext())
                workers_status_recyclerview.layoutManager = lm
                workers_status_recyclerview.setHasFixedSize(true)


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


    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState:Bundle?): View?{
        val view=inflater.inflate(R.layout.fragment_manager_workers_status,container,false)
        return view
    }


}



