package com.pupplecow.myapplication.api

import com.pupplecow.myapplication.data.UserData

//파베데에서 쓸수있는 함수를 제약해놓음
interface Contract {
    interface firebaseDatabase{
        fun getUserData(uid:String,callback:(Boolean,UserData?)->Unit)
        fun getUserData(data:UserData,callback: (Boolean, String) -> Unit)
        fun updatePhoneNumber(uid:String,phonenumber:Int,callback: (Boolean, String) -> Unit)
    }
}