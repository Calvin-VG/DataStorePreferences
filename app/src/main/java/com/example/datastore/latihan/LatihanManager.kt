package com.example.datastore.latihan

import android.content.Context
import androidx.datastore.DataStore
import androidx.datastore.preferences.*
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map

class LatihanManager(context: Context) {

    private val dataStore : DataStore<Preferences> = context.createDataStore("USER_PREFERENCES")

    companion object{
        val USERNAME = preferencesKey<String>("USERNAME")
        val PASSWORD = preferencesKey<String>("PASSWORD")
    }

    suspend fun saveDataUser(username: String, password: String){
        dataStore.edit{
            it[USERNAME] = username
            it [PASSWORD] = password
        }
    }

    val userUsername : Flow<String> = dataStore.data.map {
        it[USERNAME] ?: ""
    }

    val userPassword : Flow<String> = dataStore.data.map {
        it[PASSWORD] ?: ""
    }

    //    Hapus data dari datasore
    suspend fun clearData(){
        dataStore.edit{
            it.clear()
        }
    }

}