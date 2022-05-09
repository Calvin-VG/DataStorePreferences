package com.example.datastore.latihan

import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import androidx.lifecycle.asLiveData
import com.example.datastore.R
import kotlinx.android.synthetic.main.activity_login.*

class SplashActivity : AppCompatActivity() {

    lateinit var userUserManager : LatihanManager

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash)

        userUserManager = LatihanManager(this)

        var usernamedatastore = ""
        var passworddatastore = ""

        userUserManager.userUsername.asLiveData().observe(this,{
            usernamedatastore = it.toString()
        })

        userUserManager.userPassword.asLiveData().observe(this,{
            passworddatastore = it.toString()
        })

        Handler().postDelayed({
            if (usernamedatastore.isNullOrEmpty() && passworddatastore.isNullOrEmpty()){
                startActivity(Intent(this, LoginActivity::class.java))
            }else{
                startActivity(Intent(this, HomeActivity::class.java))
            }
        }, 3000)

    }
}