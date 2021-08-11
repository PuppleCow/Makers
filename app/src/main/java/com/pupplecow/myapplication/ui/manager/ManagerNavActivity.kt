package com.pupplecow.myapplication.ui.manager

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.MenuItem
import com.google.android.material.bottomnavigation.BottomNavigationView
import com.pupplecow.myapplication.R
import com.pupplecow.myapplication.SettingCheckSafetyManual
import com.pupplecow.myapplication.ui.manager.announcement.ManagerAnnouncementListFragment
import com.pupplecow.myapplication.ui.manager.Complaint.ManagerComplaintListFragment
import com.pupplecow.myapplication.ui.manager.home.ManagerHomeFragment
import com.pupplecow.myapplication.ui.manager.settings.ManagerSettingFragment
import com.pupplecow.myapplication.ui.safetyManual.SafetyManualFragment
import com.pupplecow.myapplication.ui.settings.SettingCheckSafetyManualFragment
import com.pupplecow.myapplication.ui.shopping.ShoppingFragment
import kotlinx.android.synthetic.main.activity_manager_nav.*

@Suppress("DEPRECATION")
class ManagerNavActivity : AppCompatActivity(), BottomNavigationView.OnNavigationItemSelectedListener {
    private lateinit var managerHomeFragment: ManagerHomeFragment
    private lateinit var managerComplaintListFragment: ManagerComplaintListFragment
    private lateinit var managerAnnouncementListFragment: ManagerAnnouncementListFragment
    private lateinit var settingCheckSafetyManualFragment: SettingCheckSafetyManualFragment
    private lateinit var managerSettingFragment: ManagerSettingFragment
    private lateinit var shoppingFragment: ShoppingFragment

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_manager_nav)

        manager_nav_bottom_van_bar.setOnNavigationItemSelectedListener(this)
        manager_nav_bottom_van_bar.selectedItemId=R.id.manager_navbar_home
    }
    override fun onNavigationItemSelected(item: MenuItem): Boolean {

        when(item.itemId){
            R.id.manager_navbar_home->{
                //supportFragmentManager?.popBackStack()
                managerHomeFragment= ManagerHomeFragment.newInstance()
                supportFragmentManager.beginTransaction().replace(R.id.manager_nav_frame,managerHomeFragment).addToBackStack(null).commit()


            }
            R.id.manager_navbar_safety_manual->{
                //supportFragmentManager?.popBackStack()
                settingCheckSafetyManualFragment= SettingCheckSafetyManualFragment.newInstance()
                supportFragmentManager.beginTransaction().replace(R.id.manager_nav_frame,settingCheckSafetyManualFragment).addToBackStack(null).commit()


            }
            R.id.manager_navbar_shopping->{
                //supportFragmentManager?.popBackStack()
                shoppingFragment= ShoppingFragment.newInstance()
                supportFragmentManager.beginTransaction().replace(R.id.manager_nav_frame,shoppingFragment).addToBackStack(null).commit()


            }
            R.id.manager_navbar_announcement->{
                //supportFragmentManager?.popBackStack()
                managerAnnouncementListFragment= ManagerAnnouncementListFragment.newInstance()
                supportFragmentManager.beginTransaction().replace(R.id.manager_nav_frame,managerAnnouncementListFragment).addToBackStack(null).commit()


            }
            R.id.manager_navbar_settings->{
                //supportFragmentManager?.popBackStack()
                managerSettingFragment= ManagerSettingFragment.newInstance()
                supportFragmentManager.beginTransaction().replace(R.id.manager_nav_frame,managerSettingFragment).addToBackStack(null).commit()


            }
        }

        return true
}
}



