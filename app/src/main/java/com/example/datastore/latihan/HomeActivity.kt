package com.example.datastore.latihan

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.asLiveData
import com.example.datastore.R
import com.example.datastore.UserManager
import kotlinx.android.synthetic.main.activity_home.*
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch

class HomeActivity : AppCompatActivity() {

    lateinit var userManager : LatihanManager

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home)

        userManager = LatihanManager(this)

//        Baca & ambil data nama dari datastore
        userManager.userUsername.asLiveData().observe(this,{
            tv_username_home.text = it.toString()
        })

//        Menghapus data dari datastore
        btn_logout.setOnClickListener {
            GlobalScope.launch{
                userManager.clearData()
            }

            startActivity(Intent(this, LoginActivity::class.java))
        }

    }
}