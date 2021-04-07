package com.techpassmaster.recyclerviewwithmultipleviewtype.repository

import com.techpassmaster.recyclerviewwithmultipleviewtype.model.MainDataModel
import com.techpassmaster.recyclerviewwithmultipleviewtype.network.RetrofitBuilder

/**
 * Created by Techpass Master on 8-April-21.
 * Website - https://techpassmaster.com/
 * Email id - hello@techpassmaster.com
 */

class Repo {

//    fun for get all data from api
    suspend fun getDataFromAPI(): List<MainDataModel> = RetrofitBuilder.API_END_POINT.getData()

}