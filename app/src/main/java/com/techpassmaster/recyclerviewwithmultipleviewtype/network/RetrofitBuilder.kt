package com.techpassmaster.recyclerviewwithmultipleviewtype.network
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

/**
 * Created by Techpass Master on 8-April-21.
 * Website - https://techpassmaster.com/
 * Email id - hello@techpassmaster.com
 */

class RetrofitBuilder {

    companion object
    {
        private val retrofit:Retrofit by lazy {
            Retrofit.Builder()
                .baseUrl(URLConstant.BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build()
        }

        val API_END_POINT: ApiEndPoint by lazy {
            retrofit.create(ApiEndPoint::class.java)
        }
    }
}