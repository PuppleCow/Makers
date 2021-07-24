package com.pupplecow.myapplication

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import android.widget.ImageView
import android.widget.TextView

class workersStatusListAdapter(val context:Context,val workersList:ArrayList<workersStatus>):BaseAdapter() {
    override fun getCount(): Int {
        return workersList.size
    }

    override fun getItem(position: Int): Any {
        return workersList[position]
    }

    override fun getItemId(position: Int): Long {
        return 0
    }

    override fun getView(position: Int, convertView: View?, parent: ViewGroup?): View {
/* LayoutInflater는 item을 Adapter에서 사용할 View로 부풀려주는(inflate) 역할을 한다. */
        val view: View = LayoutInflater.from(context).inflate(R.layout.workers_status_item, null)

        /* 위에서 생성된 view를 res-layout-main_lv_item.xml 파일의 각 View와 연결하는 과정이다. */
        val workersName = view.findViewById<TextView>(R.id.workers_status_text_name)
        val workersPhoneNum = view.findViewById<TextView>(R.id.workers_status_text_phNum)
        val workersStartTime = view.findViewById<TextView>(R.id.workers_status_text_startT)
        val workersFinishTime= view.findViewById<TextView>(R.id.workers_status_text_finishT)
        val workersmanager= view.findViewById<TextView>(R.id.workers_status_text_manager)

        /* ArrayList<Dog>의 변수 dog의 이미지와 데이터를 ImageView와 TextView에 담는다. */
        val worker=workersList[position]
        //val resourceId = context.resources.getIdentifier(dog.photo, "drawable", context.packageName)
        //dogPhoto.setImageResource(resourceId)
        workersName.text=worker.workerName
        workersPhoneNum.text=worker.phoneNumber
        workersStartTime.text=worker.startTime
        workersFinishTime.text=worker.finishTime
        workersmanager.text=worker.manager


        return view
    }
}