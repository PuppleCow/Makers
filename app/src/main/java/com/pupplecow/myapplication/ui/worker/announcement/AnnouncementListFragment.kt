package com.pupplecow.myapplication.ui.worker.announcement

import android.content.Intent
import android.content.res.ColorStateList
import android.graphics.Color
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.LinearLayout
import android.widget.Toast
import androidx.core.content.ContextCompat
import androidx.core.view.isVisible
import androidx.core.widget.addTextChangedListener
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import com.google.firebase.firestore.FirebaseFirestore
import com.google.firebase.firestore.ktx.firestore
import com.google.firebase.ktx.Firebase
import com.pupplecow.myapplication.Adapter.AnnouncementListAdapterActivity
import com.pupplecow.myapplication.Adapter.ComplaintListAdapter
import com.pupplecow.myapplication.R
import com.pupplecow.myapplication.data.Announcement
import com.pupplecow.myapplication.data.Complaint
import com.pupplecow.myapplication.databinding.FragmentManagerAnnouncementListBinding
import kotlinx.android.synthetic.main.fragment_manager_announcement_list.*


//근무자 위한 list 프래그먼트
class AnnouncementListFragment:Fragment() {

    private lateinit var binding: FragmentManagerAnnouncementListBinding

    private val db= Firebase.firestore
    private val announcementList:ArrayList<Announcement> = ArrayList()
    //private lateinit var announcementFragmentWorkerVer : AnnouncementFragmentWorkerVer





    companion object {
        fun newInstance(): AnnouncementListFragment {
            return AnnouncementListFragment()
        }
    }


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        //파이어스토어 인스턴그 초기화

        binding=FragmentManagerAnnouncementListBinding.inflate(layoutInflater)

        floatingActionButton.visibility=View.GONE


        val listAdapter = AnnouncementListAdapterActivity(requireContext()){
                Announcement->
            val intent = Intent(requireContext(), AnnouncementWorkerActivity::class.java)
//            intent.putExtra("DocumentID",Announcement.key)
            startActivity(intent)
            //announcementFragmentWorkerVer= AnnouncementFragmentWorkerVer.newInstance()
            //val transaction = activity?.supportFragmentManager?.beginTransaction()?.replace(R.id.main_nav_frame,announcementFragmentWorkerVer)?.addToBackStack(null)?.commit()

        }

        binding.announcementlistRecyclerview.adapter = listAdapter


//        val lm = LinearLayout(this)
//        binding.announcementlistRecyclerview.layoutManager = lm
        binding.announcementlistRecyclerview.setHasFixedSize(true)

//        binding.A.addTextChangedListener {
//            //글자 바뀔떄마다
//            binding.searchClearIv.isVisible = it.toString().isNotEmpty()
//
//            if(it.toString().isEmpty()){
//                loadData()
//            }
//            if(it.toString().length>=2){
//                binding.searchBtn.backgroundTintList =
//                    ColorStateList.valueOf(ContextCompat.getColor(this,R.color.main_color))
//                //실시간검색
//                //search()
//            }
//            else{
//                binding.searchBtn.backgroundTintList=
//                    ColorStateList.valueOf(Color.parseColor("#bbbbbb"))
//            }
//        }

    }

    override fun onResume() {
        super.onResume()
        loadData()
    }

    private fun loadData() {
        db.collection("ANNOUNCEMENT")
            //.whereEqualTo("writerName", "최지혜")  //조건 추가 가능
            .get()
            .addOnSuccessListener { documents ->
                announcementList.clear()
                for (document in documents) {
                    Log.e("ANNOUNCEMENT", "${document.id} => ${document.data}")
                    val data=document.toObject(Complaint::class.java)
                    data.key=document.id
//                    announcementList.add(data)
                }
                (binding.announcementlistRecyclerview.adapter as AnnouncementListAdapterActivity).setDatas(announcementList)
            }
            .addOnFailureListener { exception ->
                Log.w("", "Error getting documents: ", exception)
            }
    }

    fun onClick(view: View) {
//        when(view){
//            binding.searchBtn->{
//                search()
//            }
//            binding.searchClearIv->{
//                binding.searchEt.setText("")
//                loadData()
//            }
//        }
    }

//    private fun search() {
//        if(binding.searchEt.text.toString().length<2){
//            Toast.makeText(this,"검색어는 최소 2자 이상입니다", Toast.LENGTH_SHORT).show()
//        }
//        db.collection("Announcement")
//            //.whereEqualTo("writerName", "최지혜")  //조건 추가 가능
//            .get()
//            .addOnSuccessListener { documents ->
//                announcementList.clear()
//                for (document in documents) {
//                    Log.e("ANNOUNCEMENT", "${document.id} => ${document.data}")
//                    val data=document.toObject(Announcement::class.java)
//                    data.key=document.id
//
//                    //검색어 포함하고 있으면
//                    if(data.title.trim().contains(binding.searchEt.text.toString().trim())
//                        ||data.body.trim().contains(binding.searchEt.toString().trim())
//
//                    ){
//                        announcementList.add(data)
//
//                    }
//
//
//
//                }
//                (binding.announcementlistRecyclerview.adapter as AnnouncementListAdapterActivity).setDatas(announcementList)
//            }
//            .addOnFailureListener { exception ->
//                Log.w("", "Error getting documents: ", exception)
//            }
//    }
//



    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState:Bundle?): View?{
        val view=inflater.inflate(R.layout.fragment_manager_announcement_list,container,false)
        return view
    }


}