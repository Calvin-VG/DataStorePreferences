package com.example.datastore

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.asLiveData
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch

class MainActivity : AppCompatActivity() {

    lateinit var userManager : UserManager

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        userManager = UserManager(this)

//        Menyimpan data ke datastore
        btn_simpan.setOnClickListener {
            val nama = et_nama.text.toString()
            val umur = et_umur.text.toString().toInt()

            GlobalScope.launch {
                userManager.saveData(nama, umur)
            }
        }

//        Baca data nama dari datastore
        userManager.userNama.asLiveData().observe(this,{
            tv_nama.text = it.toString()
        })

//        Baca data umur dari datastore
        userManager.userUmur.asLiveData().observe(this,{
            tv_umur.text = it.toString()
        })

//        Menghapus data dari datastore
        btn_hapus.setOnClickListener {
            GlobalScope.launch{
                userManager.clearData()
            }
        }

    }

    override fun onResume() {
        super.onResume()
    }

    override fun onDestroy() {
        super.onDestroy()
    }
}