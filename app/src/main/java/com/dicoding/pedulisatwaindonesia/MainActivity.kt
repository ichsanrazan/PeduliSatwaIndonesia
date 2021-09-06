package com.dicoding.pedulisatwaindonesia

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity(), View.OnClickListener {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        supportActionBar?.hide()
        val btnHome : Button = findViewById(R.id.btn_login)
        btnHome.setOnClickListener(this)

    }

    override fun onClick(v: View?) {
        when(v?.id){
            R.id.btn_login -> {
                val homeAct = Intent(this@MainActivity, HomeActivity::class.java)
                startActivity(homeAct)
            }
        }
    }
}