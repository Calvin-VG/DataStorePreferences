package com.example.datastore

import android.content.Context
import androidx.datastore.DataStore
import androidx.datastore.preferences.clear
import androidx.datastore.preferences.createDataStore
import androidx.datastore.preferences.edit
import androidx.datastore.preferences.preferencesKey
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map

class UserManager(context: Context) {

    private val dataStore : DataStore<androidx.datastore.preferences.Preferences> = context.createDataStore("user_prefs")

    companion object{
        val NAMA = preferencesKey<String>("USER_NAMA")
        val UMUR = preferencesKey<Int>("USER_UMUR")
    }

    suspend fun saveData(nama: String, umur: Int){
        dataStore.edit{
            it[NAMA] = nama
            it [UMUR] = umur
        }
    }

    val userNama : Flow<String> = dataStore.data.map {
        it[NAMA] ?: ""
    }

    val userUmur : Flow<Int> = dataStore.data.map {
        it[UMUR] ?: 0
    }

//    Hapus data dari datasore
    suspend fun clearData(){
        dataStore.edit{
            it.clear()
        }
    }

}