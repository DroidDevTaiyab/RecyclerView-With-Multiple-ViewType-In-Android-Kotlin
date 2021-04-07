package com.techpassmaster.recyclerviewwithmultipleviewtype.network

import com.techpassmaster.recyclerviewwithmultipleviewtype.model.MainDataModel
import retrofit2.http.GET

/**
 * Created by Techpass Master on 8-April-21.
 * Website - https://techpassmaster.com/
 * Email id - hello@techpassmaster.com
 */

interface ApiEndPoint {

    @GET("photos")
    suspend fun getData() : List<MainDataModel>

}