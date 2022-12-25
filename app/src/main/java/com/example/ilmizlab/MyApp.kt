package com.example.ilmizlab

import androidx.multidex.MultiDex
import androidx.multidex.MultiDexApplication


class MyApp: MultiDexApplication() {

    companion object{
        lateinit var app: MyApp
    }

    override fun onCreate() {
        super.onCreate()
        MultiDex.install(this)
        app = this
    }


// shu loyihani papkada korsating  ok
}