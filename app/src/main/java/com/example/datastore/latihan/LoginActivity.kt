package com.example.datastore.latihan

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.lifecycle.asLiveData
import com.example.datastore.R
import com.example.datastore.UserManager
import kotlinx.android.synthetic.main.activity_home.*
import kotlinx.android.synthetic.main.activity_login.*
import kotlinx.android.synthetic.main.activity_main.*

class LoginActivity : AppCompatActivity() {

    lateinit var userManagerLatihan : LatihanManager

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)

        userManagerLatihan = LatihanManager(this)

        btn_login.setOnClickListener {
            val username = et_username_login.text.toString()
            val password = et_password_login.text.toString()

            var usernamedatastore = ""
            var passworddatastore = ""

            userManagerLatihan.userUsername.asLiveData().observe(this,{
                usernamedatastore = it.toString()
            })

            userManagerLatihan.userPassword.asLiveData().observe(this,{
                passworddatastore = it.toString()
            })

            if (username == usernamedatastore && password == passworddatastore){
                startActivity(Intent(this, HomeActivity::class.java))
            }else{
                Toast.makeText(this, "Username atau Password Salah!", Toast.LENGTH_LONG).show()
            }

        }

        tv_buat_akun.setOnClickListener {
            startActivity(Intent(this, RegisterActivity::class.java))
        }

    }
}