package com.dicoding.pedulisatwaindonesia

import android.content.Intent
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import androidx.appcompat.app.AppCompatActivity
import com.dicoding.pedulisatwaindonesia.animal.AnimalFragment
import kotlinx.android.synthetic.main.activity_home.*

class HomeActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home)

        setViewPager()
    }
    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        menuInflater.inflate(R.menu.menu_main, menu)
        return super.onCreateOptionsMenu(menu)
    }
    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        setMode(item.itemId)
        return super.onOptionsItemSelected(item)
    }
    private fun setMode(selectedMode: Int) {
        when (selectedMode) {
            R.id.action_about -> {
                val iAbout = Intent(this@HomeActivity, AboutActivity::class.java)
                startActivity(iAbout)
            }
        }
    }

    private fun setViewPager() {
        val fragmentList = listOf(AnimalFragment())
        viewpager.adapter = ViewpagerAdapter(fragmentList, this.supportFragmentManager, lifecycle)

    }
}