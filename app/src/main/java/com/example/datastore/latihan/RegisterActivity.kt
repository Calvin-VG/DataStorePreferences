package com.example.datastore.latihan

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.datastore.R
import com.example.datastore.UserManager
import kotlinx.android.synthetic.main.activity_login.*
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.activity_register.*
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch

class RegisterActivity : AppCompatActivity() {

    lateinit var userManagerUser : LatihanManager

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_register)

        userManagerUser = LatihanManager(this)

        btn_register.setOnClickListener {
            val username = et_username_register.text.toString()
            val password = et_password_register.text.toString()

            GlobalScope.launch {
                userManagerUser.saveDataUser(username, password)
            }

            startActivity(Intent(this, LoginActivity::class.java))
        }

    }
}