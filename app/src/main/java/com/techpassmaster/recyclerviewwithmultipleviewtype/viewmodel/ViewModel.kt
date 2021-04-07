package com.techpassmaster.recyclerviewwithmultipleviewtype.viewmodel

import android.util.Log
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.techpassmaster.recyclerviewwithmultipleviewtype.model.MainDataModel
import com.techpassmaster.recyclerviewwithmultipleviewtype.repository.Repo
import kotlinx.coroutines.launch

/**
 * Created by Techpass Master on 8-April-21.
 * Website - https://techpassmaster.com/
 * Email id - hello@techpassmaster.com
 */

class ViewModel(private val repo: Repo) : ViewModel() {

    val response : MutableLiveData<List<MainDataModel>> = MutableLiveData()

    //    fun for get all data from repo
    fun getAllDataFromRepo() {
        viewModelScope.launch {

            try {
                val response = repo.getDataFromAPI()
                this@ViewModel.response.value = response
                Log.d("main", "Success")

            } catch (e: Exception) {
                Log.d("main", "getmsg- ${e.message}")
            }
        }
    }
}