package com.pupplecow.myapplication

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.MenuItem
import com.google.android.material.bottomnavigation.BottomNavigationView
import com.pupplecow.myapplication.ui.announcement.AnnouncementListFragment
import com.pupplecow.myapplication.ui.complaint.ComplaintFragment
import com.pupplecow.myapplication.ui.home.HomeFragment
import com.pupplecow.myapplication.ui.settings.SettingsFragment
import kotlinx.android.synthetic.main.activity_main_nav.*


@Suppress("DEPRECATION")
class MainNavActivity : AppCompatActivity(), BottomNavigationView.OnNavigationItemSelectedListener{

    private lateinit var homeFragment: HomeFragment
    private lateinit var complaintFragment: ComplaintFragment
    private lateinit var announcementListFragment: AnnouncementListFragment
    private lateinit var settingsFragment: SettingsFragment

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main_nav)

        main_nav_bottom_van_bar.setOnNavigationItemSelectedListener(this)
        main_nav_bottom_van_bar.selectedItemId=R.id.navbar_home
    }


    override fun onNavigationItemSelected(item: MenuItem): Boolean {

        when(item.itemId){
            R.id.navbar_home->{
                homeFragment= HomeFragment.newInstance()
                supportFragmentManager.beginTransaction().replace(R.id.main_nav_frame,homeFragment).commit()
            }
            R.id.navbar_complaint->{
                complaintFragment= ComplaintFragment.newInstance()
                supportFragmentManager.beginTransaction().replace(R.id.main_nav_frame,complaintFragment).commit()

            }

            R.id.navbar_announcement->{
                announcementListFragment= AnnouncementListFragment.newInstance()
                supportFragmentManager.beginTransaction().replace(R.id.main_nav_frame,announcementListFragment).commit()


            }
            R.id.navbar_settings->{
                settingsFragment= SettingsFragment.newInstance()
                supportFragmentManager.beginTransaction().replace(R.id.main_nav_frame,settingsFragment).commit()


            }
        }

        return true
    }
}