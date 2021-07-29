package com.pupplecow.myapplication.ui.manager

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.MenuItem
import com.google.android.material.bottomnavigation.BottomNavigationView
import com.pupplecow.myapplication.R
import com.pupplecow.myapplication.ui.announcement.AnnouncmentListFragment
import com.pupplecow.myapplication.ui.complaint.ComplaintFragment
import com.pupplecow.myapplication.ui.home.HomeFragment
import com.pupplecow.myapplication.ui.manager.fragment.ManagerAnnouncementListFragment
import com.pupplecow.myapplication.ui.manager.fragment.ManagerComplaintListFragment
import com.pupplecow.myapplication.ui.manager.fragment.ManagerSettingsFragment
import com.pupplecow.myapplication.ui.manager.home.ManagerHomeFragment
import com.pupplecow.myapplication.ui.settings.SettingsFragment
import kotlinx.android.synthetic.main.activity_main_nav.*
import kotlinx.android.synthetic.main.activity_main_nav.main_nav_bottom_van_bar
import kotlinx.android.synthetic.main.activity_manager_nav.*

@Suppress("DEPRECATION")
class ManagerNavActivity : AppCompatActivity(), BottomNavigationView.OnNavigationItemSelectedListener {
    private lateinit var managerHomeFragment: ManagerHomeFragment
    private lateinit var managerComplaintListFragment: ManagerComplaintListFragment
    private lateinit var managerAnnouncementListFragment: ManagerAnnouncementListFragment
    private lateinit var managerSettingsFragment: ManagerSettingsFragment

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_manager_nav)

        manager_nav_bottom_van_bar.setOnNavigationItemSelectedListener(this)
        manager_nav_bottom_van_bar.selectedItemId=R.id.navbar_home
    }
    override fun onNavigationItemSelected(item: MenuItem): Boolean {

        when(item.itemId){
            R.id.navbar_home->{
                managerHomeFragment= ManagerHomeFragment.newInstance()
                supportFragmentManager.beginTransaction().replace(R.id.manager_nav_frame,managerHomeFragment).commit()
            }
            R.id.navbar_complaint->{
                managerComplaintListFragment= ManagerComplaintListFragment.newInstance()
                supportFragmentManager.beginTransaction().replace(R.id.manager_nav_frame,managerComplaintListFragment).commit()

            }
            R.id.navbar_announcement->{
                managerAnnouncementListFragment= ManagerAnnouncementListFragment.newInstance()
                supportFragmentManager.beginTransaction().replace(R.id.manager_nav_frame,managerAnnouncementListFragment).commit()

            }
            R.id.navbar_settings->{
                managerSettingsFragment= ManagerSettingsFragment.newInstance()
                supportFragmentManager.beginTransaction().replace(R.id.manager_nav_frame,managerSettingsFragment).commit()

            }
        }

        return true
}
}



