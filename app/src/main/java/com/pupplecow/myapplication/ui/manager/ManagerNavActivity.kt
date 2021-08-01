package com.pupplecow.myapplication.ui.manager

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.MenuItem
import com.google.android.material.bottomnavigation.BottomNavigationView
import com.pupplecow.myapplication.R
import com.pupplecow.myapplication.ui.manager.announcement.ManagerAnnouncementListFragment
import com.pupplecow.myapplication.ui.manager.Complaint.ManagerComplaintListFragment
import com.pupplecow.myapplication.ui.manager.home.ManagerHomeFragment
import com.pupplecow.myapplication.ui.manager.settings.ManagerSettingFragment
import kotlinx.android.synthetic.main.activity_manager_nav.*

@Suppress("DEPRECATION")
class ManagerNavActivity : AppCompatActivity(), BottomNavigationView.OnNavigationItemSelectedListener {
    private lateinit var managerHomeFragment: ManagerHomeFragment
    private lateinit var managerComplaintListFragment: ManagerComplaintListFragment
    private lateinit var managerAnnouncementListFragment: ManagerAnnouncementListFragment
    private lateinit var managerSettingFragment: ManagerSettingFragment

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_manager_nav)

        manager_nav_bottom_van_bar.setOnNavigationItemSelectedListener(this)
        manager_nav_bottom_van_bar.selectedItemId=R.id.navbar_home
    }
    override fun onNavigationItemSelected(item: MenuItem): Boolean {

        when(item.itemId){
            R.id.navbar_home->{
                supportFragmentManager?.popBackStack()
                managerHomeFragment= ManagerHomeFragment.newInstance()
                supportFragmentManager.beginTransaction().replace(R.id.manager_nav_frame,managerHomeFragment).commit()

            }
            R.id.navbar_complaint->{
                supportFragmentManager?.popBackStack()
                managerComplaintListFragment= ManagerComplaintListFragment.newInstance()
                supportFragmentManager.beginTransaction().replace(R.id.manager_nav_frame,managerComplaintListFragment).commit()

            }
            R.id.navbar_announcement->{
                supportFragmentManager?.popBackStack()
                managerAnnouncementListFragment= ManagerAnnouncementListFragment.newInstance()
                supportFragmentManager.beginTransaction().replace(R.id.manager_nav_frame,managerAnnouncementListFragment).commit()

            }
            R.id.navbar_settings->{
                supportFragmentManager?.popBackStack()
                managerSettingFragment= ManagerSettingFragment.newInstance()
                supportFragmentManager.beginTransaction().replace(R.id.manager_nav_frame,managerSettingFragment).commit()

            }
        }

        return true
}
}



