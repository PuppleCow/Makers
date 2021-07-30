package com.pupplecow.myapplication.temporaryStorage

import android.content.DialogInterface
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AlertDialog
import com.pupplecow.myapplication.databinding.ActivitySettingMyInformationSettingBinding
import com.pupplecow.myapplication.temporaryStorage.HomeActivity1

class SettingMyInformationSettingActivity : AppCompatActivity() {

    private lateinit var binding: ActivitySettingMyInformationSettingBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivitySettingMyInformationSettingBinding.inflate(layoutInflater)
        setContentView(binding.root)

        // 내 정보 저장
        binding.setting2Button1.setOnClickListener {
            val t1 = Toast.makeText(this, "정보가 저장되었습니다", Toast.LENGTH_SHORT)
            t1.show()
        }

        // 회원탈퇴
        binding.setting2Button2.setOnClickListener {
            val builder = AlertDialog.Builder(this)
            builder.setTitle("회원탈퇴 하시겠습니까?")
            builder.setMessage("※ 탈퇴하시면 기존 정보는 초기화됩니다. ※")

            val listener = object : DialogInterface.OnClickListener {
                override fun onClick(dialog: DialogInterface?, which: Int) {
                    when (which) {

                        // '예' 버튼 눌렀을 때
                        DialogInterface.BUTTON_NEGATIVE -> {
                            val builder =
                                AlertDialog.Builder(this@SettingMyInformationSettingActivity)
                            builder.setTitle("정상적으로 회원탈퇴 되었습니다.")
                            builder.setMessage("지금까지 이용해주셔서 감사합니다")
                            builder.setPositiveButton("확인") { dialogInterface: DialogInterface, i: Int ->

                                // '확인' 버튼 누르면 '홈'으로 이동
                            }
                            builder.show()
                        }
                    }
                }
            }

            builder.setPositiveButton("아니요", listener)
            builder.setNegativeButton("예", listener)
            builder.show()

        }

        // 로그아웃
        binding.setting2Button3.setOnClickListener {
            val builder = AlertDialog.Builder(this)
            builder.setTitle("")
            builder.setMessage("로그아웃 하시겠습니까?")

            val listener = object : DialogInterface.OnClickListener {
                override fun onClick(dialog: DialogInterface?, which: Int) {
                    when (which) {

                        // '예' 버튼 눌렀을 때
                        DialogInterface.BUTTON_NEGATIVE -> {
                            val builder1 =
                                AlertDialog.Builder(this@SettingMyInformationSettingActivity,)
                            builder1.setTitle("정상적으로 로그아웃 되었습니다.")
                            builder1.setMessage("메인화면으로 돌아갑니다")
                            builder1.setPositiveButton("확인") { dialogInterface: DialogInterface, i: Int ->

                                // '확인' 버튼 누르면 '작업장(홈)'으로 이동
                                val home_intent=Intent(this@SettingMyInformationSettingActivity,
                                    HomeActivity1::class.java)
                                startActivity(home_intent)

                            }
                            builder1.show()
                        }
                    }
                }
            }

            builder.setPositiveButton("아니요", null)
            builder.setNegativeButton("예", listener)
            builder.show()
        }
    }
}
