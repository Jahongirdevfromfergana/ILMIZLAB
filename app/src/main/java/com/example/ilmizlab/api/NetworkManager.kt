package com.example.ilmizlab.api

import com.chuckerteam.chucker.api.ChuckerInterceptor
import com.example.ilmizlab.BuildConfig
import com.example.ilmizlab.MyApp
import com.example.ilmizlab.utils.Constants
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory

object NetworkManager {

    var retrofit: Retrofit? = null
    var api: ApiService? = null

    fun getApiService(): ApiService {
        if (api == null) {
            val okHttpClient = OkHttpClient.Builder()
            if (BuildConfig.DEBUG) {
                okHttpClient.addInterceptor(ChuckerInterceptor.Builder(MyApp.app).build())
            }
            retrofit = Retrofit.Builder()
                .addConverterFactory(GsonConverterFactory.create())
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .baseUrl(Constants.BASE_URL)
                .client(okHttpClient.build())
                .build()
            api = retrofit!!.create(ApiService::class.java)
        }
        return api!!
    }
}