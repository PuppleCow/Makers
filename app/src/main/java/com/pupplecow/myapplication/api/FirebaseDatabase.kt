package com.pupplecow.myapplication.api

import com.google.firebase.database.DataSnapshot
import com.google.firebase.database.DatabaseError
import com.google.firebase.database.ValueEventListener
import com.google.firebase.database.ktx.database
import com.google.firebase.ktx.Firebase
import com.pupplecow.myapplication.data.UserData

class FirebaseDatabase :Contract.firebaseDatabase {
    val db=Firebase.database.reference  //루트가져옴

    //유저 데이터 가져오기
    override fun getUserData(uid: String, callback: (Boolean, UserData?) -> Unit) {
       //루트 안에
        db.child("users")
            .child(uid)
            .addListenerForSingleValueEvent(object : ValueEventListener{
                override fun onDataChange(snapshot: DataSnapshot) {
                    callback(true,snapshot.getValue(UserData::class.java))
                }

                override fun onCancelled(error: DatabaseError) {
                    //접근권한없을떄 ㅈ데이터 없을떄등 실패 했을 떄
                    callback(false,UserData().apply { this.uid=error.message.toString() })
                }

            })
    }

    override fun getUserData(data: UserData, callback: (Boolean, String) -> Unit) {
        TODO("Not yet implemented")
    }

    override fun updatePhoneNumber(
        uid: String,
        phonenumber: Int,
        callback: (Boolean, String) -> Unit
    ) {
        TODO("Not yet implemented")
    }

}