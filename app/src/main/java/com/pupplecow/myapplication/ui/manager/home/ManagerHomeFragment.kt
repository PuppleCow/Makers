package com.pupplecow.myapplication.ui.manager.home

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.AdapterView
import android.widget.ArrayAdapter
import androidx.appcompat.app.AlertDialog
import androidx.core.view.isInvisible
import androidx.core.view.isVisible
import androidx.fragment.app.Fragment
import com.pupplecow.myapplication.R
import com.pupplecow.myapplication.temporaryStorage.ManagerWorkersStatusFragment
import com.pupplecow.myapplication.ui.manager.home.Complaint.ManagerComplaintListFragment
import com.pupplecow.myapplication.ui.manager.announcement.ManagerAnnouncementListFragment
import kotlinx.android.synthetic.main.activity_manage.*
import kotlinx.android.synthetic.main.fragment_manager_home.*


class ManagerHomeFragment:Fragment() {
    private lateinit var managerWorkersStatusFragment: ManagerWorkersStatusFragment
    private lateinit var managerComplaintListFragment: ManagerComplaintListFragment
    private lateinit var managerAnnouncementListFragment : ManagerAnnouncementListFragment
    val Manage_SelectGroup = arrayOf("긴급알림 그룹 선택","모든 그룹","인천항만 하역","인천항만 하역","인천항만 하역")
    //직접 쓰기-> 따로 페이지 이동해야 함.
    val Manage_SelectNotif = arrayOf("긴급알림 종류 선택","모든 작업 일시 중단","공지사항 필독","직접 쓰기")

    companion object {
        fun newInstance(): ManagerHomeFragment {
            return ManagerHomeFragment()
        }
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        //산업안전 뉴스 제목,링크 불러오기
        manager_home_text_news.text="뉴스 제목입니다."

        manager_home_text_news.setOnClickListener {
            var intent =
                Intent(Intent.ACTION_VIEW, Uri.parse("https://www.news1.kr/articles/?4386702"))
            startActivity(intent)
        }

        //긴급알림 그룹 선택 스피너
        val SelectGroupAdapter = ArrayAdapter(requireContext(),android.R.layout.simple_spinner_item,Manage_SelectGroup)
        SelectGroupAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
        manager_home_SelectGroupSp.adapter= SelectGroupAdapter

        //긴급알림 종류 선택 스피너
        val SelectNotifAdapter = ArrayAdapter(requireContext(),android.R.layout.simple_spinner_item,Manage_SelectNotif)
        SelectGroupAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
        manager_home_electNotifSp.adapter= SelectNotifAdapter

        //직접입력칸 안보이게 하기
        manager_home_editText.isInvisible=true
        //알림종류 선택 - 직접입력 선택 리스너
        manager_home_electNotifSp.onItemSelectedListener= object :AdapterView.OnItemSelectedListener {
            override fun onItemSelected( parent: AdapterView<*>?,view: View?,position: Int,id: Long ) {
                Manage_SelectNotif.get(position)?.let {
                    if (position==3)
                        manager_home_editText.isVisible=true
                    else
                        manager_home_editText.isInvisible=true
                }
            }

            override fun onNothingSelected(parent: AdapterView<*>?) {
                TODO("Not yet implemented")
            }


        }

        //긴급 알림 버튼
        manager_home_Emergency_button.setOnClickListener {
            //근무자 그룹
            val Manage_Group=Manage_SelectGroup[manage_SelectGroupSp.selectedItemPosition]
            //알림 종류 선택
            val Manage_Notif=Manage_SelectNotif[manage_SelectNotifSp.selectedItemPosition]

            if (Manage_Group == "긴급알림 그룹 선택") {
                val builder = AlertDialog.Builder(requireContext())
                builder.setMessage("근무자 그룹을 선택해주세요")
                builder.setPositiveButton("확인", null)
                builder.show()
            } else if (Manage_Notif == "긴급알림 종류 선택") {
                val builder = AlertDialog.Builder(requireContext())
                builder.setMessage("긴급 알림 메시지를 선택해주세요")
                builder.setPositiveButton("확인", null)
                builder.show()
            }

            else {

//                val manage_emergencyMessage=Manage_SelectNotif[manage_SelectNotifSp.selectedItemPosition]
//                val intent = Intent(this, EmergencyNoticeActivity::class.java)
//                intent.putExtra("긴급알림:",manage_emergencyMessage)
//                startActivity(intent)

            }



        }
        //근무자 현황 버튼
        manager_home_workerButton.setOnClickListener {
            //다음페이지로 넘어가기
            //WorkersStatusFragment로 넘어가기
            val intent = Intent(requireContext(), ManagerWorkersStatusActivity::class.java)
            startActivity(intent)
        }

        manager_home_complaint_list.setOnClickListener {
            //다음페이지로 넘어가기
            //ManagerComplaintListFragment로 넘어가기
            managerComplaintListFragment= ManagerComplaintListFragment.newInstance()
            val transaction=activity?.supportFragmentManager?.beginTransaction()?.replace(R.id.manager_nav_frame,managerComplaintListFragment)?.addToBackStack(null)?.commit()

        }

        //inner class SpListner: AdapterView.OnItemSele

    }


    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState:Bundle?): View?{
        val view=inflater.inflate(R.layout.fragment_manager_home,container,false)
        return view
    }




}


