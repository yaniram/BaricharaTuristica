package com.yaniramonsalve.baricharaturismo.main

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuInflater
import android.view.MenuItem
import androidx.appcompat.app.ActionBar
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentTransaction
import com.yaniramonsalve.baricharaturismo.R
import com.yaniramonsalve.baricharaturismo.preference.SettingsFragment

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        val inflater: MenuInflater = menuInflater
        inflater.inflate(R.menu.overflow_menu, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {


        val fm : FragmentManager = supportFragmentManager
        val ft : FragmentTransaction = fm.beginTransaction()

        return when (item.itemId){
            R.id.menu_preferences -> {
                val settingsFragment = SettingsFragment()
                ft.replace(R.id.fragmentContainerView, settingsFragment).commit()
                ft.addToBackStack(null)
                true
            }
            android.R.id.home -> {
                onBackPressed()
                true
            }
            else -> {return true}
        }
    }

    fun showIcon(){
        val actionBar : ActionBar? = supportActionBar
        actionBar?.setDisplayHomeAsUpEnabled(true)
    }

    fun hideIcon() {
        val actionBar: ActionBar? = supportActionBar
        actionBar?.setDisplayHomeAsUpEnabled(false)

    }

}