package com.techpassmaster.recyclerviewwithmultipleviewtype.model

import com.google.gson.annotations.SerializedName

/**
 * Created by Techpass Master on 8-April-21.
 * Website - https://techpassmaster.com/
 * Email id - hello@techpassmaster.com
 */


data class MainDataModel(
        @SerializedName("id")
        val id: String,
        @SerializedName("title")
        val title: String,
        @SerializedName("thumbnailUrl")
        val thumbnailUrl: String)
